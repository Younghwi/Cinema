package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentBean;
import model.CommentDAO;
import model.Join05;
import model.Join05DAO;
import model.MovieBean;
import model.MovieDAO;
public class MovieDetailViewController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		System.out.println(this.getClass());
		
		int mvid = Integer.parseInt(request.getParameter("mvid"));
		System.out.println(request.getParameter("mvid"));

		MovieDAO mdao = new MovieDAO();
		MovieBean bean = mdao.SelectDataPK(mvid);
		request.setAttribute("bean", bean);
		
		//영화별 한줄평 조회하기
		Join05DAO j5dao = new Join05DAO();
		List<Join05> j5lists = j5dao.SelectDataList(mvid);
		request.setAttribute("j5lists", j5lists);
		
		String url = "/movie/MovieDetailView.jsp" ;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}