package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class BookingFormController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("예매하기 페이지");
		
		MovieDAO mdao = new MovieDAO();
		List<MovieBean> mlists = mdao.SelectDataList();
		
		PlayScheduleDAO psdao = new PlayScheduleDAO();
		
		//int mvid = Integer.parseInt(request.getParameter("mvid"));
		
		List<PlayScheduleBean> pslists = psdao.SelectDataList(1);
		
		request.setAttribute("mlists", mlists);
		request.setAttribute("pslists", pslists);
		
		HttpSession session = request.getSession();
		session.setAttribute("bean", session);
		
		String url = "/book/Booking.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
