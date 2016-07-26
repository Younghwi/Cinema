package main;

import java.util.List;
import model.Join03;
import model.Join03DAO;

public class Join03SelectListPk {
	public static void main(String[] args) { 
		System.out.println("영화별로 조회 ");
		System.out.println("상영관, 예매영화, 상영일자, 상영시간, 상영회차 조회");
		System.out.println("시스템 가동 준비 완료");
		
		Join03DAO jdao = new Join03DAO();
		int mvid = 2;
		
		List<Join03> joinList = jdao.SelectDataList(mvid);
		
		if(joinList.size() == 0){
			
		}else{
			for(Join03 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
