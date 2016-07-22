package main;

import model.UserBean;
import model.UserDAO;

public class UserUpdate {
   public static void main(String[] args) {
      System.out.println("User 수정하기");
      UserDAO udao = new UserDAO();
      UserBean user = new UserBean();
      user.setId("testuser");
      user.setPassword("123123123");
      user.setName("고스트");
      user.setGender("여자");
      user.setBirth("19000101");
      user.setZipcode("222-222");
      user.setAddress1("서울시");
      user.setAddress2("강남구");
      user.setPhone("01012345678");
      user.setPoint(99999);
      user.setGrade("VIP");
      
      int cnt = -99999;
      
      cnt = udao.UpdateUser(user);
      
      if (cnt == -99999) {
         System.out.println("User 수정 실패");
      } else if (cnt == -1400){
         System.out.println("Not null 제약 조건 위배");
      } else if (cnt == -1){
         System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
      } else {
         System.out.println("User 수정 성공");
      }
   }
}