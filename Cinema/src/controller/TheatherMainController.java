package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TheatherBean;
import model.TheatherDAO;

public class TheatherMainController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("예매하기 페이지");
		TheatherDAO mdao = new TheatherDAO();
		
		List<TheatherBean> lists = mdao.SelectTheather();
		
		request.setAttribute("lists", lists);
		
		String url = "/Theathers/TheaThersMain.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	
}
