<%@page import="day0512.Member"%>
<%@page import="java.util.List"%>
<%@page import="day0512.MemberService"%>
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
 #container { min-height: 600px; margin-top: 30px; margin-left: 20px}
 a { text-decoration:none; color:#333 }
 a:hover { text-decoration:none; color:#000FFF }
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
List<Member> list = new MemberService().searchAllMember();

pageContext.setAttribute("memberList", list);
%>
<table class="table table-hover">
<thead>
<tr>
<th>번호</th>
<th>회원번호</th>
<th>회원명</th>
<th>이메일</th>
<th>전화</th>
</tr>
</thead>
<tbody>
<c:if test="${ empty memberList }">
	<tr>
	<td colspan="5">회원 정보가 존재하지 않습니다.</td> 
	</tr>
</c:if>
<c:forEach var="member" items="${ memberList }" varStatus="i">
	<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><c:out value="${ member.num }"/></td>
	<td><a href="member_modify.jsp?member_num=${ member.name }"><c:out value="${ member.name }"/></a></td>
	<td><input type="text" value="${ member.email }"/></td>
	<td><input type="text" value="${ member.tel }"/></td>
	</tr>
</c:forEach>
</tbody>
</table>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>