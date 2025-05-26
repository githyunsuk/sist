<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ include file="../common/jsp/site_config.jsp" %>
<%
	String fileName = request.getParameter("fileName");
	String downFile = fileName;
	fileName = URLEncoder.encode("UTF-8", fileName);
	
	//2.응답 헤더를 변경 : 선택한 파일명으로 응답 파일명이 설정된다.
	response.setHeader("Content-Disposition", "attachement;fileName=" + fileName);

	//3.다운로드할 파일의 정보를 얻기
	File file = new File("C:/dev/workspace/sist/jsp_prj/src/main/webapp/upload/"+fileName);
	
	
	if(file.exists()){
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		byte[] readData = new byte[512];
		int readSize = 0;
		
		while((readSize = fis.read(readData)) != -1){
			os.write(readData, 0, readSize);
		}
		
		os.flush();
		
		out.clear();
		
		out = pageContext.pushBody();
	}
%>