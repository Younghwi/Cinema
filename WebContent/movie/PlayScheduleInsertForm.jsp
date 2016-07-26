<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="./../navbar.jsp" %>
<%
	int myoffset = 2 ;
	int mywidth = 12 - 2 * myoffset;
	int formleft = 3 ;
	int formright = 12 - formleft ; 
%>
<html>
<head>

	<script type="text/javascript">
		function function1(  ){
			var sno = document.myform.sno.value ;
			if( sno.length == 0 ){
				alert('고유번호를 입력해 주세요') ;
				document.myform.sno.focus() ; 
				return false ;
			}
			var url='<%=MyCtrlCommand%>plscSnoCheck&sno=' + sno ; 
			window.open(url, 'mywin', 'height=150,width=300') ;
		}
		function function3(  ){
			document.myform.isCheck.value = false ;			
		}
		function checkForm(  ){
			var isCheck = document.myform.isCheck.value ;
			//alert( isCheck ) ;
			if( isCheck == 'false' ){
				alert('스케줄 고유번호 중복 여부를 확인하세요') ;
				return false ;
			}			
		}		
	</script>
</head>

<body>
	<div id="main_container" align="center" 
		class="container col-xs-offset-<%=myoffset%> col-lg-offset-<%=myoffset%> col-xs-<%=mywidth%> col-lg-<%=mywidth%>"> 
		<h2>회원 가입 하기</h2>
		<div class="panel panel-primary sub_container">
			<div class="panel-heading" align="left">
				<font color="white	"><b>상영 스케줄 입력</b></font> 페이지입니다.
			</div>
			<div class="panel-body sub_container">
				<form id="myform" name="myform" class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post">
					<input type="hidden" name="command" value="plscInsert">
							
					<div class="form-group">
						<label for="password" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">영화 고유번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="mvid" id="mvid" class="form-control" placeholder="영화 고유번호를 정확히 확인하고 입력하세요" value="${requestScope.bean.mvid}" >
	        			</div>
	        		</div>
	        		<div class="form-group">
						<label for="name" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 고유번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="tid" id="tid" class="form-control" placeholder="상영관 고유번호를 정확히 확인하고 입력하세요" value="${requestScope.bean.tid}" >
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="name" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영일자</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="date" name="playdate" id="playdate" class="form-control" placeholder="상영일자를 정확히 확인하고 입력하세요" value="${requestScope.bean.playdate}" >
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="birth" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영 시작시간</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="starttime" id="starttime" class="form-control" placeholder="상영 시작시간을 정확히 확인하고 입력하세요" value="${requestScope.bean.starttime}">
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="birth" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영 회차</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="psorder" id="psorder" class="form-control" placeholder="상영 회차를 정확히 확인하고 입력하세요" value="${requestScope.bean.psorder}">
	        			</div>
	        		</div>
					<div class="form-group">
						<div class="col-xs-<%=12%> col-lg-<%=12%>" align="center">
							<button type="submit" class="btn btn-default"><b>스케줄 등록</b></button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-default">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>		
	</div>
	<script type="text/javascript">
		$(document).ready(function() {		
			//alert('dd') ;
			$('#myform').validate({
				rules : {
					id : {
						required : true
						,rangelength : [ 4, 8 ]
					}				
				}, //end rules
				messages : {
					id : {
						required : '아이디는 필수 입력 사항입니다.'
						,rangelength : '아이디는 4자리 이상 8자리 이하입니다.'
					}			
				}
			});
		});
		
	</script>	
</body>
</html>