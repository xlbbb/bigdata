package com.gxzy.bigdata.user.controller;

import com.gxzy.bigdata.core.http.HttpResult;
import com.gxzy.bigdata.core.page.PageRequest;
import com.gxzy.bigdata.user.constant.SysConstants;
import com.gxzy.bigdata.user.model.SysUser;
import com.gxzy.bigdata.user.service.SysUserService;
import com.gxzy.bigdata.user.util.PasswordUtils;
import com.gxzy.bigdata.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysUser record) {
		SysUser user = sysUserService.findById(record.getId());
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		if(record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();
			if(user == null) {
				// 新增用户
				if(sysUserService.findByName(record.getName()) != null) {
					return HttpResult.error("用户名已存在!");
				}
				String password = PasswordUtils.encode(record.getPassword(), salt);
				record.setSalt(salt);
				record.setPassword(password);
			} else {
				// 修改用户, 且修改了密码
				if(!record.getPassword().equals(user.getPassword())) {
					String password = PasswordUtils.encode(record.getPassword(), salt);
					record.setSalt(salt);
					record.setPassword(password);
				}
			}
		}
		return HttpResult.ok(sysUserService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:user:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysUser> records) {
		for(SysUser record:records) {
			SysUser sysUser = sysUserService.findById(record.getId());
			if(sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
				return HttpResult.error("超级管理员不允许删除!");
			}
		}
		return HttpResult.ok(sysUserService.delete(records));
	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findByName")
	public HttpResult findByUserName(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findByName(name));
	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findPermissions")
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findPermissions(name));
	}
	
	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findUserRoles")
	public HttpResult findUserRoles(@RequestParam Long userId) {
		return HttpResult.ok(sysUserService.findUserRoles(userId));
	}

	@PreAuthorize("hasAuthority('sys:user:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.findPage(pageRequest));
	}

	@PostMapping(value="/exportExcelUser")
	public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
		File file = sysUserService.createUserExcelFile(pageRequest);
		FileUtils.downloadFile(res, file, file.getName());
	}
}
