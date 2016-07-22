<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	int twelve = 12;
	int myoffset = 3;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
%>
<%
	String contextPath = request.getContextPath(); //현재 진행 중인 프로젝트 이름 
	String CommandName = "/CinemaCtrl"; //요청을 위한 url 패턴 이름
	String MyCtrlByForm = contextPath + CommandName; //폼이 있는 경우에 사용된다.
	String MyCtrlCommand = contextPath + CommandName + "?command=";
%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function sendAddress(zipcode, address) {
		//alert(zipcode + '/' + address) ;
		//opener : 나 자신을 open 시킨 창
		opener.document.myform.zipcode.value = zipcode;
		opener.document.myform.fakezipcode.value = zipcode;
		opener.document.myform.fakeaddress1.value = address;
		opener.document.myform.address1.value = address;
		opener.document.myform.address2.focus();
		self.close(); //self : 자기 자신을 의미
	}
	function myzipcheck(  ){
		var finddata = document.myform.dong.value ;
		if( finddata.length == 0 ){
			alert('동네 이름을 2글자 이상 입력해 주세요') ;
			document.myform.dong.focus() ; 
			return false ;
		}
		var url='<%=MyCtrlCommand%>usZipCheck' ; 
		window.open(url, 'mywin', 'height=150,width=300') ;
	}
</script>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">우편 번호 검색</div>
			<div class="panel-body">
				<form name="myform" class="form-inline" role="form" method="post" action="<%=MyCtrlByForm%>" >
					<input type="hidden" name="command" value="usZipCheck">
					<table class="table table-striped table-hover table-condensed">
						<tr>
							<td colspan="2" align="center">
								<p class="form-control-static">동이름 입력 :</p>

								<div class="form-group">
									<input type="text" class="form-control" name="dong" id="dong"
										placeholder="검색할 동네 이름을 입력하세요">
								</div>
								<button class="btn btn-default" type="submit" onclick="return myzipcheck();">검색</button>
							</td>
						</tr>
						<c:forEach items="${lists}" var="oneitem">
							<c:set var="address"
								value="${fn:trim(oneitem.sido)} ${fn:trim(oneitem.gugun)} ${fn:trim(oneitem.dong)} ${fn:trim(oneitem.bunji)}" />
							<tr>
								<td width="25%" align="center"><a href='#'
									onclick="sendAddress('${oneitem.zipcode}', '${address}');">
										${oneitem.zipcode} </a></td>
								<td width="75%" align="left"><a href='#'
									onclick="sendAddress('${oneitem.zipcode}', '${address}');">
										${address} </a></td>
							</tr>
						</c:forEach>
					</table>
				</form>
				<div class="row" align="center">
					<button class="btn btn-primary" type="submit" onclick="self.close();" >
						닫&nbsp;&nbsp;기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>