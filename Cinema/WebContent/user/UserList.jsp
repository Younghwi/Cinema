<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../navbar.jsp"%>
<%
	int myoffset = 1;
	int mywidth = 12 - 2 * myoffset;
	int formleft = 3;
	int formright = 12 - formleft;
	int mysearch = 2;
	//int label = 3 ; //양식의 왼쪽에 보여지는 라벨의 너비 
	//int content = twelve - label ; //우측의 내용 입력(input, select, textarea)의 너비
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 style="padding-top: 80px"></h2>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">
				<form class="form-inline" role="form">
					<h2>게시물 목록</h2>
						<form class="form-inline" role="form" name="myform"
							action="<%=MyCtrlByForm%>" method="get">
							<input type="hidden" name="command" value="boList">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">
										-----선택하세요-----
									<option value="name">이름
									<option value="id">ID
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit"
								onclick="search();">검색</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</form>
				</form>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="wihe">
						<td class="wihe" align="center">등급</td>
						<td class="wihe" align="center">이름</td>
						<td class="wihe" align="center">생년월일</td>
						<td class="wihe" align="center">성별</td>
						<td class="wihe" align="center">ID</td>
						<td class="wihe" align="center">PW</td>
						<td class="wihe" align="center">번호</td>
						<td class="wihe" align="center">주소</td>
						<td class="wihe" align="center">포인트</td>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr>
						<td align="center">${bean.grade}</td>
						<td align="center">${bean.name}</td>
						<td align="center">${bean.birth}</td>
						<td align="center">${bean.gender}</td>
						<td align="center">${bean.id}</td>
						<td align="center">${bean.password}</td>
						<td align="center">${bean.phone}</td>
						<td align="center">${bean.address1}${bean.address2}</td>
						<td align="center">${bean.point}</td>
						<td>
							
								<a href="#">수정 </a>
							
						</td>
						<td>
								<a href="#">삭제</a>
							
						</td>						
					</tr>
				</c:forEach>
			</table>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		/* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */
		$('#mode option').each(function(index) {
			if ($(this).val() == '${requestScope.mode}') {
				$(this).attr('selected', 'selected');
			}
		});
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val('${requestScope.keyword}');
	</script>
</body>
</html>

