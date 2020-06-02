package com.gxzy.bigdata.user.service;


import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.user.model.SysMenu;
import com.gxzy.bigdata.user.model.SysRole;
import com.gxzy.bigdata.user.model.SysRoleMenu;

import java.util.List;

/**
 * 角色管理
 * @author wwenquan
 * @date Jan 13, 2019
 */
public interface SysRoleService extends CurdService<SysRole> {

	/**
	 * 查询全部
	 * @return
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<SysMenu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<SysRoleMenu> records);

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<SysRole> findByName(String name);

}
