package main;

import java.util.List;

import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class PlaysSheduleSelectList {
	
	public static void main(String[] args) {
		System.out.println("PlaysShedule ������ ��� ��ȸ");
		PlayScheduleDAO psdao = new PlayScheduleDAO();
		
		List<PlayScheduleBean> lists = psdao.SelectDataList();
		
		if (lists.size() == 0) {
			System.out.println("ã���ô� �����Ͱ� �����ϴ�");
		} else {
			for (PlayScheduleBean bean  : lists) {
				System.out.println(bean.toString());
			}
		}
	
	
	}

}
