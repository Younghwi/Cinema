<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./../navbar.jsp"%>
<%
	String id = request.getParameter("id");
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
	     document.images.jungle.src = "./MovieImage/jungle_01.jpg";
	 } else if(flag == 2){
	     document.images.jungle.src = "./MovieImage/jungle_01.jpg";
	 }
	 if (document.all) document.images.jungle.filters.blendTrans.Play();
	 }
	 
	 function bookPopup(mvid) {
		location.href='<%=MyCtrlCommand%>bookingForm&mvid='+mvid;
	}
	 function detailViewPopup(mvid) { 
		 location.href='<%=MyCtrlCommand%>moDetailView&mvid='+mvid;
		}
	</script>
</head>
<body>
	<br>
	<br>
	<br>
	<div class="col-md-offset-1 col-md-10">
	<h1 class="cursive">Movie List</h1>
        <hr>
		<table border=1 align="center">
			<tr>
				<c:set var="count" value="1" />
				<c:forEach var="bean" items="${requestScope.lists}">
				
					<td align="center" ><img src="./MovieImage/${bean.stringImage}_01.jpg"
						class="movieImage" name="${bean.stringImage}" width=250 height=300
						onMouseOver="imgChange(1);" onMouseOut="imgChange(1)"
						style="cursor: hand"><br>
						<input type="button" class="btn btn-primary" class="mybtn" name="detail_btb" onclick="detailViewPopup('${bean.mvid}');" value="상세보기">
						<input type="button" class="btn btn-primary" class="mybtn" name="book_btn" onclick="bookPopup('${bean.mvid}');" value="예매하기">
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