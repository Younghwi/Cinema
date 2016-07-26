package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;


public class PlayScheduleInsertController implements SuperController {
	
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlayScheduleBean bean = new PlayScheduleBean();
		
		bean.setMvid(Integer.parseInt(request.getParameter("mvid")));
		bean.setTid(Integer.parseInt(request.getParameter("tid")));
		bean.setPlaydate(request.getParameter("playdate"));
		bean.setStarttime(request.getParameter("starttime"));
		bean.setPsorder(Integer.parseInt(request.getParameter("psorder")));
		
		String url = "";
		
		url = "/main.jsp" ;
		
		PlayScheduleDAO pdao = new PlayScheduleDAO();
		int cnt = -99999 ;
		cnt = pdao.InsertPlaySchedule(bean);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
	
}
