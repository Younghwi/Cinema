package main;

import model.UserBean;
import model.UserDAO;

public class UserUpdate {
   public static void main(String[] args) {
      System.out.println("User �����ϱ�");
      UserDAO udao = new UserDAO();
      UserBean user = new UserBean();
      user.setId("testuser");
      user.setPassword("123123123");
      user.setName("��Ʈ");
      user.setGender("����");
      user.setBirth("19000101");
      user.setZipcode("222-222");
      user.setAddress1("�����");
      user.setAddress2("������");
      user.setPhone("01012345678");
      user.setPoint(99999);
      user.setGrade("VIP");
      
      int cnt = -99999;
      
      cnt = udao.UpdateUser(user);
      
      if (cnt == -99999) {
         System.out.println("User ���� ����");
      } else if (cnt == -1400){
         System.out.println("Not null ���� ���� ����");
      } else if (cnt == -1){
         System.out.println("primary ���� ���� ����"); //����� ���� exception �����
      } else {
         System.out.println("User ���� ����");
      }
   }
}