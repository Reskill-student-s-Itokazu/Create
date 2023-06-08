<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	pageContext.setAttribute("price","300");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL Operator</h1>
	price + 15 = ${price + 15}<br>
	price * 3 =${price * 3}<br>
	price equal 300 =${price eq 300}<br>
	price less than 1000 = ${price lt 1000}<br>
	price greater equal 1000 = ${price ge 1000}<br>
	price is empty = ${empty price}<br>
</body>
</html>