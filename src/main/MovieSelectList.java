package main;

import java.util.List;

import model.MovieDAO;
import model.MovieBean;


public class MovieSelectList {
	public static void main(String[] args) {
		System.out.println("Movie 데이터 모두 조회");
		MovieDAO mdao = new MovieDAO();
		List<MovieBean> mlists = mdao.SelectDataList();
		if (mlists.size() == 0) {
			System.out.println("찾으시는 데이터가 없습니다");
		} else {
			for (MovieBean member : mlists) {
				System.out.println(member.toString());
			}
		}
	}
}
