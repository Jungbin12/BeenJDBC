package com.been.jdbc.day03.pstmt.member.common;

import java.sql.*;

public class JDBCTemplate {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "BEENJDBC";
	private final String PASSWORD = "BEENJDBC";
	
	private static JDBCTemplate instance;
	private JDBCTemplate() {};
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	// 원래는 Connection 싱글톤 패턴을 적용해서 생성된 연결을 재사용해야하지만
	// 몇 줄의 코드로 구현할 수 없다
	// 나중에는 Connection Pool 라이브러리를 사용해서 한 번 생성된 연결을 재사용하게 된다
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
