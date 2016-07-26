package main;

import model.MovieBean;
import model.MovieDAO;

public class MovieUpdate {
   public static void main(String[] args) {
      System.out.println("Movie 수정하기");
      MovieDAO mdao = new MovieDAO();
      MovieBean movie = new MovieBean();
      movie.setMvid(3);
		movie.setMname("워리를 찾아서");
		movie.setOpendate("20160706");
		movie.setDirector("장감독");
		movie.setGenre("애니메이션");
		movie.setPlayingtime(97);
		movie.setStory("“내가 누구라고? 워리? 워리!” 무엇을 상상하든 그 이상으로 잘 먹는 ‘워리’의 어드벤쳐가 시작된다!");
		movie.setRating("전체 관람가");
		movie.setDistributor("월트 디즈니");
		movie.setActor("원희(워리 목소리 역), 아영(니모 목소리 역), 영휘(말린 목소리 역), 기영 (행크 목소리 역)");
		movie.setCondition(2);
		movie.setStringImage("dori.jpg");
      
	int cnt = -99999;
      
      cnt = mdao.UpdateMovie(movie);
      
      if (cnt == -99999) {
         System.out.println("Movie 수정 실패");
      } else if (cnt == -1400){
         System.out.println("Not null 제약 조건 위배");
      } else if (cnt == -1){
         System.out.println("primary 제약 조건 위배"); //사용자 정의 exception 만들기
      } else {
         System.out.println("Movie 수정 성공");
      }
   }
}