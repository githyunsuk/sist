<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
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
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String birth = request.getParameter("birth");
String number = request.getParameter("number");
String phonenumber = request.getParameter("phonenumber");
String frontEmail = request.getParameter("frontEmail");
String backEmail = request.getParameter("backEmail");
String gender = request.getParameter("gender");
String domain = request.getParameter("domain");
String zipcode = request.getParameter("zipcode");
String address = request.getParameter("address");
String address2 = request.getParameter("address2");
String intro = request.getParameter("intro");

%>

<h2><%=name %>님 어서오세요!</h2>
아이디 : <%=id %><br>
비밀번호 : <%=password %><br>
생년월일 : <%=birth %><br>
전화번호 : <%=number %><br>
휴대전화 : <%=phonenumber %><br>
이메일 : <%=frontEmail %>@<%=backEmail %><br>
성별 : <%=gender %><br>
소재지 : <%=domain %><br>
우편번호 : <%=zipcode %><br>
주소 : <%=address %> <%=address2 %><br>
자기소개 : <%=intro %>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>