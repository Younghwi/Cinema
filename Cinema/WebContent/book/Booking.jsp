<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	/* 	
		if(id==null){
			out.print("<script>");
			out.print("alert('회원만 이용 가능합니다. 로그인을 해 주세요.');");
			out.print("history.go(-1);");
			out.print("</script>");
		} */
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<br>
		<br>
		<br>
		<h1>영화 예매하자!</h1>
		<form action="">

			<div class="row">
				<div class="col-sm-4" style="background-color: lavender;">
				<table>
				<tr>
				<c:forEach var="bean" items="${requestScope.mlists}" varStatus="kkk">
					
					<td>
						<input type="image" class="bookimage" src="./MovieImage/${bean.stringImage}_01.jpg" onclick="">
					</td>
					<c:out value="kkk">gg</c:out>
					
				</c:forEach>
				</tr>
				</table>
				</div>

				<div class="col-sm-4" style="background-color: lavenderblush;">
				시간
					<c:forEach var="bean" items="${requestScope.pslists}">
						<div>상영일자 : ${bean.playdate} / ${bean.psorder}회차</div>
						<input type="button" name="playschedule" id="playschedule" value="${bean.starttime}">
					</c:forEach>
				</div>
			</div>
			
			<div class="row">
				
			</div>
			<input type="submit" value="예매하기">
		</form>
	</div>



</body>
</html>