<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../navbar.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>

<br>
<br>
<br>
관리자 페이지예요!<br><br>


<a href="<%=MyCtrlCommand%>moInsert">영화정보 임력</a><br>
<a href="<%=MyCtrlCommand%>plscInsertForm">상영스케줄 입력</a><br>
<a href="#">회원리스트보기</a><br>
<a href="<%=MyCtrlCommand%>ttInsertForm">상영관 추가</a><br>
<a href="<%=MyCtrlCommand%>bookingList">총 예매 목록</a><br>
</body>
</html>