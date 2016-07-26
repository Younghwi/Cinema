package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDAO;

public class UserLoginController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 컨트롤러 접근!");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("넘어간값 : " + id+"/" + password);
		UserDAO udao = new UserDAO();
		UserBean bean = udao.SelectDataPK(id);
		System.out.println("데이터베이스값: " + bean.getId()+"/" +bean.getPassword());
		String url = "";
		String msg = "";
		
		if (bean == null) { // 존재하지 않는 아이디
			url = "/main.jsp";
			msg = "아이디나 비밀번호가 잘못되었습니다.";
		} else {
			if (password.equals(bean.getPassword())) { // 비밀번호 맞음
				url = "/main.jsp";
				msg = "로그인 성공.";
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", bean);
				System.out.println("로그인성공");
			} else {
				url = "/main.jsp";
				msg = "아이디나 비밀번호가 잘 못 되었습니다.";
				System.out.println("비번틀림");
				request.setAttribute("errmsg", msg);
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
