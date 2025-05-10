<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="EL에서 scope 객체의 사용"%>
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
	//1.변수 선언
	String msg = "오늘은 비내리는 금요일";
	//2.scope객체 할당
	pageContext.setAttribute("msg", msg);
	
	pageContext.setAttribute("name", "이장훈");
	request.setAttribute("name","주현석");
	session.setAttribute("name", "홍준성");
	application.setAttribute("name", "유연수");
%>

<!-- 3. EL에서 scope객체를 사용하여 접근 -->
${ msg }, (${ pageScope.msg })<br>
scope객체가 동일한 속성명을 가질 때 EL에서 scope 객체를 생략하면
pageScope를 사용하게 된다.<br>
${ name }<br>
pageScope : ${ pageScope.name }<br>
requestScope : ${ requestScope.name }<br>
sessionScope : ${ sessionScope.name }<br>
applicationScope : ${ applicationScope.name }<br>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>