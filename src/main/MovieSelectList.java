package main;

import java.util.List;

import model.MovieDAO;
import model.MovieBean;


public class MovieSelectList {
	public static void main(String[] args) {
		System.out.println("Movie ������ ��� ��ȸ");
		MovieDAO mdao = new MovieDAO();
		List<MovieBean> mlists = mdao.SelectDataList();
		if (mlists.size() == 0) {
			System.out.println("ã���ô� �����Ͱ� �����ϴ�");
		} else {
			for (MovieBean member : mlists) {
				System.out.println(member.toString());
			}
		}
	}
}
