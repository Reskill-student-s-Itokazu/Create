<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
     	int num = (int)(Math.random()*4);
     	request.setAttribute("luck",Integer.valueOf(num));
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${luck eq 0 }">今日はいいことがあるでしょう。</c:when>
		<c:when test="${luck eq 1 }">今日はまあまあでしょう。</c:when>
		<c:when test="${luck eq 2 }">今日は付いてないでしょう。</c:when>
		<c:otherwise>もう一回やってみましょう。</c:otherwise>
	</c:choose>

</body>
</html>