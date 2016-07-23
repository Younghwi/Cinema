<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./../navbar.jsp"%>
<%
	String id = request.getParameter("id");

	if (id != null) {
		out.print("<script>");
		out.print("alert('회원만 이용 가능합니다. 로그인을 해 주세요.');");
		out.print("history.go(-1);");
		out.print("</script>");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	
	var SlideShowSpeed = 2500;
	var CrossFadeDuration = 2;
	
	function imgChange(flag){
	 if (document.all){
	 document.images.jungle.style.filter="blendTrans(duration=2)";
	 document.images.jungle.style.filter="blendTrans(duration=CrossFadeDuration)";
	 document.images.jungle.filters.blendTrans.Apply();
	 }
	 if(flag == 1){ //마우스 오버일경우
	     document.images.jungle.src = "./MovieImage/jungle_01.JPG";
	 } else if(flag == 2){
	     document.images.jungle.src = "./MovieImage/jungle_02.JPG";
	 }
	 if (document.all) document.images.jungle.filters.blendTrans.Play();
	 }
	 
	 function bookPopup() {
		 var url='<%=MyCtrlCommand%>booking' ; 		
			window.open(url, 'mywin', 'height=600,width=720,menubar=nolocation=no,toolbar=no,status=no,scrollbars=no,resizable=no') ;
	}
	 function detailViewPopup(input) { 
		 
		 //var imsi = input ;
		 //alert(input);
		 location.href='<%=MyCtrlCommand%>moDetailView&mvid='+input;
		}
	</script>
</head>
<body>
	<br>
	<br>
	<br>
	<div class="col-md-offset-1 col-md-10">
		<table border=1 align="center">
			<tr>
				<c:set var="count" value="1" />
				<c:forEach var="bean" items="${requestScope.lists}">
				
					<td align="center"><img src="./MovieImage/${bean.stringImage}_01.jpg"
						name="${bean.stringImage}" width=250 height=300
						onMouseOver="imgChange(1);" onMouseOut="imgChange(1)"
						style="cursor: hand"><br>
						<input type="button" name="detail_btb" onclick="detailViewPopup('${bean.mvid}');" value="상세보기">&nbsp;&nbsp;
						<input type="button" name="book_btn" onclick="bookPopup();" value="예매하기">
					</td>
					<c:set var="count" value="${count+1}" />

					<c:if test="${ count % 5 == 0  }">
						</tr>
					</c:if>
				</c:forEach>
				</tr>


		</table>
	</div>
</body>
</html>