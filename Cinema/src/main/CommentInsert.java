package main;

import model.CommentBean;
import model.CommentDAO;

public class CommentInsert {

	public static void main(String[] args) {

		System.out.println("Comment Insert�ϱ�");
		CommentDAO cdao = new CommentDAO();
		CommentBean comment = new CommentBean();
		
		comment.setCno(5);
		comment.setMid("cufe");
		comment.setMvid(1);
		comment.setComments("��̾���");
		comment.setWritedate("16/07/05");
		comment.setStartpoint(3);		

		
		int cnt = -99999;
		
		cnt = cdao.InsertComment(comment);
		
		if (cnt == -99999) {
			System.out.println("Comment �Է� ����");
		} else if (cnt == -1400){
			System.out.println("Not null ���� ���� ����");
		} else if (cnt == -1){
			System.out.println("primary ���� ���� ����"); //����� ���� exception �����
		} else {
			System.out.println("Comment �Է� ����");
		}
	}

}
