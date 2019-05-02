package com.meeting.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	/**
	 * DB 접속 메소드
	 * @return connection DB연결객체
	 */
	public static Connection getConnection() {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "meeting";
		String pw = "gsm1234";
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection(url, id, pw);
			
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBUtil.getConnection() : " + e.toString());
		}
		
		return null;
		
	}	
	
	/**
	 * 인자값을 받아 DB 접속하는 메소드
	 * @param server 서버IP
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @return connection DB연결객체
	 */
	public static Connection getConnection(String server, String id, String pw) {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@"+server+":1521:xe";
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection(url, id, pw);
			
			return conn;

		} catch (Exception e) {
			System.out.println("DBUtil.getConnection() : " + e.toString());
		}
		
		return null;
		
	}	
	
}
