package com.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * 
 * @ClassName: DBUtil.java
 * @Description: 连接MySQL数据库
 *
 * @version: v1.0.0
 * @author: 童梦君
 * @date: 2020年11月4日 下午4:25:37
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020年11月4日 童梦君 v1.0.0 修改原因
 */
public class DBUtil {
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "bill";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "admin";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}
}

