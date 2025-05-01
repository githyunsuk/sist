<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%
	String name = (String)session.getAttribute("name");
	if(name == null){
		response.sendRedirect("http://192.168.10.75/jsp_prj/day0501/use_session_a.jsp");
		return;
	}
%>