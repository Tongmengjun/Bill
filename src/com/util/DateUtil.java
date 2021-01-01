package com.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil.java
 * @Description: ���ڹ���
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��3�� ����5:24:02
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020��11��3�� ͯ�ξ� v1.0.0 �޸�ԭ��
 */
public class DateUtil {
	static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;// 1��ĺ�����

	// ��util����������ת��Ϊsql������������
	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/*
	 * ��ȡ����,���Ұ�ʱ���붼��Ϊ0����Ϊͨ�����ڿؼ��õ�������û��ʱ����
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();// ��ȡCalendar����
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/*
	 * ��ȡ�³���ʹ��Calendar��ȡ���µ�һ�졣 ��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ��������ݣ�
	 * ��ʵ���Ǵ����ݿ���ȥ�Ѵӱ��µ�һ�쵽���һ������ݲ�������ٽ��м�ͳ�ƣ�������Ҫһ����ȡ���µ�һ��ķ�����
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
	 * ��ȡ��ĩ
	 */
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		// ��ʱ���趨Ϊ���������-��-��-Сʱ-����-��
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		// ����Ϊ��ĩ,������һ�쵽�³���Ȼ������һ���µ���һ����,Ȼ���ټ�һ�쵽�ϸ�����ĩ
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	/*
	 * ��ȡ����һ���ж�����
	 */
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}

	/*
	 * ��ȡ���»�ʣ������
	 */
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMilliSeconds = today().getTime();
		return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
	}
}

