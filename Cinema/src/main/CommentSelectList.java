package main;

import java.util.List;

import model.CommentBean;
import model.CommentDAO;


public class CommentSelectList {

	public static void main(String[] args) {

		System.out.println("Comment ������ ��� ��ȸ");
		CommentDAO cdao = new CommentDAO();
		List<CommentBean> clists = cdao.SelectDataList();
		if (clists.size() == 0) {
			System.out.println("ã���ô� �����Ͱ� �����ϴ�");
		} else {
			for (CommentBean comment : clists) {
				System.out.println(comment.toString());
			}
		}
		
	}

}
