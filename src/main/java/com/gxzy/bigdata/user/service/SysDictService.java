package com.gxzy.bigdata.user.service;

import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.user.model.SysDict;

import java.util.List;

/**
 * 字典管理
 * @author wwenquan
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByAny(String lable, String type);
}
