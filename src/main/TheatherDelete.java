package main;

import model.TheatherDAO;

public class TheatherDelete {
	public static void main(String[] args) {
		System.out.println("��ȭ�� �����ϱ�");
		int id = 8;
		
		TheatherDAO tdao = new TheatherDAO();
		int cnt = -99999;
		cnt = tdao.DeleteTheater(id);
		
		if (cnt == -99999) {
			System.out.println("��ȭ�� ���� ����");
		} else {
			System.out.println("��ȭ�� ���� ����");
		}
	}
}
