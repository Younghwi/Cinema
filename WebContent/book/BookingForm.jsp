<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>


  </script>



<script type="text/javascript">
function clickMovie(mvid, playdate){
	alert(playdate);
	location.href="<%=MyCtrlCommand%>bookingForm&mvid=" + mvid +"&date=" + playdate;
}
function clickSchedule(mvid, psorder, playdate){
	alert(mvid + '영화와' + psorder + '회차');
	location.href="<%=MyCtrlCommand%>bookingForm&mvid=${requestScope.mvid}" + "&psorder="+ psorder + "&date=" + playdate;
}

function selectSeat(mvid, psorder, startseat, endseat, price, playdate){
	//alert(mvid + '영화와' + order + '회차');
	//location.href="<%=MyCtrlCommand%>bookingForm&mvid=" + mvid + "&psorder=" + psorder + "&startseat=" + startseat + "&endseat=" + endseat ;
	
	url = "<%=MyCtrlCommand%>bookingSeatForm&mvid=${requestScope.mvid}&row=" + startseat + "&col=" + endseat + "&price=" + price + "&psorder=" + psorder + "&date=" + playdate ;
	var winL = (screen.width-500)/2;
	var winT = (screen.height-350)/2;
	var spec = 'height=350,width=500,';
	spec +='top='+winL+',';
	spec +='left='+winT;
	window.open(url, 'seat', spec) ;
}

$( function() {
	$( ".datepicker" ).datepicker({
		dateFormat: 'yymmdd',
		
		onSelect: function(dateText, inst){  
		       
		      $('#date').val(dateText); // 일자를 클릭하면 하단에 새로 만든 <input type="hidden"> 박스에 선택한 날짜를 넣음
		      $('#btn').trigger('click');  // 일자클릭시 강제로 검색 버튼의 이벤트를 발생 시켜서 하단의 <from> 전송 
		    }
		});
  } );

</script>
<%
	if (whologin == 0) {
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
<br> <br> <br>
	<div class="container col-md-offset-2 col-md-8">
		
		<h1 class="cursive">Movie Booking</h1>
        <hr>
		<p> <label class="form-control ">날짜를 선택해주세요</label>
			<h3 class="cursive">Date :</h3> <input type="text" class="datepicker">
			<form action="<%=MyCtrlCommand%>bookingForm" name="wow" id="wow" method="post">
			<input type="hidden" name="command" value="bookingForm">
			<input type="hidden" name="date" id="date">
			<input class="btn btn-primary" type="submit" name="btn" id="btn">
			</form>
		</p>

		<div class="row">
			<div class="col-md-12">
				<label class="form-control ">영화를 선택해주세요</label>
				<c:if test="${empty requestScope.j6lists}">
				<label class="form-control">선택한 날짜에 상영영화가없습니다.</label>
				</c:if>
				<c:if test="${not empty requestScope.j6lists}">
				<table border=1 align="center">
					<tr>
						<c:set var="count" value="1" />
						<c:forEach var="bean" items="${requestScope.j6lists}">
							<td><input type="image" class="bookimage"
								src="./MovieImage/${bean.stringImage}_01.jpg"
								onclick="clickMovie(${bean.mvid}, ${bean.playdate});"> <c:set var="count"
									value="${count+1}" /> <c:if test="${ count % 6 == 0  }">
					</tr>
					</c:if>
					</c:forEach>
					</tr>

				</table>
				</c:if>
			</div>
		</div>

		<br>

		<div class="row">

			<div class="col-md-4">
				<label class="form-control ">시간선택하기</label>
				<c:forEach var="bean" items="${requestScope.j3lists}">
					<div>상영일자 : ${bean.playdate} / ${bean.psorder}회차</div>
					<input class="btn btn-primary" type="button"
						onclick="clickSchedule(${bean.mvid},${bean.psorder},${bean.playdate });"
						value="${bean.starttime}">
				</c:forEach>
			</div>

			<div class="col-md-4">
				<label class="form-control ">좌석 선택하기</label>
				<input class="btn btn-primary" type="button"
					onclick="selectSeat(${j3bean.mvid},${j3bean.psorder},${j3bean.startseat},${j3bean.endseat},${j3bean.price},${j3bean.playdate });"
					value="좌석선택하기">
			</div>

			<div class="col-md-4">
				<form action="<%=MyCtrlCommand%>booking" name="myform" id="myform">
					<input type="hidden" name="command" value="booking"> <input
						type="hidden" name="mid" value="${sessionScope.loginfo.id}">
					<input type="hidden" name="mvid" value="${j3bean.mvid}"> <input
						type="hidden" name="amount" value=""> <input type="hidden"
						name="hiddenseat" value=""> <input type="hidden"
						name="tid" value="${j3bean.tid}"> <input type="hidden"
						name="sno" value="${j3bean.sno}"> 
						
						<label class="form-control ">예매정보</label>
						영화 :<input class="form-control " type="text" name="moive" id="moive" value="${j3bean.mname}" disabled="disabled"><br>
						예매시간/회차 : <input class="form-control " type="text" name="time" id="time" value="${j3bean.starttime}/${j3bean.psorder}회차" disabled="disabled"><br> 
						좌석 :<input class="form-control " type="text" name="seat" id="seat" disabled="disabled"> <br> 
						가격 :<input class="form-control " type="text" name="price" id="price" disabled="disabled"><br>
						<input class="btn btn-primary" type="submit" value="예매하기">
				</form>
			</div>
		</div>
</body>
</html>