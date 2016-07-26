package main;

import model.MovieDAO;

public class MovieDelete {
	public static void main(String[] args) {
		System.out.println("Movie 삭제하기");
		int mvid = 3;
		
		MovieDAO mdao = new MovieDAO();
		int cnt = -99999;
		cnt = mdao.DeleteMovie(mvid);
		
		if (cnt == -99999) {
			System.out.println("Movie 삭제 실패");
		} else {
			System.out.println("Movie 삭제 성공");
		}
	}
}
