package main;

import java.util.List;

import model.UserDAO;
import model.UserBean;


public class UserSelectList {
	public static void main(String[] args) {
		System.out.println("User ������ ��� ��ȸ");
		UserDAO udao = new UserDAO();
		List<UserBean> ulists = udao.SelectDataList();
		if (ulists.size() == 0) {
			System.out.println("ã���ô� �����Ͱ� �����ϴ�");
		} else {
			for (UserBean member : ulists) {
				System.out.println(member.toString());
			}
		}
	}
}
