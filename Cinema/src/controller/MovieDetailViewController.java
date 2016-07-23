package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		String url = "/movie/MovieDetailView.jsp" ;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}