package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBean;
import model.UserDAO;
public class UserIdcheckController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id") ;
		
		UserDAO udao = new UserDAO() ;
		UserBean bean = udao.SelectDataPK(id) ;
		if ( bean == null ) { 
			request.setAttribute("message", id + "��(��) ��� ������ ���̵��Դϴ�.") ;
			request.setAttribute("isCheck", true) ;
		}else{
			request.setAttribute("message", id + "��(��) �̹� ������� ���̵��Դϴ�.") ;
			request.setAttribute("isCheck", false) ;
		}
		String url = "/user/idCheck.jsp";  
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
