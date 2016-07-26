package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentBean;
import model.CommentDAO;
import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class CommentInsertController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("comment 입력 컨트롤러");
		
		Date date = new Date();
		
		System.out.println(date.toString());
		
		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);
		
		String writedate = sdf1.format(date);
		System.out.println(writedate);
		
		
		String mid = request.getParameter("mid");
		int mvid = Integer.parseInt(request.getParameter("mvid"));
		String comments = request.getParameter("comments");
		int starpoint = Integer.parseInt(request.getParameter("starScore"));
		
		MovieDAO mdao = new MovieDAO();
		MovieBean mbean = mdao.SelectDataPK(mvid);
		request.setAttribute("bean", mbean);
		
		CommentBean bean = new CommentBean();
		//bean.setCno(cno);
		bean.setMid(mid);
		bean.setMvid(mvid);
		bean.setComments(comments);
		bean.setStarpoint(starpoint);
		bean.setWritedate(writedate);
		
		CommentDAO cdao = new CommentDAO();
		cdao.InsertComment(bean);
		
		System.out.println(mid +"/"+ mvid +"/"+ comments +"/"+ starpoint);
		
		
		new MovieDetailViewController().doProcess(request, response);
		/*String url = "/movie/MovieDetailView.jsp?mvid=1";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);*/
	}

	
}
