package main;

import model.UserDAO;

public class UserDelete {
	public static void main(String[] args) {
		System.out.println("User 삭제하기");
		String id = "testuser";
		
		UserDAO udao = new UserDAO();
		int cnt = -99999;
		cnt = udao.DeleteUser(id);
		
		if (cnt == -99999) {
			System.out.println("User 삭제 실패");
		} else {
			System.out.println("User 삭제 성공");
		}
	}
}
