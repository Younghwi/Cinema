package main;

import java.util.List;

import model.Join06;
import model.Join06DAO;

public class Join06SelectList {
	public static void main(String[] args) {

		System.out.println("��¥�� ��ȭ��ȸ");
		String playdate = "20160725";
		
		Join06DAO j6dao = new Join06DAO();
		List<Join06> joinList = j6dao.SelectDataList(playdate);
		
		if(joinList.size() == 0){
			System.out.println("�����0");
		}else{
			for(Join06 bean : joinList){
				System.out.println(bean.toString());
			}
		}
		
	}
}
