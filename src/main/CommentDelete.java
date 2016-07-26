package main;

import model.CommentDAO;

public class CommentDelete {

	public static void main(String[] args) {
		System.out.println("Comment 삭제하기");
		int cno = 5;
		
		CommentDAO cdao = new CommentDAO();
		int cnt = -99999;
		cnt = cdao.DeleteComment(cno);
		
		if (cnt == -99999) {
			System.out.println("Comment 삭제 실패");
		} else {
			System.out.println("Comment 삭제 성공");
		}
		
	}

}
