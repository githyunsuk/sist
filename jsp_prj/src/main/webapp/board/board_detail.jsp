<%@page import="kr.co.sist.board.BoardService"%>
<%@page import="java.util.Random"%>
<%@page import="kr.co.sist.member.login.LoginResultDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ include file="../common/jsp/site_config.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/jsp/login_chk.jsp" %>
<%
	String paramNum = request.getParameter("num");
	int num = 0;
	try{
		num = Integer.parseInt(paramNum);
	} catch(NumberFormatException nfe){
		response.sendRedirect("board_list.jsp");
		return;
	}
	
	BoardService bs = new BoardService();
	Boolean cntFlag=(Boolean)session.getAttribute("cntFlag");
	if( cntFlag != null & cntFlag.booleanValue() ){ 
		bs.modifyCnt(num);
	 	session.setAttribute("cntFlag", false);
	} 
	
	pageContext.setAttribute("bDTO", bs.searchOneBoard(num));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ site_name }"/></title>
<c:import url="${url}/common/jsp/external_file.jsp"/>
<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}

 td{ padding-top:10px; padding-bottom:}
</style>

<!-- summer note -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<!-- summer note -->

<script type="text/javascript">
$(function(){
	 $('#summernote').summernote({
		 placeholder: '자유롭게 작성하시오',
	     tabsize: 2,
	     height: 240,
	     toolbar: [
	       ['style', ['style']],
	       ['font', ['bold', 'underline', 'clear']],
	       ['color', ['color']],
	       ['para', ['ul', 'ol', 'paragraph']],
	       ['table', ['table']],
	       ['insert', ['picture']],
	     ]
	 });
	 
	 $("#btnWrite").click(function(){
		//제목, 내용 등 필수 입력사항에 대한 유효성 검증
		$("#writeFrm").submit();
	 });
	 
	 $("#btnModify").click(function(){
		setEdit("m");
	 });
	 
	 $("#btnRemove").click(function(){
		setEdit("r");
	 });
});

function setEdit(flag){
	var url = "modify_process.jsp";
	var msg = "변경";
	if(flag == 'r'){
		url = "remove_process.jsp";
		msg = "삭제";
	}
	
	if(confirm("정말 \""+msg+"\" 하시겠습니까?")){
		var obj = $("#writeFrm")[0];
		obj.action = url;  
		obj.submit();
	}
}
</script>
</head>
<body>
<header data-bs-theme="dark">
<c:import url="${url}/common/jsp/header.jsp"/>
</header>
<main>
<div id="container">
<div id="writeWrap" style="width:620px; margin:0px auto">
<div>
<form method="post" id="writeFrm">
<input type="hidden" name="num" value="${bDTO.num}"/>
<table>
<tr>
<th colspan="2" style="text-align:center">
<h3>글 작성</h3>
</th>
</tr>
<tr style="height:40px;">
<td style="width:80px;">제목</td>
<td><input type="text" value="${bDTO.subject}" name="subject" id="subject" style="width:500px; border:1px solid #CDCDCD; height:30px"/></td>
<tr>
<td>내용</td>
<td>
<textarea id="summernote" name="content"><c:out value="${bDTO.content}"/></textarea>
</td>
</tr>
<tr>
<td>조회수: </td>
<td><strong><c:out value="${bDTO.cnt}"/></strong></td>
</tr>
<tr>
<td>작성자ID(ip): </td>
<td><strong><c:out value="${bDTO.id}"/></strong>(<c:out value="${bDTO.ip}"/> )</td>
</tr>
<tr>
<td>작성일 </td>
<td><strong><fmt:formatDate value="${bDTO.input_date}" pattern="yyyy-MM-dd a HH:mm"/></strong></td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<c:if test="${bDTO.id == userData.id}">
<input type="button" id="btnModify" value="글수정" class="btn btn-success btn-sm"/>
<input type="button" id="btnRemove" value="글삭제" class="btn btn-danger btn-sm"/>
</c:if>
<a href="javascript:history.back()" class="btn btn-info btn-sm">글목록</a>
</td>
</tr>
</table>
</form>
</div>
</div>
</div>
</main>
<footer class="text-body-secondary py-5">
<c:import url="${url}/common/jsp/footer.jsp"/>
</footer>
</body>
</html>