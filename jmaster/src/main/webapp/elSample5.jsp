<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<String>list = new ArrayList<String>();
    	list.add("one");
    	list.add("two");
    	list.add("three");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ArrayListの中身は
	<br>${data[0]}
	<br>${data[1]}
	<br>${data[2]}
	<br>です
</body>
</html>