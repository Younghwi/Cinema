package main;

import model.CommentBean;
import model.CommentDAO;

public class CommentUpdate {

	public static void main(String[] args) {

	      System.out.println("Comment 수정하기");
	      CommentDAO cdao = new CommentDAO();
	      CommentBean comment = new CommentBean();
	      
			comment.setCno(5);
			comment.setMid("cufe");
			comment.setMvid(1);
			comment.setComments("ㅎ ㅎ ㅎ ㅎ");
			comment.setWritedate("16/07/05");
			comment.setStarpoint(3);
			
	      int cnt = -99999;
	      
	      cnt = cdao.UpdateComment(comment);
	      
	      if (cnt == -99999) {
	         System.out.println("Commnet 수정 실패");
	      } else if (cnt == -1400){
	         System.out.println("Not null 제약 조건 위배");
	      } else if (cnt == -1){
	         System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
	      } else {
	         System.out.println("Comment 수정 성공");
	      }
	}

}
