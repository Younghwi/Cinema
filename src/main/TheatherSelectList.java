package main;

import java.util.List;

import model.TheatherBean;
import model.TheatherDAO;
import model.UserBean;


public class TheatherSelectList{
	public static void main(String[] args) {
		System.out.println("��ȭ�� ������ ��� ��ȸ");
		TheatherDAO tdao = new TheatherDAO();
		List<TheatherBean> tlists = tdao.SelectTheather();
		if (tlists.size() == 0) {
			System.out.println("ã���ô� �����Ͱ� �����ϴ�");
		} else {
			for (TheatherBean member : tlists) {
				System.out.println(member.toString());
			}
		}
	}
}
