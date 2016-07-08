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
			System.out.println("����̹� �ε�");
			this.conn = getConnection();
			if (conn != null) {
				System.out.println("���Ἲ��");
			} else {
				System.out.println("�������");
				closeConnection();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() { //Ŀ�ؼ� ��ü�� �����ִ� �޼ҵ�
		try {
			return DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void closeConnection(){ //Ŀ�ؼ� ��ü�� ������ ó������ �޼ҵ�
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
