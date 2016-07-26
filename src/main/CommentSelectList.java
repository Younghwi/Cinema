package main;

import java.util.List;

import model.CommentBean;
import model.CommentDAO;


public class CommentSelectList {

	public static void main(String[] args) {

		System.out.println("Comment 데이터 모두 조회");
		CommentDAO cdao = new CommentDAO();
		List<CommentBean> clists = cdao.SelectDataList();
		if (clists.size() == 0) {
			System.out.println("찾으시는 데이터가 없습니다");
		} else {
			for (CommentBean comment : clists) {
				System.out.println(comment.toString());
			}
		}
		
	}

}
