<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ include file="../common/jsp/site_config.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
//1. 저장 directory 설정
File saveDir = new File("C:/dev/workspace/sist/jsp_prj/src/main/webapp/upload");
//2. 업로드 크기 설정 : 10MByte
int maxSize = 1024*1024*600;
int limitSize = 1024 * 1024 * 10;
try{
//3. 파일 컴포넌트 객체 생성
MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(),
			maxSize, "UTF-8", new DefaultFileRenamePolicy());
String originalName = mr.getOriginalFileName("upfile");
String newName = mr.getFilesystemName("upfile");
String uploader = mr.getParameter("uploader");

File readFile = new File(saveDir.getAbsolutePath() + File.pathSeparator + newName);
if(readFile.length() > limitSize ){
	readFile.delete();
	%>
		최대 업로드 가능한 크기는 10mbyte입니다.
	<%
} else {
//5.파일 명 받기
%>

MultipartRequest : <%= uploader %><br>
원본파일명 : <%= originalName %><br>
새로운 파일명 : <%= newName %><br>
<%
}
}catch(Exception e){
	e.printStackTrace();
}

%>
</div>
</main>
<footer class="text-body-secondary py-5">
<c:import url="${url}/common/jsp/footer.jsp"/>
</footer>
</body>
</html>