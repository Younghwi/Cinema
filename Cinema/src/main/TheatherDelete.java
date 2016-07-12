package main;

import model.TheatherDAO;

public class TheatherDelete {
	public static void main(String[] args) {
		System.out.println("영화관 삭제하기");
		int id = 8;
		
		TheatherDAO tdao = new TheatherDAO();
		int cnt = -99999;
		cnt = tdao.DeleteTheater(id);
		
		if (cnt == -99999) {
			System.out.println("영화관 삭제 실패");
		} else {
			System.out.println("영화관 삭제 성공");
		}
	}
}
