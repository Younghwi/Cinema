package main;

import java.util.List;

import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class PlaysSheduleSelectList {
	
	public static void main(String[] args) {
		System.out.println("PlaysShedule 데이터 모두 조회");
		PlayScheduleDAO psdao = new PlayScheduleDAO();
		
		List<PlayScheduleBean> lists = psdao.SelectDataList();
		
		if (lists.size() == 0) {
			System.out.println("찾으시는 데이터가 없습니다");
		} else {
			for (PlayScheduleBean bean  : lists) {
				System.out.println(bean.toString());
			}
		}
	
	
	}

}
