package main;

import model.TheatherBean;
import model.TheatherDAO;

public class TheatherInsert {
	public static void main(String[] args) {
		System.out.println("��ȭ�� insert�ϱ�");
		TheatherDAO tdao = new TheatherDAO();
		TheatherBean tbean = new TheatherBean();
		tbean.setTid(8);
		tbean.setTname("�װ�");
		tbean.setStartseat(1);
		tbean.setEndseat(10);
		tbean.setPrice(30000);
		tbean.setTimage("8");
		
		int cnt = -99999;
		
		cnt = tdao.InsertTheather(tbean);
		
		if (cnt == -99999) {
			System.out.println("��ȭ�� �Է� ����");
		} else if (cnt == -1400){
			System.out.println("Not null ���� ���� ����");
		} else if (cnt == -1){
			System.out.println("primary ���� ���� ����"); //����� ���� exception �����
		} else {
			System.out.println("��ȭ�� �Է� ����");
		}
	}
}
