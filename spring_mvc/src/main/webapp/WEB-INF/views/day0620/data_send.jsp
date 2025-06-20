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
<img src="/images/default_img2.png" style="width:400"/>
<form id="frm" method="post">
<input type="radio" name="type" value="model" checked="checked"/>Model 사용
<input type="radio" name="type" value="mav"/>ModelAndView사용
<input type="radio" name="type" value="request"/>HTTPServletRequest 사용

<input type="button" id="btn" value="전송" class="btn btn-success"/>
</form>
</body>
</html>