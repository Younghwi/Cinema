package main;

import java.util.List;

import model.Join01;
import model.Join01DAO;

public class Join01SelectList {
	public static void main(String[] args) {
		System.out.println("���Ź�ȣ, ������, ���ſ�ȭ, ��������, ������, ��ȸ��, �󿵰�, �����¼� ��ȸ");
		
		Join01DAO jdao = new Join01DAO();
		List<Join01> joinList = jdao.SelectDataList();
		
		if(joinList.size() == 0){
			
		}else{
			for(Join01 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}

}
