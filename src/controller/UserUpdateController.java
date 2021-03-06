package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDAO;
import utility.Validator;

public class UserUpdateController implements SuperController, Validator{
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
		bean.setZipcode(request.getParameter("zipcode"));
		bean.setAddress1(request.getParameter("address1"));
		bean.setAddress2(request.getParameter("address2"));
		bean.setPhone(request.getParameter("phone"));
		if( request.getParameter("point") != null && request.getParameter("point") != "" ){
			bean.setPoint(Integer.parseInt(request.getParameter("point")));
		}
		bean.setGrade(request.getParameter("grade"));

		System.out.println("어디널이야!1번" + bean );

		String url = "";
		if ( this.validate() == false ) {
			url = "/user/UserUpdateForm.jsp";  
			this.request.setAttribute("bean", bean);
		}else{
			url = "/main.jsp";
			//DAO 객체를 생성한다.
			UserDAO udao = new UserDAO();			
			int cnt = -99999 ; 			
			//Bean 객체를 이용하여 해당 게시물을 추가한다.
			cnt = udao.UpdateUser(bean) ;
		}
		System.out.println("어디널이야!2번" +  request.getAttribute("bean") );
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(this.request, response);		
	}
	
	@Override
	public boolean validate() {
		final String PREFIX = "err" ;
		boolean isCheck = true ; //기본 값으로 true이고, 유효성 검사에 문제가 생기면 false으로 변경
		
		//Member err = new Member() ; 
		if( bean.getId().length() < 3 || bean.getId().length() > 10 ){
			this.request.setAttribute( PREFIX + "id", "아이디는 3자리 이상 10자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getName().length() < 2 || bean.getName().length() > 10 ){
			this.request.setAttribute( PREFIX + "name", "이름은 2자리 이상 10자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getPassword().length() < 4 || bean.getPassword().length() > 10 ){
			this.request.setAttribute( PREFIX + "password", "비밀 번호는 4자리 이상 10자리 이하이어야 합니다.");
			isCheck = false  ;
		}
		if( bean.getGender() == null){
			this.request.setAttribute( PREFIX + "gender", "성별은 반드시 체크가 되어야 합니다.	");
			isCheck = false  ;
		}
	
		if( bean.getZipcode() == null || bean.getZipcode() == "" ){
			this.request.setAttribute( PREFIX + "zipcode", "우편번호를 입력해 주세요.");
			isCheck = false  ;
		}
		if( bean.getAddress1() == null || bean.getAddress1() == "" ){
			this.request.setAttribute( PREFIX + "address1", "주소는 필수 사항입니다.");
			isCheck = false  ;
		}
		if( bean.getAddress2() == null || bean.getAddress2() == "" ){
			this.request.setAttribute( PREFIX + "address2", "상세 주소를 입력해 주세요.");
			isCheck = false  ;
		}
		return isCheck ;
	}
	
}
