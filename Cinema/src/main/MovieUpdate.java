package main;

import model.MovieBean;
import model.MovieDAO;

public class MovieUpdate {
   public static void main(String[] args) {
      System.out.println("Movie �����ϱ�");
      MovieDAO mdao = new MovieDAO();
      MovieBean movie = new MovieBean();
      movie.setMvid(3);
		movie.setMname("������ ã�Ƽ�");
		movie.setOpendate("20160706");
		movie.setDirector("�尨��");
		movie.setGenre("�ִϸ��̼�");
		movie.setPlayingtime(97);
		movie.setStory("������ �������? ����? ����!�� ������ ����ϵ� �� �̻����� �� �Դ� ���������� ��庥�İ� ���۵ȴ�!");
		movie.setRating("��ü ������");
		movie.setDistributor("��Ʈ �����");
		movie.setActor("����(���� ��Ҹ� ��), �ƿ�(�ϸ� ��Ҹ� ��), ����(���� ��Ҹ� ��), �⿵ (��ũ ��Ҹ� ��)");
		movie.setCondition(2);
		movie.setStringImage("dori.jpg");
      
	int cnt = -99999;
      
      cnt = mdao.UpdateMovie(movie);
      
      if (cnt == -99999) {
         System.out.println("Movie ���� ����");
      } else if (cnt == -1400){
         System.out.println("Not null ���� ���� ����");
      } else if (cnt == -1){
         System.out.println("primary ���� ���� ����"); //����� ���� exception �����
      } else {
         System.out.println("Movie ���� ����");
      }
   }
}