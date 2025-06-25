<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript">
$(function(){
		
});
</script>
</head>
<body>
<img src="/images/default_img2.png" style="width:100px"/>
<h2>파일 업로드</h2>
<form action="/day0624/upload_process2" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>파일선택</td>
<td><input type="file" name="upfile" multiple="multiple"/></td>
</tr>
<tr>
<td>업로더</td>
<td><input type="text" name="uploader"/></td>
</tr>
<tr>
<td>대상나이</td>
<td>
<c:forEach var="i" begin="10" end="60" step="10" >
<input type="checkbox" name="targetAge" value="${i}"/><c:out value="${i}"/>대
</c:forEach>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="업로드" class="btn btn-success btn-sm"/>
</td>
</tr>
</table>
</form>
<a href="javascript:history.back()">뒤로</a>
</body>
</html>