package main;

import java.util.List;

import model.Join05;
import model.Join05DAO;

public class Join05SelectListPK {

	public static void main(String[] args) {
		System.out.println("영화이름별 조회 하겠습니다ㅋㅋ ");
		System.out.println("영화이름,작성자 아이디,작성일자,한줄평 조회");
		System.out.println("시스템 가동 준비 완료");
		
		Join05DAO jdao = new Join05DAO();
		//String mname = "컨저링2";
		int mvid = 2;
		
		List<Join05> joinList = jdao.SelectDataList(mvid);
		
		if(joinList.size() == 0){
			
		}else{
			for(Join05 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}
}
