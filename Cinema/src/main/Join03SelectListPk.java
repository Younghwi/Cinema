package main;

import java.util.List;
import model.Join03;
import model.Join03DAO;

public class Join03SelectListPk {
	public static void main(String[] args) { 
		System.out.println("�󿵰��� ��ȸ �ϰڽ��ϴ٤��� ");
		System.out.println("�󿵰�, ���ſ�ȭ, ������, �󿵽ð�, ��ȸ�� ��ȸ");
		System.out.println("�ý��� ���� �غ� �Ϸ�");
		
		Join03DAO jdao = new Join03DAO();
		String tname = "1��";
		List<Join03> joinList = jdao.SelectDataList(tname);
		
		if(joinList.size() == 0){
			
		}else{
			for(Join03 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
