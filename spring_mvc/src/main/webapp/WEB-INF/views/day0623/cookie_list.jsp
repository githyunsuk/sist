<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>

<h2>쿠키사용</h2>
<div>
<a href="/day0623/setCookie">쿠키설정</a>,
<a href="/day0623/getCookie">HttpServletRequest값 얻기</a>,
<a href="/day0623/getCookieAnnotaion">@CookieValue값 얻기</a>
</div>
<c:if test="${not empty cookie.name}">
이름 : <c:out value="${cookie.name.value}"/>
나이 : <c:out value="${cookie.age.value }"/>
</c:if>
</div>
</body>
</html>