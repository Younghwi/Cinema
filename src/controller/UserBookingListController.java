package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Join01;
import model.Join01DAO;

public class UserBookingListController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			System.out.println("user booking List!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			
			String mid = request.getParameter("mid");
			System.out.println(mid);
			
			Join01DAO j1dao = new Join01DAO();
			
			List<Join01> lists = j1dao.SelectDataList(mid);
			
			request.setAttribute("lists", lists);
			
			
			String url = "/user/UserBookingList.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}
}
