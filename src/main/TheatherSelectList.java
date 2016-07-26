package main;

import java.util.List;

import model.TheatherBean;
import model.TheatherDAO;
import model.UserBean;


public class TheatherSelectList{
	public static void main(String[] args) {
		System.out.println("영화관 데이터 모두 조회");
		TheatherDAO tdao = new TheatherDAO();
		List<TheatherBean> tlists = tdao.SelectTheather();
		if (tlists.size() == 0) {
			System.out.println("찾으시는 데이터가 없습니다");
		} else {
			for (TheatherBean member : tlists) {
				System.out.println(member.toString());
			}
		}
	}
}
