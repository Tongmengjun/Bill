package com.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil.java
 * @Description: 日期工具
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月3日 下午5:24:02
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月3日 童梦君 v1.0.0 修改原因
 */
public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;// 1天的毫秒数

	// 将util的日期类型转化为sql的类日期类型
	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/*
	 * 获取今天,并且把时分秒都置为0，因为通过日期控件得到的日期没有时分秒
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();// 获取Calendar对象
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/*
	 * 获取月初。使用Calendar获取本月第一天。 在统计消费一览信息的时候，查看本月的消费数据，
	 * 其实就是从数据库中去把从本月第一天到最后一天的数据查出来，再进行简单统计，所以需要一个获取本月第一天的方法。
	 */
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();

	}

	/*
	 * 获取月末
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		// 将时间设定为今天包含年-月-日-小时-分钟-秒
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		// 设置为月末,先增加一天到月初，然后增加一个月到下一个月,然后再减一天到上个月月末
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	/*
	 * 获取本月一共有多少天
	 */
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	/*
	 * 获取本月还剩多少天
	 */
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}
}

