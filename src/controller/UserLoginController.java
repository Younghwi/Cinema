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
		System.out.println("�α��� ��Ʈ�ѷ� ����!");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("�Ѿ�� : " + id+"/" + password);
		UserDAO udao = new UserDAO();
		UserBean bean = udao.SelectDataPK(id);
		System.out.println("�����ͺ��̽���: " + bean.getId()+"/" +bean.getPassword());
		String url = "";
		String msg = "";
		
		if (bean == null) { // �������� �ʴ� ���̵�
			url = "/main.jsp";
			msg = "���̵� ��й�ȣ�� �߸��Ǿ����ϴ�.";
		} else {
			if (password.equals(bean.getPassword())) { // ��й�ȣ ����
				url = "/main.jsp";
				msg = "�α��� ����.";
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", bean);
				System.out.println("�α��μ���");
			} else {
				url = "/main.jsp";
				msg = "���̵� ��й�ȣ�� �� �� �Ǿ����ϴ�.";
				System.out.println("���Ʋ��");
				request.setAttribute("errmsg", msg);
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
