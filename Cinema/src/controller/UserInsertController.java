package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDAO;
import utility.Validator;

public class UserInsertController implements SuperController, Validator{
	private HttpServletRequest request ;
	private UserBean bean = null ;
		
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request ; 
		
		bean  = new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setPassword(request.getParameter("password"));
		bean.setName(request.getParameter("name"));
		bean.setGender(request.getParameter("gender"));
		bean.setBirth(request.getParameter("birth"));
		bean.setAddress1(request.getParameter("address1"));
		bean.setAddress2(request.getParameter("address2"));
		bean.setPhone(request.getParameter("phone"));
		if( request.getParameter("point") != null && request.getParameter("point") != "" ){
			bean.setPoint(Integer.parseInt(request.getParameter("point")));
		}
		bean.setGrade(request.getParameter("grade"));

		System.out.println( bean );

		String url = "";
		if ( this.validate() == false ) {
			url = "/user/UserInsertForm.jsp";  
			this.request.setAttribute("bean", bean);
		}else{
			url = "/user/UserLoginForm.jsp";
			//DAO ��ü�� �����Ѵ�.
			UserDAO udao = new UserDAO();			
			int cnt = -99999 ; 			
			//Bean ��ü�� �̿��Ͽ� �ش� �Խù��� �߰��Ѵ�.
			cnt = udao.InsertUser(bean) ;
		}
		System.out.println( request.getAttribute("bean") );
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(this.request, response);		
	}
	
	@Override
	public boolean validate() {
		final String PREFIX = "err" ;
		boolean isCheck = true ; //�⺻ ������ true�̰�, ��ȿ�� �˻翡 ������ ����� false���� ����
		
		//Member err = new Member() ; 
		if( bean.getId().length() < 4 || bean.getId().length() > 10 ){
			this.request.setAttribute( PREFIX + "id", "���̵�� 4�ڸ� �̻� 10�ڸ� �����̾�� �մϴ�.");
			isCheck = false  ;
		}
		if( bean.getName().length() < 2 || bean.getName().length() > 10 ){
			this.request.setAttribute( PREFIX + "name", "�̸��� 2�ڸ� �̻� 10�ڸ� �����̾�� �մϴ�.");
			isCheck = false  ;
		}
		if( bean.getPassword().length() < 4 || bean.getPassword().length() > 10 ){
			this.request.setAttribute( PREFIX + "password", "��� ��ȣ�� 4�ڸ� �̻� 10�ڸ� �����̾�� �մϴ�.");
			isCheck = false  ;
		}
		if( bean.getGender() == null){
			this.request.setAttribute( PREFIX + "gender", "������ �ݵ�� üũ�� �Ǿ�� �մϴ�.	");
			isCheck = false  ;
		}
	
		if( bean.getAddress1() == null || bean.getAddress1() == "" ){
			this.request.setAttribute( PREFIX + "address1", "�ּҴ� �ʼ� �����Դϴ�.");
			isCheck = false  ;
		}
		return isCheck ;
	}
	
}
