<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
	<%!
		public class PersonBean{
			private String name;
			private int age;
			public PersonBean(){
				
			}
			public PersonBean(String name,int age){
				this.name = name;
				this.age = age;
			}
			public void setName(String name){
				this.name = name;
			}
			public String getName(){
				return name;
			}
			public void setAge(int age){
				this.age = age;
			}
			public int getAge(){
				return age;
			}
	}
	%>
	<%
		ArrayList<PersonBean>list = new ArrayList<PersonBean>();
		PersonBean bean = new PersonBean("Tanaka",30);
		list.add(bean);
		bean = new PersonBean("Yoshida",45);
		list.add(bean);
		bean = new PersonBean("Itokazu",20);
		list.add(bean);
		request.setAttribute("people",list);
		%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr><td>名前</td><td>年齢</td></tr>
	
	<c:forEach items="${people}" var = "person" >
		<tr><td>${person.name}</td><td>${person.age}</td></tr>
	</c:forEach>
	
	</table>
	
</body>
</html>