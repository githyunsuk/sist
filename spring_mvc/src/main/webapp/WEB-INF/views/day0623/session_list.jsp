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

<h2>세션사용</h2>
<div>
<a href="/day0623/session_setvalue">HttpSession</a>,
<a href="/day0623/session_getvalue">GetSession 값얻기</a>,
<br>
이름 : <c:out value="${ sessionScope.name }"/>
나이 : <c:out value="${ sessionScope.age }"/>
</div>

<a href="/day0623/model_setvalue">@SessionAttributes값 설정</a>,
<a href="/day0623/model_getvalue">@SessionAttributes값 얻기</a>,
<a href="/day0623/session_complete">세션 삭제</a>
<br>
Model 이름 : <c:out value="${ sessionScope.name }"/>
Model 나이 : <c:out value="${ sessionScope.age }"/>
request 이름 : <c:out value="${ requestScope.name }"/>
request 나이 : <c:out value="${ requestScope.age }"/>
</div>

</body>
</html>