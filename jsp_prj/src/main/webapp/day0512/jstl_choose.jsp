<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- guest, user, admin 
guest - 읽기
user - 읽기, 쓰기
admin - 읽기, 쓰기, 삭제
-->
<table class="table table-hover">
<thead>
<tr>
	<th>번호</th>
	<th>이름</th>
</tr>
</thead>
<tbody>
<tr>
	<td>1</td>
	<td>일장훈</td>
</tr>
<tr>
	<td>2</td>
	<td>이장훈</td>
</tr>
<tr>
	<td>3</td>
	<td>삼장훈</td>
</tr>
</tbody>
</table>
<c:choose>
<c:when test="${ param.role == 'u' }">
<button class="btn btn-success">읽기</button>
<button class="btn btn-info">쓰기</button>
</c:when>
<c:when test="${ param.role == 'a' }">
<button class="btn btn-success">읽기</button>
<button class="btn btn-info">쓰기</button>
<button class="btn btn-danger">삭제</button>
</c:when>
<c:otherwise>
<button class="btn btn-success">읽기</button>
</c:otherwise>
</c:choose>
<a href="jstl_choose.jsp?role=g">손님</a>
<a href="jstl_choose.jsp?role=u">사용자</a>
<a href="jstl_choose.jsp?role=a">관리자</a>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>