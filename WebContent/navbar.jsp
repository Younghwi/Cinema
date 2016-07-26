<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath(); //현재 진행 중인 프로젝트 이름 
	String CommandName = "/CinemaCtrl"; //요청을 위한 url 패턴 이름
	String MyCtrlByForm = contextPath + CommandName; //폼이 있는 경우에 사용된다. 
	String MyCtrlCommand = contextPath + CommandName + "?command=";
	
	UserBean longinfo = (UserBean) session.getAttribute("loginfo");
	int whologin = 0; // 0 : 미로그인,  1 : 회원 로그인, 2 : 관리자 로그인
	
	if(longinfo == null ){
		whologin = 0;	
	}else if(longinfo.getId().equals("admin")){
		whologin = 2;
	}else{
		whologin = 1;
	}
	
	session.setAttribute("whologin", whologin);
	
	String myurl = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	int idx = myurl.indexOf(uri);

	//웹 서버의 이미지를 올릴 경로
	String uploadPath = "/upload/";
	String uploadedFolder = myurl.substring(0, idx) + contextPath
			+ uploadPath;
	String realPath =  application.getRealPath( uploadPath ) ;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DC BOX</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type=text/css>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script	src="bootstrap/js/scripts.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css" rel="stylesheet" />
<link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link href="bootstrap/css/styles.css" rel="stylesheet" type=text/css>
</head>
<body>
	<nav id="topNav" class="navbar navbar-default navbar-fixed-top affix-top">
	<div class="container-fluid">
		<div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#first"><i class="ion-ios-analytics-outline"></i>DC Box</a>
            </div>
		
		<div class="collapse navbar-collapse" id="bs-navbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">Home</a></li>
				<li><a href="<%=MyCtrlCommand%>bookingForm">예매하기</a></li>
				<li><a href="<%=MyCtrlCommand%>moList">영화</a></li>
				<li><a href="<%=MyCtrlCommand%>ttMain">영화관</a></li>
				<li><a href="<%=MyCtrlCommand%>ctmain">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<c:if test="${empty sessionScope.loginfo}">
					<li><a href="<%=MyCtrlCommand%>usInsertForm"><span class="glyphicon glyphicon-user"></span>Join Us</a></li>
					<li><a href="#login" class="page-scroll " title="Login" data-toggle="modal" ><b>Login</b> <span class="caret"></span></a></li>
						
						<div id="login" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog">
									<div class="modal-content">
									<div class="modal-body">
									<div class="col-md-12">
										<form class="form" method="post"
											action="<%=MyCtrlCommand%>usLogin" accept-charset="UTF-8"
											id="login-nav">
											<input type="hidden" name="command" value="meLogin">
											<div class="form-group">
												<label class="sr-only">ID</label> <input type="text"
													name = "id" class="form-control" size="20" placeholder="ID ENTER"
													required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputPassword2">PW</label>
												<input type="password" name = "password" class="form-control" size="20"
													placeholder="PW ENTER" required>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary btn-block">Sign
													In</button>
											</div>
										</form>
									</div>
									<div class="bottom text-center">
										<a href="#"><b>Join Us</b></a>
									</div>
								</div><!-- 로그인 창 -->
								
								</div>
								</div>
								</div>
						
				</c:if>

				<c:if test="${not empty sessionScope.loginfo}">
					<li><a><span
							class="glyphicon glyphicon-user"></span>${sessionScope.loginfo.name} (${sessionScope.loginfo.id}) 님 오신것을 환영합니다 </a></li>
					<c:if test="${whologin == 2}">
					<li><a href="#adminpage" class="page-scroll " title="Login" data-toggle="modal" ><b>관리자페이지</b> <span class="caret"></span></a></li>
					<div id="adminpage" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog">
									<div class="modal-content">
									<div class="modal-body" align="center">
									<br>
									<h3><a class="text-center" href="<%=MyCtrlCommand%>moInsert">영화정보 입력</a></h3><br><hr>
									<h3><a class="text-center" href="<%=MyCtrlCommand%>plscInsertForm">상영스케줄 입력</a></h3><br><hr>
									<h3><a class="text-center" href="#">회원리스트보기</a><br><hr>
									<h3><a class="text-center" href="<%=MyCtrlCommand%>ttInsertForm">상영관 추가</a><br></h3><br><hr>
									<h3><a class="text-center" href="<%=MyCtrlCommand%>bookingList">총 예매 목록</a><br></h3><br>
									
									</div>
								</div><!-- 로그인 창 -->
								</div>
								</div>

					 
					</c:if>
					<li><a href="#mypage" class="page-scroll " title="Login" data-toggle="modal" ><b>마이페이지</b> <span class="caret"></span></a></li>
					<div id="mypage" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog">
									<div class="modal-content">
									<div class="modal-body" align="center">
									<h3><a href="<%=MyCtrlCommand%>usUpdateForm&id=${sessionScope.loginfo.id}">
									<span class="glyphicon glyphicon-user"></span>마이페이지</a></h3><br><hr>
									<h3><a href="<%=MyCtrlCommand%>usBookingList&mid=${sessionScope.loginfo.id}">
									<span class="glyphicon glyphicon-user"></span>예약내역보기</a></h3>
									</div>
								</div><!-- 로그인 창 -->
								</div>
								</div>
					<%-- <li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<span class="glyphicon glyphicon-user"></span>마이페이지<span class="caret"></span></a>
							
					<ul class="dropdown-menu">
					<li><a href="<%=MyCtrlCommand%>usUpdateForm&id=${sessionScope.loginfo.id}"><span
							class="glyphicon glyphicon-user"></span>마이페이지</a></li>
					<li><a href="<%=MyCtrlCommand%>usBookingList&mid=${sessionScope.loginfo.id}"><span
							class="glyphicon glyphicon-user"></span>예약내역보기</a>
							</li>
					</ul>
					</li> --%>
							
					<li><a href="<%=MyCtrlCommand%>usLogout"><span
							class="glyphicon glyphicon-user"></span>로그 아웃</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
		</div><!-- /.container-fluid --> 
		</nav>

		<!--scripts loaded here from cdn for performance -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
    

</body>
</html>