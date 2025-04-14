<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Back-end 페이지</h2>
<!-- 요청시 HTML Form Control에 입력된 값을 받아서 업무로직, DBMS사용,
	응답화면 만들어서, 응답 -->
	<ul>
	<li>text :<%= request.getParameter("text") %></li>
	<li>password :<%= request.getParameter("pass") %></li>
	<li>read : <%= request.getParameter("read") %></li>
	<li>disabled(값을 받을 수 없음) : <%= request.getParameter("dis") %></li>
	<li>checkbox :
	<%= Arrays.toString( request.getParameterValues("hobby")) %></li>
	<li>radio : <%= request.getParameter("gender") %></li>
	<li>hidden : <%= request.getParameter("hid") %></li>
	</ul>

</body>
</html>