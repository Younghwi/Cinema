package main;

import java.util.List;
import model.Join04;
import model.Join04DAO;

public class Join04SelectList {
	public static void main(String[] args) {
		System.out.println("상영관, 상영회차, 예매 좌석 조회");
		
		Join04DAO jdao = new Join04DAO();
		List<Join04> joinList = jdao.SelectDataList();
		
		if(joinList.size() == 0){
			
		}else{
			for(Join04 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
