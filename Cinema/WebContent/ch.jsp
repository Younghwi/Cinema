<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript">

String.prototype.trim=function(){

	var p=/(^\s*)|(\s*$)/g;

	return this.replace(p,"");

}




function send() {

	var f=document.forms[0];

	var row=f.row.value;

	if(! row) {

		alert("행수를 입력 하세요!!!");

		f.row.focus();

		return;

	}

	

	if(! /^[0-9]*$/g.test(row)){

		alert("행은 숫자만 가능합니다.");

		f.row.focus();

		return;

	}

	if(parseInt(row)<5){

		alert("행은 5이상만 입력 가능합니다.");

		f.row.focus();

		return;

	}

	f.row.value=row; // 앞뒤 공백 제가 한 값을 다시 대입해줌.

	

	var col=f.col.value;

	if(! col) {

		alert("열수를 입력 하세요!!!");

		f.col.focus();

		return;

	}

	

	if(! /^[0-9]*$/g.test(col)){

		alert("열은 숫자만 가능합니다.");

		f.col.focus();

		return;

	}

	if(parseInt(col)<5){

		alert("열은 5이상만 입력 가능합니다.");

		f.col.focus();

		return;

	}

	f.col.value=col;

	

	f.submit();

	

}

</script>

</head>

<body>




<form action="ch_form.jsp" method="post">

행수 : <input type="text" name="row"><br/>

열수 : <input type="text" name="col"><br/>

<input type="button" value="보내기" onclick="send();"><br/>

</form>

</body>

</html>
