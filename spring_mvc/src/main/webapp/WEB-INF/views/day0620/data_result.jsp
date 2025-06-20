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
	$("#btn").click(function(){
		var radioValue = $("[name='type']:checked").val();
		
		var frm = $("#frm")[0];
		var tempAction = "useModel";
		if(radioValue == "mav"){
			tempAction = "useMav";
		}
		if(radioValue == "request"){
			tempAction = "useRequest";
		}
		frm.action = tempAction;
		alert(frm.action);
		frm.submit();
	});
});
</script>
</head>
<body>
<img src="/images/default_img2.png" style="width:100px"/>
<h3><c:out value="${dataObj}"/> <fmt:formatDate value="${requestScope.nowDate}" pattern="yyyy-MM-dd EEEE"/></h3>
<table class="table table-hover">
<thead>
<tr>
	<th style="width : 10%">번호</th>
	<th style="width: 90%">이름</th>
</tr>
</thead>
<tbody>
<c:if test="${empty names}">
<tr>
	<td colspan="2">이름이 없습니다.</td>
</tr>
</c:if>
<c:forEach var="name" items="${names}" varStatus="i">
<tr>
<td><c:out value="${i.count}"/></td>
<td><c:out value="${name}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="javascript:history.back()">뒤로</a>
</body>
</html>