<%@page import="kr.co.sist.member.login.LoginResultDTO"%>
<%@page import="kr.co.sist.member.login.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%
	//세션에 존재하는 값 얻기
	//String name = (String)session.getAttribute("name");
	Object obj = session.getAttribute("userData");
	if(obj == null){
		response.sendRedirect("http://192.168.10.75/jsp_prj/index.html");
		return;
	}
	LoginResultDTO lrDTO = (LoginResultDTO)obj;
	
%>