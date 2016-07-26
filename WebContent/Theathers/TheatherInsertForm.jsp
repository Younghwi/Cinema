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
				<font color="white	"><b>상영관 추가</b></font> 페이지입니다.
			</div>
			<div class="panel-body sub_container">
				<form id="myform" name="myform" class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="ttInsert">
							
					<div class="form-group">
						<label for="tname" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 이름</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="tname" id="tname" class="form-control" placeholder="새로운 상영관의 이름을 입력해주세요" value="${requestScope.bean.tname}" >
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="startseat" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 행</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="startseat" id="startseat" class="form-control" placeholder="새로운 상영관의 행을 입력해주세요" value="${requestScope.bean.startseat}">
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="endseat" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 열</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="endseat" id="endseat" class="form-control" placeholder="새로운 상영관의 열을 입력해주세요" value="${requestScope.bean.endseat}">
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="price" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 가격</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="price" id="price" class="form-control" placeholder="새로운 상영관의 가격을 입력해주세요" value="${requestScope.bean.price}">
	        			</div>
	        		</div>
	        		<div class="form-group">							
						<label for="timage" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">상영관 이미지</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="file" name="timage" id="timage" class="form-control" placeholder="새로운 상영관의 이미지를 추가해주세요" value="${requestScope.bean.timage}">
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