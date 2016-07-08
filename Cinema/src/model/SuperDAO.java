package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDAO {
	protected Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "cinema";
	private String pwd = "cinema";
	
	public SuperDAO() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩");
			this.conn = getConnection();
			if (conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
				closeConnection();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() { //커넥션 객체를 구해주는 메소드
		try {
			return DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void closeConnection(){ //커넥션 객체가 없을때 처리해줄 메소드
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
