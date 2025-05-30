<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 파비콘 설정 -->
<link rel="shortcut icon" href="https://cdn.oaistatic.com/assets/favicon-miwirzcw.ico"/>
<!--  site 기본 CSS -->
<link rel="stylesheet" type="text/css"
href="http://192.168.10.76/html_prj/common/css/main_v250409.css"/>
<!--  부트스트랩 CDN-->
<link rel="stylesheet" type="text/css"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"/>
<style type="text/css">
#wrap{ position: relative; margin: 0px auto; width:502px;height: 303px}
#background{height: 303px; background:#FFFFFF url(http://192.168.10.76/html_prj/js0418/images/id_background.png)}
#inputDiv{width: 324px; position: absolute; top:100px; left:50px  }
</style>
<script type="text/javascript">
window.onload=function(){
	
	document.getElementById("btn").addEventListener("click",sendId);
	
}//onload

function sendId() {
	var id=document.subFrm.id.value;
	//부모창으로 값을 전달.
	opener.window.document.frm.id.value=id;
	//창 닫기
	self.close();
}
</script>
</head>
<body>
<div id="wrap">
	<div id="background">
	<div id="inputDiv">
	<form name="subFrm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" autofocus="autofocus"
	value="${ param.id }">
	<input type="button" id="btn" value="중복확인" class="btn btn-primary btn-sm">
	</form>
	</div>
	</div>
</div>
</body>
</html>