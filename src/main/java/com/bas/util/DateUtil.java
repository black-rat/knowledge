package com.bas.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 使用java8 新的日期类处理 java.time
 * @author lizhao
 *
 */
public class DateUtil {
	
	public static final String COMPACT_DATE_FORMAT_PATTETN="yyyyMMdd";
	public static final String DATETIME_FORMAT_PATTENT="yyyy-MM-dd HH:mm";
	
	/**
	 * 得到 yyyy-MM-dd 格式
	 * @return
	 */
	public static String getCurrentDateAsString(){
		 LocalDate taday=LocalDate.now();
		 return taday.toString();
	}
	/**
	 * 得到指定格式string 日期字符串
	 * @param date
	 * @return
	 */
	public static String getCurrentDateAsString(String pattern){
		DateTimeFormatter df=DateTimeFormatter.ofPattern(pattern);	
		return df.format(LocalDate.now());
	};
	/**
	 * 得到 yyyy-MM-dd HH:mm 时间String 字符串
	 * @return
	 */
	public static String getCurrentDateTimeAsString(){
		DateTimeFormatter df=DateTimeFormatter.ofPattern(DateUtil.DATETIME_FORMAT_PATTENT);	
		return df.format(LocalDateTime.now());
	}
  public static void main(String[] args) {
        System.out.println(DateUtil.getCurrentDateTimeAsString());
	  
  }
}
