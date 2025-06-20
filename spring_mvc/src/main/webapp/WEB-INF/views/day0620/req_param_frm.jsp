<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script>
$(function(){
   $("#email2").change(function(){
      var domain=$("#email2").val();
      
      $("#email3").val(domain);
      if(domain == "none" ){
         $("#email3").val("");
         $("#email3").focus();
      }
      alert( domain )
   });
   
   $("#btn").click(function(){
      $("#frm").submit();
   });//click
});
</script>
</head>
<body>
<form id="frm" method="get" action="/day0620/req_param_process">
<label>이름</label>
<input type="text" name="name"><br>
<label>나이</label>
<input type="text" name="age"><br>
<label>이메일</label>
<input type="text" name="email">@
<select name="email2" id="email2">
<option value="gmail.com">지메일</option>
<option value="naver.com">네이버</option>
<option value="daum.net">다음메일</option>
<option value="none">----직접입력---</option>
</select>
<input type="text" name="email3" id="email3"/>
<input type="button" id="btn" value="전송" class="btn btn-success"/>

</form>
</body>
</html>