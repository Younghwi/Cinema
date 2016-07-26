package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.TheatherBean;
import model.TheatherDAO;



public class TheatherInsertController implements SuperController {
	
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;

		TheatherBean bean = new TheatherBean();
		
		String tname = multi.getParameter("tname");
		int startseat = Integer.parseInt(multi.getParameter("startseat"));
		int endseat = Integer.parseInt(multi.getParameter("endseat"));
		int price = Integer.parseInt(multi.getParameter("price"));
		String timage = multi.getFilesystemName("timage");
		
		
		bean.setTname(tname);
		bean.setStartseat(startseat);
		bean.setEndseat(endseat);
		bean.setPrice(price);
		bean.setTimage(timage);
		
		System.out.println(timage);
		TheatherDAO tdao = new TheatherDAO();

		int cnt = -99999 ;
		cnt = tdao.InsertTheather(bean);
		
		String url = "/main.jsp" ;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
	
}
