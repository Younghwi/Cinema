package main;

import java.util.List;

import model.Join05;
import model.Join05DAO;

public class Join05SelectListPK {

	public static void main(String[] args) {
		System.out.println("��ȭ�̸��� ��ȸ �ϰڽ��ϴ٤��� ");
		System.out.println("��ȭ�̸�,�ۼ��� ���̵�,�ۼ�����,������ ��ȸ");
		System.out.println("�ý��� ���� �غ� �Ϸ�");
		
		Join05DAO jdao = new Join05DAO();
		//String mname = "������2";
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
