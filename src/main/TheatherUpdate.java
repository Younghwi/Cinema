package main;

import model.TheatherBean;
import model.TheatherDAO;

public class TheatherUpdate {
   public static void main(String[] args) {
      System.out.println("��ȭ�� �����ϱ�");
      TheatherDAO tdao = new TheatherDAO();
      TheatherBean tbean = new TheatherBean();
      
      tbean.setTname("��");
      tbean.setStartseat(3);
      tbean.setEndseat(8);
      tbean.setPrice(7000);
      tbean.setTimage("8");
      tbean.setTid(8);
      
   int cnt = -99999;
      
      cnt = tdao.UpdateTheater(tbean);
      
      if (cnt == -99999) {
         System.out.println("��ȭ�� ���� ����");
      } else if (cnt == -1400){
         System.out.println("Not null ���� ���� ����");
      } else if (cnt == -1){
         System.out.println("primary ���� ���� ����"); //����� ���� exception �����
      } else {
         System.out.println("��ȭ�� ���� ����");
      }
   }
}