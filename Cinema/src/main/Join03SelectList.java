package main;

import java.util.List;
import model.Join03;
import model.Join03DAO;

public class Join03SelectList {
	public static void main(String[] args) {
		System.out.println("상영관, 예매영화, 상영일자, 상영시간, 상영회차 조회");
		
		Join03DAO jdao = new Join03DAO();
		List<Join03> joinList = jdao.SelectDataList();
		
		if(joinList.size() == 0){
			
		}else{
			for(Join03 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
