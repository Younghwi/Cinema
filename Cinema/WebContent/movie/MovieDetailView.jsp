<%@page import="model.Join05"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세보기 페이지</title>
<style type="text/css">
/*.panel-body{ margin-bottom: -30px;}*/
.form-group {
	margin-bottom: 3px;
}

.form-control {
	height: 25px;
}
</style>
<script type="text/javascript">
function starclick(value) {
	//alert(value);
	var url = 'http://image2.megabox.co.kr/mop/home/star_mid_on.png';
	document.coform.starScore.value = value;
	if(value == 1){
		document.coform.a.src = url;
	}else if(value == 2){
		document.coform.a.src = url;
		document.coform.b.src = url;
	}else if(value ==3){
		document.coform.a.src = url;
		document.coform.b.src = url;
		document.coform.c.src = url;
	}else if(value == 4){
		document.coform.a.src = url;
		document.coform.b.src = url;
		document.coform.c.src = url;
		document.coform.d.src = url;
	}else{
		document.coform.a.src = url;
		document.coform.b.src = url;
		document.coform.c.src = url;
		document.coform.d.src = url;
		document.coform.e.src = url;
	}
}
</script>
</head>
<%
	int myoffset = 2; //전체 외관의 옵셋
	int mywidth = 12 - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = 12 - leftside; //판넬의 우측
	
	
	
/* 	if(whologin == 0){
		out.print("<script>");
		out.print("alert('회원만 이용 가능합니다. 로그인을 해 주세요.');");
		out.print("history.go(-1);");
		out.print("</script>");
	} */
%>
<body>
<br><br><br>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
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
				<br>
				
				<div class="col-sm-offset-1 col-sm-10 inputcomment">
				<h3>한줄평</h3>
				<%if(whologin != 0){ %>
				<!-- 댓글 달기 ~~~~~~~~ -->
				
				
				<form name="coform" action="<%=MyCtrlCommand%>coInsert&mvid=${bean.mvid}"  method="post">
				<input type="hidden" name="mid" id="mid" value="<%=longinfo.getId() %>">
				<input type="hidden" name="mvid" id="mvid" value="${bean.mvid }">
				<table border="1">
				<tr>
				<td><textarea name="comments" id="comments" placeholder="한줄평을 달아주세요" rows="3" cols="65"></textarea></td>
				<td>
				<img name="a" alt="별점1 괜히봤어요" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png" onclick="starclick(1);" style="cursor:hand;">
				<img name="b" alt="별점2 기대하진 말아요" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png" onclick="starclick(2);">
				<img name="c" alt="별점3 무난했어요" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png" onclick="starclick(3);">
				<img name="d" alt="별점4 기대해도" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png" onclick="starclick(4);">
				<img name="e" alt="별점5 너무 멋진 영화였어요!" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png" onclick="starclick(5);">
				<!-- 
				<input type="image" alt="별점2 기대하진 말아요" src="http://image2.megabox.co.kr/mop/home/star_mid_on.png" onclick="starclick(2);" value="2"/>
				<input type="image" alt="별점3 무난했어요" src="http://image2.megabox.co.kr/mop/home/star_mid_on.png" onclick="starclick(3);" value="3"/>
				<input type="image" alt="별점4 기대해도" src="http://image2.megabox.co.kr/mop/home/star_mid_on.png" onclick="starclick(4);" value="4"/>
				<input type="image" alt="별점5 너무 멋진 영화였어요!" src="http://image2.megabox.co.kr/mop/home/star_mid_on.png" onclick="starclick(5);" value="5"/> -->
				<input id ="starScore" name="starScore" type="hidden" value="0" />
				</td>
				<td><input type="submit" value="글쓰기"></td>
				</tr>
				</table>
				</form>
				
				<hr>
				
				
				<%} %>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10 comment">
				<hr>
				<c:forEach var="bean" items="${requestScope.j5lists }">
				<p><h5>작성자 : ${bean.mid }&nbsp;&nbsp;작성일자: ${bean.writedate }
				<c:forEach begin="1" end="${bean.starpoint}">
				<img width="15" height="15" src="http://image2.megabox.co.kr/mop/home/star_mid_on.png">
				</c:forEach >
				<c:forEach begin="1" end="${5-bean.starpoint}">
				<img width="15" height="15" src="http://image2.megabox.co.kr/mop/home/star_mid_off.png">
				</c:forEach></h5></p>
				<p><h4>한줄평 : ${bean.comments }</h4></p>
				 <hr>
				</c:forEach>
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