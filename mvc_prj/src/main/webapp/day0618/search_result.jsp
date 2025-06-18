<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script src="/main.js"></script>
<script type="text/javascript">  
$(function(){
   $("#btn").click(function(){
		$("#frm").submit();
   });
});//read

</script>
</head>
<body>
<header data-bs-theme="dark">
</header>
<main>
<div id="container">
<h2>메인페이지</h2>
로고, 주력서비스, 로그인
<a href="index.html">메인</a>
<a href="index.do">메인2</a>
<a href="index.do?cmd=M001">메인3</a>
<a href="index.do?cmd=F001">입력폼</a>
<a href="index.do?cmd=R001">메인화면 redirect</a>
<hr>
<h3>사원검색 - 선택부서에 입력한 연봉보다 작은 사원 검색</h3>
<h3><c:out value="${param.deptno}"/>번 부서에 연봉이 
<c:out value="${param.sal}"/>보다 작은 사원 정보</h3>
<table border="1">
<thead>
<tr>
	<th>사원번호</th>
	<th>사원명</th>
	<th>연봉</th>
	<th>직무</th>
	<th>입사일</th>
</tr>
</thead>
<tbody>
<c:forEach var="emp" items="${list}">
<tr>
	<td><c:out value="${emp.empno}"/></td>
	<td><c:out value="${emp.ename}"/></td>
	<td><c:out value="${emp.sal}"/></td>
	<td><c:out value="${emp.job}"/></td>
	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${emp.hiredate}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</main>
<footer class="text-body-secondary py-5">
</footer>

</body>
</html>