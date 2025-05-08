<%@page import="day0508.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scope의 사용"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/jsp/external_file.jsp"/>
<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
 span{ background-color:#E7C059; font-weight:bold; }
</style>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
<header data-bs-theme="dark">
<jsp:include page="../common/jsp/header.jsp"></jsp:include>
</header>
<main>
<div id="container">
<jsp:useBean id="counter" class="day0508.Counter" scope="session"/>
<jsp:setProperty property="cnt" value="1" name="counter"/>

<h3>당신은 이 페이지에 
<%
	String num = String.valueOf(counter.getCnt());
	for(int i=0; i<num.length(); i++){ %>
		<img src="images/num_<%= num.charAt(i) %>.png" />
<%
	}
%>
번째 방문자입니다.</h3>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>