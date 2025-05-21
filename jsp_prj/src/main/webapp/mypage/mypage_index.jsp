<%@page import="kr.co.sist.member.MemberService"%>
<%@page import="kr.co.sist.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ include file="../common/jsp/site_config.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/jsp/login_chk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ site_name }"/></title>
<c:import url="${url}/common/jsp/external_file.jsp"/>
<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
</style>
<script type="text/javascript">
$(function(){
	$("#btnImg").click(function(){
		$("#profileImg").click();
	});
	
	$("#profileImg").change(function( evt ){
		//선택한 파일이 이미지인지 확인
		$("#imgName").val($("#profileImg").val());
		//이벤트 발생시킨 file객체를 얻는다.
		var file = evt.target.files[0];
		//스트림을 생성
		var reader = new FileReader();
		//FileReader 객체의 onload event handler 설정

		reader.onload = function(evt){
			$("#img").prop("src", evt.target.result);
		}
		
		//파일을 읽어들여 img 설정
		reader.readAsDataURL(file);
	});
});
</script>
</head>
<body>
<header data-bs-theme="dark">
<c:import url="${url}/common/jsp/header.jsp"/>
</header>
<main>
<div id="container">
<%
 String id = ((LoginResultDTO)session.getAttribute("userData")).getId();

 MemberService ms = new MemberService();
 MemberDTO mDTO = ms.searchOneMember(id);
 
 if(mDTO == null){
	 response.sendRedirect("http://localhost/jsp_prj");
 }
 
 pageContext.setAttribute("mDTO", mDTO);
%>
<div>
<h3>마이페이지</h3>
<form action="mypage_process.jsp" method="post" name="frm">
<div style="float:Left">
<img src="../common/images/${mDTO.profile_img}" style="width:130px; height:140px" id="img"/>
<br>
<input type="button" value="이미지선택" id="btnImg" class="btn btn-info btn-sm"/>
<input type="hidden" name="img" id="imgName"/>
<input type="file" style="display:none" name="profileImg" id="profileImg"/>
</div>
<table style="float:Left; clear:both;">
<tr>
<td>이름</td>
<td><c:out value="${mDTO.name}"/></td>
</tr>
<tr>
<td>생년월일</td>
<td><input type="date" name="birth" value="${mDTO.birth}"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="tel" value="${mDTO.tel}"></td>
</tr>
<tr>
<td>성별</td>
<td><input type="radio" name="gender" value="남자"${mDTO.gender eq '남자'?" checked='checked'" : "" }>남자
<input type="radio" name="gender" value="여자"${mDTO.gender eq '여자'?" checked='checked'" : "" }>여자</td>
</tr>
<tr>
<td>가입시 사용된 ip address </td>
<td><c:out value="${mDTO.ip}"/></td>
</tr>
<tr>
<td>가입일</td>
<td><fmt:formatDate value="${mDTO.input_date}" pattern="yyyy-MM-dd a EEEE HH:mm"/></td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<input type="button" value="정보변경" class="btn btn-info"/>
</td>
</tr>
</table>
</form>
</div>
</div>
</main>
<footer class="text-body-secondary py-5">
<c:import url="${url}/common/jsp/footer.jsp"/>
</footer>
</body>
</html>