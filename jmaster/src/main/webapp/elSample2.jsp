<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	pageContext.setAttribute("data1","This is sample1");
    	application.setAttribute("data2","This is sample2");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>data1は${pageScope.data1}です</h3>
	<h3>data2は${sesionScope.data2}です</h3>
</body>
</html>