package com.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * 
 * @ClassName: DBUtil.java
 * @Description: ����MySQL���ݿ�
 *
 * @version: v1.0.0
 * @author: ͯ�ξ�
 * @date: 2020��11��4�� ����4:25:37
 *
 *        Modification History: Modification History: Date Author Version
 *        Description
 *        ----------------------------------------------------------------*
 *        2020��11��4�� ͯ�ξ� v1.0.0 �޸�ԭ��
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

