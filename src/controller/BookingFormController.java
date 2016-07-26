package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Join03;
import model.Join03DAO;
import model.Join06;
import model.Join06DAO;
import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class BookingFormController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("bookForm 페이지");
		
		Date date = new Date();

		//System.out.println(date.toString());

		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);

		String defaultdate = sdf1.format(date);
		
		String mvid_imsi = request.getParameter("mvid");
		String psorder_imsi = request.getParameter("psorder");
		String _playdate = request.getParameter("date");
		String playdate = "";
		
		
		if(_playdate == null){
			playdate = defaultdate;
		}
		
		System.out.println("zzzzzzz"+playdate);
		if(_playdate != null){
		playdate=_playdate;
		}
		
		System.out.println("기본 날짜"+playdate);
		//영화정보 불러들이기
		MovieDAO mdao = new MovieDAO();
		List<MovieBean> mlists = mdao.SelectDataList();
		
		//
		Join06DAO j6dao = new Join06DAO();
		List<Join06> j6lists = j6dao.SelectDataList(playdate);
		
		//영화별로 상영스케줄 불러들이기
		Join03DAO j3dao = new Join03DAO();
		
		
		
		int mvid = 0;
		int psorder = 0;
		
		if(mvid_imsi != null){
			mvid = Integer.parseInt(mvid_imsi);
			if(psorder_imsi != null){
				psorder = Integer.parseInt(psorder_imsi);
			}
		}
		System.out.println("z"+mvid);
		System.out.println(psorder);
		
		
		List<Join03> j3lists = j3dao.SelectDataList(mvid, playdate);
		
		Join03 j3bean = j3dao.SelectDataList(mvid, psorder, playdate);
		System.out.println("zz"+j6lists);
		request.setAttribute("mvid", mvid);
		request.setAttribute("j3bean", j3bean);
		request.setAttribute("j6lists", j6lists);
		request.setAttribute("mlists", mlists);
		request.setAttribute("j3lists", j3lists);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("bean", session);
		
		String url = "/book/BookingForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
