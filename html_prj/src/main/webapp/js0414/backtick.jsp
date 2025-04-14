<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String name = "강태일";
	pageContext.setAttribute("name", name);
%>
<script type="text/javascript">
	var name = "이장훈";
	//JSP는 JavaScript보다 수행 우선순위가 높다. backtick에서
	//${ name }을 사용하면 JSP에 EL로 실행된다.
	alert(`이름은 ${ name }입니다.`)
</script>
</head>
<body>
</body>
</html>