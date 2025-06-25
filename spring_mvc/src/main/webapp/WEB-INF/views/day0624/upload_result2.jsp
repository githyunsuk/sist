<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  bootstrap CDN -->
<link rel="stylesheet" type="text/css"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 <!-- jquery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script>
$(function(){
});
</script>
</head>
<body>
<img src="/images/default_img2.png" style="width: 100px; height: 150px" />
<c:set var="msg" value="실패"/>
<c:if test="${ uploadFlag }">
<c:set var="msg" value="성공"/>
</c:if>
<h2>파일 업로드 <c:out value="${ msg }"/></h2>
업로드 정보 : 
<ul>
<c:forEach var="viewFileName" items="${ viewFileNames }">
<li><c:out value="${ viewFileName }"/></li>
</c:forEach>
</ul>
<h2>변경된 파일명</h2>
<ul>
<c:forEach var="fileName" items="${ fileData.fileName }">
<li><c:out value="${ fileName }"/></li>
</c:forEach>
</ul>
<a href="javascript:history.back()">뒤로</a>
</body>
</html>