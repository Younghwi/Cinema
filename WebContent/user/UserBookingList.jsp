<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../navbar.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>


<div class="container col-sm-offset-2 col-sm-8">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<form class="form-inline" role="form">
					<h2>예매내역 </h2>
				</form>
			</div>
			<table class="table table-striped table-hover">
			<tr>
					<td colspan="10" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>" method="get">
							<input type="hidden" name="command" value="boList">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">-- 선택하세요---------
									<option value="writer">총 예매내역
									<option value="subject">예매내역
									<option value="content">지난예매내역									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
						</form>
					</td>
				</tr>
				
					<tr>
						<th>예매번호</th>
						<th>예매자</th>
						<th>영화제목</th>
						<th>예매날짜</th>
						<th>상영날짜</th>
						<th>회차</th>
						<th>상영관</th>
						<th>좌석번호</th>

					</tr>
				
				
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr>
						<td>${bean.bno }</td>
						<td>${bean.name }</td>
						<td>${bean.mname }</td>
						<td>${bean.bookdate }</td>
						<td>${bean.playdate }</td>
						<td>${bean.psorder }</td>
						<td>${bean.tname}</td>
						<td>${bean.seatno }</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}

			</footer>			
		</div>

</body>
</html>