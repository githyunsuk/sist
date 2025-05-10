<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="EL을 사용한 출력"%>
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
<%
	request.setCharacterEncoding("UTF-8");
%>
<%-- <!-- 객체생성 및 사용 범위 설정 -->
<jsp:useBean id="param" class="day0508.Param" scope="page"></jsp:useBean>
<!-- setter method 호출 모든 파라메터 받기 -->
<jsp:setProperty property="*" name="param"/>

<%=param %> --%>
<ul>
<li><label>text</label> : ${ param.txt }</li>
<li><label>age</label> :  ${ param.age }</li>
<li><label>password</label> :  ${ param.pass }</li>
<li><label>file</label> :  ${ param.file }</li>
<li><label>hidden</label> :  ${ param.hid }</li>
<li><label>checkbox 하나</label> :  ${ param.flag }</li>
<li><label>select</label> :  ${ param.sel }</li>
<li><label>textarea</label> :  ${ param.ta }</li>
<li><label>checkbox 여러개</label> :  
	${ paramValues.lang }<br>
	${ paramValues.lang[0] }
</li>
</ul>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>