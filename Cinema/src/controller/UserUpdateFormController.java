package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDAO;
public class UserUpdateFormController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id") ;
		UserDAO udao =  new UserDAO() ;
		UserBean bean = udao.SelectDataPK(id);
		
		System.out.println( this.getClass() + bean.toString());
		request.setAttribute( "bean", bean ); 
		System.out.println("여기 들어와?");
			
		String url = "/user/UserUpdateForm.jsp";  
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
