package main;

import java.util.List;
import model.Join02;
import model.Join02DAO;

public class Join02SelectListPk {
	public static void main(String[] args) {
		System.out.println("아이디별 조회 고고싱 ");
		System.out.println("예매번호, 예매자, 예매영화, 예매일자, 예매수량, 총 금액 조회");
	
		
		Join02DAO jdao = new Join02DAO();
		String id = "wony";
		List<Join02> joinList = jdao.SelectDataList(id);
		
		if(joinList.size() == 0){
			
		}else{
			for(Join02 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
