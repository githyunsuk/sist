<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		var tempAction = "/singleTypeProcess";
		if(radioValue == "dto"){
			tempAction = "/dtoProcess";
		}
		if(radioValue == "request"){
			tempAction = "/requestProcess";
		}
		frm.action = tempAction;
		alert(frm.action);
		frm.submit();
	});
});
</script>
</head>
<body>
<form id="frm" method="post">
<label>이름</label>
<input type="text" name="name"/><br>
<label>나이</label>
<input type="text" name="age"/><br>
<label>주소</label>
<input type="text" name="addr"/><br>
<label>성별</label>
<input type="radio" name="gender" value="남자"/>남자
<input type="radio" name="gender" value="여자"/>여자
<br>
<input type="radio" name="type" value="useSingleType" checked="checked"/>단일형으로 받기
<input type="radio" name="type" value="dto"/>DTO로 받기
<input type="radio" name="type" value="request"/>HTTPServletRequest로 받기
<input type="button" id="btn" value="전송" class="btn btn-success"/>
</form>
</body>
</html>