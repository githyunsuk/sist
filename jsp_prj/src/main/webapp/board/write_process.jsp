<%@page import="kr.co.sist.board.BoardService"%>
<%@page import="kr.co.sist.member.login.LoginResultDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ include file="../common/jsp/site_config.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/jsp/login_chk.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bDTO" class="kr.co.sist.board.BoardDTO" scope="page"/>
<jsp:setProperty name="bDTO" property="*"/>
<%
//useBean으로 입력되는 parameter는 subject, contetn만 존재
bDTO.setId( ((LoginResultDTO)session.getAttribute("userData")).getId());
out.println(request.getParameter("num"));
/* BoardService bs = new BoardService();
pageContext.setAttribute("writeFlag", bs.writeBoard(bDTO)); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ site_name }"/></title>
<script type="text/javascript">
<%--<c:choose>
	<c:when test="${writeFlag}">
		alert("글쓰기 완료 되었습니다.");
		location.href="${url}/board/board_list.jsp"
	</c:when>
	<c:otherwise>
		alert("글쓰기 실패!!");
		history.back();
	</c:otherwise>
</c:choose>--%>
</script>
</head>
<body>

</body>
</html>