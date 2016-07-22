<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>




<%

	request.setCharacterEncoding("utf-8");




    String _row=request.getParameter("row");

    String _col=request.getParameter("col");

    

    int row=10, col=15;

    if(_row!=null)

    	row=Integer.parseInt(_row);

    if(_col!=null)

    	col=Integer.parseInt(_col);

    

    int w=30+col*30+col/5*20;

    if(col%5==0)

    	w-=20;

%>    

    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>




<style type="text/css">

*{

	padding: 0px; margin: 0px; font-size: 9pt;

}

td {

	font-size: 9pt;font-family: 돋움;

}

</style>




<script type="text/javascript">

function send() {

	var f=document.forms[0];

	 // 자바스트립트에서 표현식 사용 가능

	var row="<%=row%>";

	var col="<%=col%>";

	var n=0;




	for(var i=0; i<row*col; i++) {

		if(f.ch[i].checked==true)

			n++;

	}

	if(n<1 || n>5) {

		alert("좌석은 1~5개 까지 가능 합니다.");

		return;

	}

    

	f.submit();

}

</script>




</head>

<body>

<br/><br/>




<form action="ch_action.jsp" method="post">

<table width="<%=w%>">

<tr height="30">

<%

	out.println("<td width='30'>&nbsp;</td>");

    for(int i=1; i<=col; i++) {

    	if(i!=1 && i%5==1)

    		out.println("<td width='20'>&nbsp;</td>");

    	out.println("<td width='30' align='center'>"+i+"</td>");

    }

%>

</tr>




<%

    String s;

	for(int i=1; i<=row; i++) {

		out.println("<tr height='25'>");

		out.println("<td align='center'>"+i+"</td>");

		for(int j=1; j<=col; j++) {

			if(j!=1 && j%5==1)

				out.println("<td width='20' bgcolor='green'>&nbsp;</td>");

			out.print("<td width='30' align='center'>");

			s=i+":"+j;

			out.print("<input type='checkbox' name='ch' value='"+

			    s+"'>");

			out.println("</td>");

		}

		out.println("</tr>");

	}

%>

</table>




<table width="<%=w%>">

<tr height="50">

      <td align="left">

           <input type="button" value="좌석예약"

                 onclick="send();">

      </td>

</tr>

</table>

</form>

</body>

</html>
