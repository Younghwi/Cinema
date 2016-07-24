<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function clickMovie(mvid){
	alert(mvid);
	location.href="<%=MyCtrlCommand%>bookingForm&mvid=" + mvid;
}
function clickSchedule(mvid, psorder){
	alert(mvid + '영화와' + psorder + '회차');
	location.href="<%=MyCtrlCommand%>bookingForm&mvid=${requestScope.mvid}" + "&psorder="+ psorder;
}

function selectSeat(mvid, psorder, startseat, endseat, price){
	//alert(mvid + '영화와' + order + '회차');
	//location.href="<%=MyCtrlCommand%>bookingForm&mvid=" + mvid + "&psorder=" + psorder + "&startseat=" + startseat + "&endseat=" + endseat ;
	
	url = "<%=MyCtrlCommand%>bookingSeatForm&row=" + startseat + "&col=" + endseat + "&price=" + price ;
	var winL = (screen.width-500)/2;
	var winT = (screen.height-350)/2;
	var spec = 'height=350,width=500,';
	spec +='top='+winL+',';
	spec +='left='+winT;
	window.open(url, 'seat', spec) ;
}
</script>
<%
	
		if(whologin == 0){
			out.print("<script>");
			out.print("alert('회원만 이용 가능합니다. 로그인을 해 주세요.');");
			out.print("history.go(-1);");
			out.print("</script>");
		} 
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container col-md-offset-2 col-md-8">
		<br> <br> <br>
		<h1>영화 예매하자!</h1>


		<div class="row">
			<div class="col-md-12" style="background-color: lavender;">
				영화를 선택해주세요
				<table border=1 align="center">
					<tr>
						<c:set var="count" value="1" />
						<c:forEach var="bean" items="${requestScope.mlists}">
							<td ><input type="image" class="bookimage"
								src="./MovieImage/${bean.stringImage}_01.jpg"
								onclick="clickMovie(${bean.mvid});">
							<c:set var="count" value="${count+1}" />
							<c:if test="${ count % 6 == 0  }">
					</tr>
					</c:if>
					</c:forEach>
					</tr>

				</table>
			</div>
		</div>
		
		<br>
		
		<div class="row">
		
		<div class="col-md-4" style="background-color: lavenderblush;">
				시간
				<c:forEach var="bean" items="${requestScope.j3lists}">
					<div>상영일자 : ${bean.playdate} / ${bean.psorder}회차</div>
					<input type="button" onclick="clickSchedule(${bean.mvid},${bean.psorder});" value="${bean.starttime}">
				</c:forEach>
			</div>
		
			<div class="col-md-4" style="background-color: lavender;" >
				<input type="button" onclick="selectSeat(${j3bean.mvid},${j3bean.psorder},${j3bean.startseat},${j3bean.endseat},${j3bean.price});" value="좌석선택하기" >
				${j3bean.startseat}<br>
				${j3bean.endseat}
			</div>
			
			<div class="col-md-4" style="background-color: lavenderblush;">
				<form name="myform" id="myform" >
				예매정보 <br>
				영화 : <input type="text" name="moive" id="moive" value="${j3bean.mname}" disabled="disabled"><br>
				예매시간/회차 : <input type="text" name="time" id="time" value="${j3bean.starttime}/${j3bean.psorder}회차" disabled="disabled"><br>
				좌석 :<input type="text" name="seat" id="seat" disabled="disabled"> <br>
				가격 :<input type="text" name="price" id="price" disabled="disabled"><br>
				
				</form>
			</div>
	</div>



</body>
</html>