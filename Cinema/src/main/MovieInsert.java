package main;

import model.MovieBean;
import model.MovieDAO;

public class MovieInsert {
	public static void main(String[] args) {
		System.out.println("Movie Insert하기");
		MovieDAO mdao = new MovieDAO();
		MovieBean movie = new MovieBean();
		movie.setMvid(3);
		movie.setMname("도리를 찾아서");
		movie.setOpendate("20160706");
		movie.setDirector("앤드류 스탠튼");
		movie.setGenre("애니메이션");
		movie.setPlayingtime(97);
		movie.setStory("“내가 누구라고? 도리? 도리!” 무엇을 상상하든 그 이상을 까먹는 ‘도리’의 어드벤쳐가 시작된다!");
		movie.setRating("전체 관람가");
		movie.setDistributor("월트 디즈니");
		movie.setActor("엘런 드제너러스(도리 목소리 역), 헤이든 롤렌스(니모 목소리 역), 앨버트 브룩스(말린 목소리 역), 에드 오닐(행크 목소리 역)");
		movie.setCondition(2);
		movie.setStringImage("dori.jpg");
		

		
		
		int cnt = -99999;
				
		cnt = mdao.InsertMovie(movie);
		
		if (cnt == -99999) {
			System.out.println("Movie 입력 실패");
		} else if (cnt == -1400){
			System.out.println("Not null 제약 조건 위배");
		} else if (cnt == -1){
			System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
		} else {
			System.out.println("Movie 입력 성공");
		}
	}
}
