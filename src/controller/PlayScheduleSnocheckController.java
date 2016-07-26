package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PlayScheduleBean;
import model.PlayScheduleDAO;
public class PlayScheduleSnocheckController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sno = request.getParameter("sno") ;
		System.out.println("������� ������?");
		PlayScheduleDAO pdao = new PlayScheduleDAO() ;
		PlayScheduleBean bean = pdao.SelectDataPK(sno) ;
		if ( bean == null ) { 
			request.setAttribute("message", sno + "��(��) ��� ������ ������ȣ�Դϴ�.") ;
			request.setAttribute("isCheck", true) ;
		}else{
			request.setAttribute("message", sno + "��(��) �̹� ������� ������ȣ�Դϴ�.") ;
			request.setAttribute("isCheck", false) ;
		}
		String url = "/movie/snoCheck.jsp";  
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
