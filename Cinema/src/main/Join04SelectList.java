package main;

import java.util.List;
import model.Join04;
import model.Join04DAO;

public class Join04SelectList {
	public static void main(String[] args) {
		System.out.println("�󿵰�, ��ȸ��, ���� �¼� ��ȸ");
		
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
