package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Join04;
import model.Join04DAO;
import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class BookingSeatFormController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("bookseat 페이지");
		
		int row = Integer.parseInt(request.getParameter("row"));
		int col = Integer.parseInt(request.getParameter("col"));
		int price = Integer.parseInt(request.getParameter("price"));
		int psorder = Integer.parseInt(request.getParameter("psorder"));
		String playdate = request.getParameter("date");
		
		Join04DAO join04dao = new Join04DAO();
		List<Join04> j4bean = join04dao.SelectDataList(psorder, playdate);
		
		String[] seatArray = new String[j4bean.size()];
		int count = 0;
		for(Join04 bean : j4bean) {
			seatArray[count] = bean.getSeatno();
			count++;
		}
		String totalSeat = "";
		for(String str : seatArray){
			System.out.println(str+"/");
			totalSeat += str + ",";
		}
		int leng = j4bean.size();
		System.out.println("길이" + leng);
		System.out.println(totalSeat);
		request.setAttribute("price", price);
		request.setAttribute("row", row);
		request.setAttribute("col", col);
		request.setAttribute("totalSeat", totalSeat);
		
		request.setAttribute("seatArray", seatArray);
		
		String url = "/book/BookingSeatForm.jsp?ts=" + totalSeat + "&leng=" + leng;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}
