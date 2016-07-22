package main;

import model.TheatherBean;
import model.TheatherDAO;

public class TheatherInsert {
	public static void main(String[] args) {
		System.out.println("영화관 insert하기");
		TheatherDAO tdao = new TheatherDAO();
		TheatherBean tbean = new TheatherBean();
		tbean.setTid(8);
		tbean.setTname("테관");
		tbean.setStartseat(1);
		tbean.setEndseat(10);
		tbean.setPrice(30000);
		tbean.setTimage("8");
		
		int cnt = -99999;
		
		cnt = tdao.InsertTheather(tbean);
		
		if (cnt == -99999) {
			System.out.println("영화관 입력 실패");
		} else if (cnt == -1400){
			System.out.println("Not null 제약 조건 위배");
		} else if (cnt == -1){
			System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
		} else {
			System.out.println("영화관 입력 성공");
		}
	}
}
