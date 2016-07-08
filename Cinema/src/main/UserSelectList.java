package main;

import java.util.List;

import model.UserDAO;
import model.UserBean;


public class UserSelectList {
	public static void main(String[] args) {
		System.out.println("User 데이터 모두 조회");
		UserDAO udao = new UserDAO();
		List<UserBean> ulists = udao.SelectDataList();
		if (ulists.size() == 0) {
			System.out.println("찾으시는 데이터가 없습니다");
		} else {
			for (UserBean member : ulists) {
				System.out.println(member.toString());
			}
		}
	}
}
