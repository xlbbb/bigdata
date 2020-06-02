package com.gxzy.bigdata.user.service;


import com.gxzy.bigdata.core.service.CurdService;
import com.gxzy.bigdata.user.model.SysConfig;

import java.util.List;

/**
 * 系统配置管理
 * @author wwenquan
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
