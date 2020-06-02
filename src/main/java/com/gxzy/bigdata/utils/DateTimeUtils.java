package com.gxzy.bigdata.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间相关工具
 * @author wwenquan
 * @date Jan 14, 2019
 */
@Component
public class DateTimeUtils {

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前标准格式化日期时间
	 * @param date
	 * @return
	 */
	public String getDateTime() {
		return getDateTime(new Date());
	}
	
	/**
	 * 标准格式化日期时间
	 * @param date
	 * @return
	 */
	public String getDateTime(Date date) {
		return (new SimpleDateFormat(DATE_FORMAT)).format(date);
	}

	/**
	 * 指定格式化日期
	 * @param date
	 * @return
	 */
	public String getDefinedDateTime(String dateFormat, Date date) {
		return (new SimpleDateFormat(dateFormat)).format(date);
	}
}
