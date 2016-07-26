package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDAO;

public class UserLogoutController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�α��� ��Ʈ�ѷ� ����!");

		HttpSession session = request.getSession();
		
		session.invalidate(); //���� ������ �����ִ� �޼ҵ�.
		//response.sendRedirect("http://localhost:8888/ShoppingLab/main.jsp");
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}

}
