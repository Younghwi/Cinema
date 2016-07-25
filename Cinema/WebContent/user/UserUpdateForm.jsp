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
		function function2(  ){
			var url='<%=MyCtrlCommand%>usZipCheck' ; 		
			window.open(url, 'mywin', 'height=600,width=720,status=yes,scrollbars=yes,resizable=no') ;			
		}
		function function3(  ){
			document.myform.isCheck.value = false ;			
		}
		function function5() {
			var url='<%=MyCtrlCommand%>usDelete' ;
		<%--	var url='<%=MyCtrlCommand%>usDelete' ;
			window.open(url, 'mywin', 'height=600,width=720,status=yes,scrollbars=yes,resizable=no') ;--%>
		}
		function checkForm(  ){
			var isCheck = document.myform.isCheck.value ;
			//alert( isCheck ) ;
			}		
	</script>
</head>

<body>
	<div id="main_container" align="center" 
		class="container col-xs-offset-<%=myoffset%> col-lg-offset-<%=myoffset%> col-xs-<%=mywidth%> col-lg-<%=mywidth%>"> 
		<h2>회원 가입 하기</h2>
		<div class="panel panel-primary sub_container">
			<div class="panel-heading" align="left">
				<font color="white	"><b>회원 정보 수정</b></font> 페이지입니다.
			</div>
			<div class="panel-body sub_container">
				<form id="myform" name="myform" class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post">
					<input type="hidden" name="command" value="usUpdate">
					<input type="hidden" name="isCheck" value="false">
					<input type="hidden" name="point" value="500">
					<div class="form-group">
						<label for="id" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">아이디</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			<input type="text" name="fakeid" id="fakeid" class="form-control" disabled="disabled" placeholder="아이디" 
		            			value="${requestScope.bean.id}" onkeyup="function3();" >
		            		<input type="hidden" name="id" id="id" value="${requestScope.bean.id}" >
		            			
	            			<span class="err">${errid}</span>  
	        			</div>
	        			<div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
	        			</div>
	        		</div>        		
				
					<div class="form-group">
						<label for="password" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">비밀 번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="password" name="password" id="password" class="form-control" placeholder="변경하실 비밀번호를 입력해주셔요" value="" >
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
	            						<label class="radio-inline"> 
	            			<c:if test="${requestScope.bean.gender == '남자'}">
	            				<input type="radio" name="gender" value="남자" checked="checked">남자
	            			</c:if>
	            			<c:if test="${requestScope.bean.gender != '남자'}">
	            				<input type="radio" name="gender" value="남자">남자
	            			</c:if>
							</label> <label class="radio-inline"> 
	            			<c:if test="${requestScope.bean.gender == '여자'}">
	            				<input type="radio" name="gender" value="여자" checked="checked">여자
	            			</c:if>
	            			<c:if test="${requestScope.bean.gender != '여자'}">
	            				<input type="radio" name="gender" value="여자">여자
	            			</c:if>
 
							</label>
							<span class="form-control-static err">${errgender}</span>
	        			</div>
	        		</div>
	        			<div class="form-group">							
						<label for="birth" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">생년월일</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="date" name="birth" id="birth" class="form-control" placeholder="생년월일" value="${requestScope.bean.birth}">
	            			<span class="err">${errbirth}</span> 
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="zipcode" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">우편 번호</label>
	        			<div class="col-xs-<%=formright-2%> col-lg-<%=formright-2%>">
	            			<input type="text" name="fakezipcode" id="fakezipcode" class="form-control" disabled="disabled" placeholder="우편 번호" value="${requestScope.bean.zipcode}" >
	            			<input type="hidden" name="zipcode" id="zipcode" value="${requestScope.bean.zipcode}" > 
	        			</div>
						<div class="col-xs-<%=2%> col-lg-<%=2%>" align="left">
	            			<input type="button" class="btn btn-info" value="우편 번호 찾기" onclick="function2( );"> 
	        			</div>
	        			<span class="err">${errzipcode}</span>	        			
	        		</div> 
	        		<div class="form-group">
						<label for="address1" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">주소</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            		    <input type="text" name="fakeaddress1" id="fakeaddress1" class="form-control" disabled="disabled" placeholder="주소" value="${requestScope.bean.address1}" >
	            			<input type="hidden" name="address1" id="address1" value="${requestScope.bean.address1}" >
	            			<span class="err">${erraddress1}</span> 
	        			</div>
	        		</div>
					<div class="form-group">
						<label for="address2" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">세부 주소</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="address2" id="address2" class="form-control" placeholder="주소를 상세하게 입력해주세요." value="${requestScope.bean.address2}">
	            			<span class="err">${erraddress2}</span> 
	        			</div>
	        		</div>
	        		<div class="form-group">
						<label for="phone" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">전화번호</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
	            			<input type="text" name="phone" id="phone" class="form-control" placeholder="010-1234-5678 형식으로 입력해주세요." value="${requestScope.bean.phone}">
	            			<span class="err">${errphone}</span> 
	        			</div>
	        		</div>
	        			<input type="hidden" name="grade" id="grade" value="일반">
					<div class="form-group">
						<div class="col-xs-<%=12%> col-lg-<%=12%>" align="center">
							<button type="submit" class="btn btn-default"><b>정보 수정</b></button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<b><a href="<%=MyCtrlCommand%>usDelete&id=${requestScope.bean.id}">회원 탈퇴</a></b>
							<!-- <button type="button" class="btn btn-default""><b><a href="<%=MyCtrlCommand%>usDelete&id=${requestScope.bean.id}">회원 탈퇴</a></b></button> -->
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
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