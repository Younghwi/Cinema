<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../navbar.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/Theather.css" rel="stylesheet" type=text/css>
<title>영화관 정보</title>
</head>

<body>
	<div class="ttcontainer">
		<div class="ttmainimage">
			<img src="./Images/theather/main관.png" alt="메인 관 화면">
			<div class="ttmaintext">
				<h1>DC BOX</h1>
				<h3>만남과 소통의 즐거움이 가득한 공간</h3>
				<h3>DC BOX가 '더 좋은 영화관' 을 만들어 갑니다.</h3>
				<h1>─────────</h1>
				<h5>DC BOX가 영화관의 새로운 패러다임을 만들어 갑니다.</h5>
			</div>
		</div>
		<div class=theaterIMG>
			<h2 class=theatertext style="padding-top: 720px">1관&2관</h2>
			<img src="./Images/theather/1,2관.png" align="" alt="1,2관">
			<h2 class=theatertext style="padding-top: 80px">3관&4관</h2>
			<img src="./Images/theather/3,4관.png" align="" alt="3,4관">
			<c:forEach var="bean" items="${requestScope.lists}">
				<c:if test="${bean.tid==5 || bean.tid==6 || bean.tid==7}">
					<h2 class=theatertext style="padding-top: 80px">${bean.tname}</h2>
					<img src="./Images/theather/${bean.timage}.png"
						alt="${bean.timage}">
				</c:if>
			</c:forEach>
			<h2 class=theatertext style="padding-top: 80px"></h2>
		</div>
	</div>
</body>
<%@include file="./../footer.jsp"%>
</html>
<!-- 

      	<h2 class=theatertext style="padding-top: 80px">3관&4관</h2>
      	<img src="./Images/theather/3,4관.png" align="" alt="3,4관">
      	
      	<h2 class=theatertext style="padding-top: 80px">5관(Table관)</h2>
      	<img src="./Images/theather/5관.png" align="" alt="5관">
      	
      	<h2 class=theatertext style="padding-top: 80px">3D관</h2>
      	<img src="./Images/theather/6관.jpg" align="" alt="3D관">
      	
      	<h2 class=theatertext style="padding-top: 80px">GOLD관</h2>
      	<img src="./Images/theather/7관.png" align="" alt="GOLD관">
 -->