<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String[]a=new String[]{"one" , "Two" , "Three"};
    	request.setAttribute("data" , a);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	配列の中身は
	<br>${data[0]}
	<br>${data[1]}
	<br>${data[2]}
	<br>です。

</body>
</html>