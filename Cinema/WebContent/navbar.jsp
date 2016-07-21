<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath(); //현재 진행 중인 프로젝트 이름 
	String CommandName = "/CinemaCtrl"; //요청을 위한 url 패턴 이름
	String MyCtrlByForm = contextPath + CommandName; //폼이 있는 경우에 사용된다. 
	String MyCtrlCommand = contextPath + CommandName + "?command=";
	//out.print( MyCtrlCommand + "<br>" ); // Model2/MiniShopCtrl?command=
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DC BOX</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type=text/css>
<link href="bootstrap/css/justified-nav.css" rel="stylesheet">
<script src="bootstrap/js/jquery.js" type="text/javascript"></script>
<script src="bootstrap/js/jquery.min.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
   
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">DC Box</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">예매하기</a></li>
        <li><a href="#">영화</a></li>
        <li><a href="#">영화관</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><p class="navbar-text">Already have an account?</p></li>

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
         <ul id="login-dp" class="dropdown-menu">
            <li>
                <div class="row">
                     <div class="col-md-12">
                        Login via
                        <div class="social-buttons">
                           <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                           <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                        </div>
                                or
                         <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                              <div class="form-group">
                                  <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                  <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                              </div>
                              <div class="form-group">
                                  <label class="sr-only" for="exampleInputPassword2">Password</label>
                                  <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                              </div>
                              <div class="form-group">
                                  <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                              </div>
                              <div class="checkbox">
                                  <label>
                                  <input type="checkbox"> keep me logged-in
                                  </label>
                              </div>
                         </form>
                     </div>
                     <div class="bottom text-center">
                        New here ? <a href="#"><b>Join Us</b></a>
                     </div>
                </div>
            </li>
         </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


</body>
</html>