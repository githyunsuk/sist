<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="분기"%>
    
<%
request.setCharacterEncoding("UTF-8");
String serverName = request.getServerName();
String movePage = "eng.jsp";
String lang = "english";

//scope 객체에 속성을 설정하며 값을 전달할 수 있다.
request.setAttribute("ip", request.getRemoteAddr());

if( "localhost".equals(serverName)){
	movePage = "kor.jsp";
	lang = "한국어";
}
%>
<jsp:forward page="<%= movePage %>">
	<jsp:param value="<%=lang %>" name="language"/>
</jsp:forward>
