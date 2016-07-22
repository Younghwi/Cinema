package main;

import model.TheatherBean;
import model.TheatherDAO;

public class TheatherUpdate {
   public static void main(String[] args) {
      System.out.println("영화관 수정하기");
      TheatherDAO tdao = new TheatherDAO();
      TheatherBean tbean = new TheatherBean();
      
      tbean.setTname("테");
      tbean.setStartseat(3);
      tbean.setEndseat(8);
      tbean.setPrice(7000);
      tbean.setTimage("8");
      tbean.setTid(8);
      
   int cnt = -99999;
      
      cnt = tdao.UpdateTheater(tbean);
      
      if (cnt == -99999) {
         System.out.println("영화관 수정 실패");
      } else if (cnt == -1400){
         System.out.println("Not null 제약 조건 위배");
      } else if (cnt == -1){
         System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
      } else {
         System.out.println("영화관 수정 성공");
      }
   }
}