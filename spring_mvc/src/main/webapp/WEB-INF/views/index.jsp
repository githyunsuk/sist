<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			location.href="/get_method";
		});
		
		$("#btn2").click(function(){
			var radioValue = $("[name='method']:checked").val();
			var frm = $("#frm")[0];
			frm.method = radioValue;
			frm.submit();
		});
	});
</script>
</head>
<body>
<ul>
<li>
<a href="/get_method">GET방식 요청</a>
<form action="/get_method" method="get">
<input type="submit" value="get방식 요청" class="btn btn-success"/>
</form>
<input type="button" value="Location 객체 요청" id="btn" class="btn btn-success"/>
</li>
<li>
<form action="/post_method" method="post">
<input type="submit" value="POST방식 요청" class="btn btn-success"/>
</form>
</li>

<li>
<form action="/get_post_method" id="frm">
<input type="radio" value="GET" name="method"/> GET방식
<input type="radio" value="POST" name="method"/> POST방식
<input type="button" value="요청" class="btn btn-info" id="btn2"/>
</form>
</li>
<li>
<a href="/day0619/param_frm">web parameter 입력</a>
</li>

</ul>
</body>
</html>