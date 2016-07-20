package main;

import java.util.List;

import model.Join05;
import model.Join05DAO;

public class Join05SelectList {
	public static void main(String[] args) {

		System.out.println("영화이름,작성자 아이디,작성일자,한줄평 조회");
		//
		Join05DAO jdao = new Join05DAO();
		List<Join05> joinList = jdao.SelectDataList();
		
		if(joinList.size() == 0){
			
		}else{
			for(Join05 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}
}
