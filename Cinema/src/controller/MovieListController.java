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

public class MovieListController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("영화 보기 페이지");
		
		HttpSession session = request.getSession();
		session.setAttribute("bean", session);
		
		MovieDAO mdao = new MovieDAO();
		
		List<MovieBean> lists = mdao.SelectDataList();
		
		request.setAttribute("lists", lists);
		
		
		String url = "/movie/MovieList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
