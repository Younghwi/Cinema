package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Join03;
import model.Join03DAO;
import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class BookingFormController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("bookForm 페이지");
		
		
		//영화정보 불러들이기
		MovieDAO mdao = new MovieDAO();
		List<MovieBean> mlists = mdao.SelectDataList();
		
		//영화별로 상영스케줄 불러들이기
		Join03DAO j3dao = new Join03DAO();
		
		String mvid_imsi = request.getParameter("mvid");
		String psorder_imsi = request.getParameter("psorder");
		int mvid = 0;
		int psorder = 0;
		
		if(mvid_imsi != null){
			mvid = Integer.parseInt(mvid_imsi);
			if(psorder_imsi != null){
				psorder = Integer.parseInt(psorder_imsi);
			}
		}
		System.out.println(mvid);
		System.out.println(psorder);
		
		
		List<Join03> j3lists = j3dao.SelectDataList(mvid);
		
		Join03 j3bean = j3dao.SelectDataList(mvid, psorder);
		
		request.setAttribute("mvid", mvid);
		request.setAttribute("j3bean", j3bean);
		request.setAttribute("mlists", mlists);
		request.setAttribute("j3lists", j3lists);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("bean", session);
		
		String url = "/book/BookingForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
