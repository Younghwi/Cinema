package main;

import java.util.List;
import model.Join02;
import model.Join02DAO;

public class Join02SelectListPk {
	public static void main(String[] args) {
		System.out.println("���̵� ��ȸ ���� ");
		System.out.println("���Ź�ȣ, ������, ���ſ�ȭ, ��������, ���ż���, �� �ݾ� ��ȸ");
	
		
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
