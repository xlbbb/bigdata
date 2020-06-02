package com.gxzy.bigdata.user.service;


import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.user.model.SysDept;

import java.util.List;

/**
 * 机构管理
 * @author wwenquan
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
