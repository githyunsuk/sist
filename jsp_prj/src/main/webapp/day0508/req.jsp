<%@page import="day0508.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/jsp/external_file.jsp"/>
<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
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
forward로 이동한 페이지
<%
	Counter cnt = (Counter)pageContext.getAttribute("counter");
	Counter cnt2 = (Counter)request.getAttribute("counter2");
	Counter cnt3 = (Counter)session.getAttribute("counter3");
	Counter cnt4 = (Counter)session.getAttribute("counter4");
%>
page scope: <%= cnt %>
request scope: <%= cnt2 %>
session scope: <%= cnt3 %>
application scope: <%= cnt4 %>

<a href="req2.jsp">이동</a>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>