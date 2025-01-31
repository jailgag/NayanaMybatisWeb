package com.tmybatis.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "KH";
	private static final String PASSWORD = "KH";
	//JDBCTemplate 객체 싱글톤적용
	private static JDBCTemplate instance;
	
	
	private JDBCTemplate() {//아무나접근못하게private로!!
		//2.번여기안에서 드라이버등록!
		//만들고 연결을 만들러 Connection으로 이동!3번으로
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JDBCTemplate getInstance() {
		//무조건만드는것이 아니라 instance가 null일때만 만들어 지도록 아래코드!!
		if(instance == null)
		instance = new JDBCTemplate();
		return instance;
		//여기위까지 싱글톤패턴적용이된것!!그다음 드라이버등록2.로이동
	}
	//3.번 !!연결 생성 메소드 - getConnection()생성!
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
