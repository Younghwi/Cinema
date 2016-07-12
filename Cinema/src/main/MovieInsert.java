package main;

import model.MovieBean;
import model.MovieDAO;

public class MovieInsert {
	public static void main(String[] args) {
		System.out.println("Movie Insert�ϱ�");
		MovieDAO mdao = new MovieDAO();
		MovieBean movie = new MovieBean();
		movie.setMvid(3);
		movie.setMname("������ ã�Ƽ�");
		movie.setOpendate("20160706");
		movie.setDirector("�ص�� ����ư");
		movie.setGenre("�ִϸ��̼�");
		movie.setPlayingtime(97);
		movie.setStory("������ �������? ����? ����!�� ������ ����ϵ� �� �̻��� ��Դ� ���������� ��庥�İ� ���۵ȴ�!");
		movie.setRating("��ü ������");
		movie.setDistributor("��Ʈ �����");
		movie.setActor("���� �����ʷ���(���� ��Ҹ� ��), ���̵� �ѷ���(�ϸ� ��Ҹ� ��), �ٹ�Ʈ ��轺(���� ��Ҹ� ��), ���� ����(��ũ ��Ҹ� ��)");
		movie.setCondition(2);
		movie.setStringImage("dori.jpg");
		

		
		
		int cnt = -99999;
				
		cnt = mdao.InsertMovie(movie);
		
		if (cnt == -99999) {
			System.out.println("Movie �Է� ����");
		} else if (cnt == -1400){
			System.out.println("Not null ���� ���� ����");
		} else if (cnt == -1){
			System.out.println("primary ���� ���� ����"); //����� ���� exception �����
		} else {
			System.out.println("Movie �Է� ����");
		}
	}
}
