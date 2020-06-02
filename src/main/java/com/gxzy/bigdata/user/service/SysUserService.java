package com.gxzy.bigdata.user.service;


import com.gxzy.bigdata.core.page.PageRequest;
import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.user.model.SysUser;
import com.gxzy.bigdata.user.model.SysUserRole;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 用户管理
 * @author wwenquan
 * @date Jan 13, 2019
 */
public interface SysUserService extends CurdService<SysUser> {

	/*
	*	根据用户名查用户
	*/
	SysUser findByName(String username);

	//查找所有用户
	List<SysUser> findAllUser();

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName);

	/**
	 * 查找用户的角色集合
	 * @param userName
	 * @return
	 */
	List<SysUserRole> findUserRoles(Long userId);

	/**
	 * 生成用户信息Excel文件
	 * @param pageRequest 要导出的分页查询参数
	 * @return
	 */
	File createUserExcelFile(PageRequest pageRequest);

}
