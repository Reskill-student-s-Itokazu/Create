<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%-- <%@ page import="la.bean.PlusBean"%>
    <%
    	PlusBean bean = (PlusBean)request.getAttribute("plus");
    %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	<%=bean.getNumber1()%> +<%=bean.getNumber2() %>=<%=bean.getAnswer()%>
	
	<%=bean.getAnswer()%>--%>
	${plus.number1}+${plus.number2}=${plus.answer}
</body>
</html>