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
			var id = document.myform.id.value ;
			if( id.length == 0 ){
				alert('아이디를 입력해 주세요') ;
				document.myform.id.focus() ; 
				return false ;
			}
			var url='<%=MyCtrlCommand%>usIdCheck&id=' + id ; 
			window.open(url, 'mywin', 'height=150,width=300') ;
		}
		function function2(  ){
			var url='<%=MyCtrlCommand%>usZipCheck' ; 		
			window.open(url, 'mywin', 'height=600,width=720,status=yes,scrollbars=yes,resizable=no') ;			
		}
		function function3(  ){
			document.myform.isCheck.value = false ;			
		}
		function checkForm(  ){
			var isCheck = document.myform.isCheck.value ;
			//alert( isCheck ) ;
			if( isCheck == 'false' ){
				alert('아이디 중복 체크를 우선 해주세용.') ;
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
				<font color="red"><b>회원 가입</b></font> 페이지입니다.
			</div>
			<div class="panel-body sub_container">
				<form id="myform" name="myform" class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post">
					<input type="hidden" name="command" value="usInsert">
					<input type="hidden" name="isCheck" value="false">
					<input type="hidden" name="point" value="500">
					<div class="form-group">
						<label for="id" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">아이디</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			<input type="text" name="id" id="id" class="form-control" placeholder="아이디" 
		            			value="${requestScope.bean.id}" onkeyup="function3();" >
	            			<span class="err">${errid}</span>  
	        			</div>
	        			<div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
	            			<input type="button" class="btn btn-info" value="중복 검사" onclick="function1();"> 
	        			</div>
	        		</div>        		
				
					<div class="form-group">
						<label for="password" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">비밀 번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="password" name="password" id="password" class="form-control" placeholder="비밀 번호를 넣어 주셔요" value="${requestScope.bean.password}" >
	            			<span class="err">${errpassword}</span>  
	        			</div>
	        		</div>
	        			<div class="form-group">
						<label for="name" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">이름</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="name" id="name" class="form-control" placeholder="이름" value="${requestScope.bean.name}" >
	            			<span class="err">${errname}</span> 
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="gender" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">성별</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>" align="left">
	            			<label class="radio-inline"> <input type="radio"
								name="gender" id="gender1" value="남자">남자
							</label> &nbsp;&nbsp;<label class="radio-inline"> <input type="radio"
								name="gender" id="gender2" value="여자">여자
							</label>
							<span class="form-control-static err">${errgender}</span>
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="zipcode" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">우편 번호</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			<input type="text" name="fakezipcode" id="fakezipcode" class="form-control" disabled="disabled" placeholder="우편 번호" value="" >
	            			<input type="hidden" name="zipcode" id="zipcode" value="" > 
	        			</div>
						<div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
	            			<input type="button" class="btn btn-info" value="우편 번호 찾기" onclick="function2( );"> 
	        			</div>
	        			<span class="err">${erraddress1}</span>	        			
	        		</div> 
					<div class="form-group">
						<label for="address2" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">세부 주소</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="address2" id="address2" class="form-control" placeholder="주소" value="주소를 입력해주세요.">
	            			<span class="err">${erraddress2}</span> 
	        			</div>
	        		</div>
					<div class="form-group">
						<div class="col-xs-<%=12%> col-lg-<%=12%>" align="center">
							<button type="submit" class="btn btn-default" onclick="return checkForm();"><b>회원 가입</b></button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-default">초기화</button>
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