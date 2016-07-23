<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootStrap Sample</title>
<style type="text/css">
/*.panel-body{ margin-bottom: -30px;}*/
.form-group {
	margin-bottom: 3px;
}

.form-control {
	height: 25px;
}
</style>
</head>
<%
	int myoffset = 2; //전체 외관의 옵셋
	int mywidth = 12 - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = 12 - leftside; //판넬의 우측
%>
<body>
<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">d
			<div class="panel-heading">
				<h1 class="panel-title" align="left">영화 상세 보기</h1>
			</div>
			<div class="panel-body">
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
					<table>
						<tr>
							<td><img src="./MovieImage/${bean.stringImage}_01.jpg"
						name="${bean.stringImage}" width=250 height=300></td>
						</tr>
					</table>
				</div>
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>">
					<table class="table table-hover table-condensed">
						<tr>
							<td width="25%" align="center">영화명</td>
							<td width="75%" align="left">${bean.mname}</td>
						</tr>
						<tr>
							<td width="25%" align="center">개봉일</td>
							<td width="75%" align="left">${bean.opendate}</td>
						</tr>
						<tr>
							<td width="25%" align="center">감독</td>
							<td width="75%" align="left">${bean.director}</td>
						</tr>
						<tr>
							<td width="25%" align="center">장르</td>
							<td width="75%" align="left">${bean.genre}</td>
						</tr>
						<tr>
							<td width="25%" align="center">상영시간</td>
							<td width="75%" align="left">${bean.playingtime}</td>
						</tr>
						<tr>
							<td width="25%" align="center">스토리</td>
							<td width="75%" align="left">${bean.story}</td>
						</tr>
						<tr>
							<td width="25%" align="center">상영등급</td>
							<td width="75%" align="left">${bean.rating}</td>
						</tr>
						<tr>
							<td width="25%" align="center">배급사</td>
							<td width="75%" align="left">${bean.distributor}</td>
						</tr>
						<tr>
							<td width="25%" align="center">배우</td>
							<td width="75%" align="left">${bean.actor}</td>
						</tr>
						<tr>
							<td width="25%" align="center">상영 여부</td>
							<td width="75%" align="left">${bean.condition}</td>
						</tr>
						<tr>
							<td width="25%" align="center"></td>
							<td width="75%" align="left">${bean.actor}</td>
						</tr>
					</table>
				</div>
				<hr>
				<div class="col-sm-offset-5 col-sm-4">
					<button class="btn btn-primary" onclick="history.back();">
						돌아 가기</button>
				</div>
			</div>
			<!-- end panel-body -->
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>