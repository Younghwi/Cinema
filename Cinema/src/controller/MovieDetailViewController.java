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
import utility.Paging;
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
		
		//페이징처리하기
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		Join05DAO j5dao = new Join05DAO();
		String contextPath = request.getContextPath();
		String myurl = contextPath+"/CinemaCtrl?command=moDetailView&mvid="+ mvid;
		
		CommentDAO cdao = new CommentDAO();
		
		int totalCount = cdao.SelectTotalCount(mvid);
		
		Paging pageinfo = new Paging(pageNumber, pageSize, totalCount, myurl);
		
		//영화별 한줄평 조회하기
		
		System.out.println("시작번호"+pageinfo.getBeginRow());
		System.out.println("끝번호"+pageinfo.getEndRow());
		List<Join05> j5lists = j5dao.SelectDataList(mvid, pageinfo.getBeginRow(), pageinfo.getEndRow());
		request.setAttribute("j5lists", j5lists);
		//페이징 관련 항목들
		request.setAttribute("pagingHtml", pageinfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageinfo.getPagingStatus());
		
		String url = "/movie/MovieDetailView.jsp" ;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}