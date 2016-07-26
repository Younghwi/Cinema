package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.Zipcode;

public class UserZipcheckController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dong = request.getParameter("dong") ;
		List<Zipcode>  lists = null ;
		UserDAO udao = new UserDAO() ;
		if ( dong != null ) {
			lists = udao.SelectDataZipcode(dong) ;
			System.out.println( "µ¿³× ¼ö: " + lists.size() );
		}		 
		request.setAttribute( "lists", lists );
		String url = "/user/zipCheck.jsp";  
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
