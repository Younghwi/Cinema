package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookBean;
import model.BookDAO;
import model.BookDetailBean;
import model.BookDetailDAO;
import model.Join02;
import model.Join02DAO;
import model.MovieBean;
import model.MovieDAO;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;

public class BookingController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("book 페이지");

		Date date = new Date();

		System.out.println(date.toString());

		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);

		String bookdate = sdf1.format(date);

		String mid = request.getParameter("mid");
		int mvid = Integer.parseInt(request.getParameter("mvid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int sno = Integer.parseInt(request.getParameter("sno"));
		String _seatno = request.getParameter("hiddenseat");

		String[] sp = _seatno.split(",");

		for (int i = 0; i < sp.length; i++) {
			System.out.println(sp[i]);
		}

		BookDAO bdao = new BookDAO();

		BookBean bbean = new BookBean();
		bbean.setMid(mid);
		bbean.setMvid(mvid);
		bbean.setTid(tid);
		bbean.setBookdate(bookdate);
		bbean.setAmount(amount);

		bdao.InsertBook(bbean);

		System.out.println(bbean.toString());

		Join02DAO j2dao = new Join02DAO();
		Join02 j2bean = j2dao.SelectDataList(mid, bookdate);

		int bno = j2bean.getBno();
		System.out.println("예약번호" + bno);

		for(int i=0;  i<sp.length;i++){
		BookDetailBean bdbean = new BookDetailBean();
		bdbean.setBno(bno);
		bdbean.setSno(sno);
		bdbean.setSeatno(sp[i]);

		BookDetailDAO bddao = new BookDetailDAO();
		bddao.InsertMovie(bdbean);
		}
		
		System.out.println("1번:"+mid);
		request.setAttribute("mid", mid);
		System.out.println("2번:"+mid);
		new UserBookingListController().doProcess(request, response);
		
/*		String url = "/user/UserBookingList.jsp?id="+mid;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);*/
	}

}
