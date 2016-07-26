package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDAO;
import utility.Validator;

public class UserDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id = request.getParameter("id") ;
			
			
			UserDAO udao = new UserDAO();			
			int cnt = -99999 ; 			
			//Bean 객체를 이용하여 해당 게시물을 추가한다.
			cnt = udao.DeleteUser(id) ;
			
			HttpSession session = request.getSession();
			
			session.invalidate(); //세션 정보를 없애주는 메소드.
			//response.sendRedirect("http://localhost:8888/ShoppingLab/main.jsp");
			response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
}
