package main;

import java.util.List;
import model.Join03;
import model.Join03DAO;

public class Join03SelectList {
	public static void main(String[] args) {
		System.out.println("�󿵰�, ���ſ�ȭ, ������, �󿵽ð�, ��ȸ�� ��ȸ");
		
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
