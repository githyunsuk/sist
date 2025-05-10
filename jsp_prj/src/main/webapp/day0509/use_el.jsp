<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/jsp/external_file.jsp"/>
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
<jsp:include page="../common/jsp/header.jsp"></jsp:include>
</header>
<main>
<div id="container">

<h2>EL에서 변수의 사용</h2>
<%
	String name = "주현석";
	int age = 26;
	//EL에서 변수를 사용하려면 scope 객체 할당.
	pageContext.setAttribute("na", name);
	pageContext.setAttribute("age", age);
%>
이름 : ${ name },  <%= name %>, (${ na }), ${ age }
<h2>EL에서 제공하는 연산자 사용.</h2>
<%
	boolean flag = false;
	int i = 5;
	int j = 9;
	pageContext.setAttribute("flag", flag);
	pageContext.setAttribute("i", i);
	pageContext.setAttribute("j", j);
%>

단항 : ${ flag }, ${ !flag }, ${ not flag }, ${ --age }<br>
산술 : ${ i } + ${ j } = ${ i + j }, ${ i } % 2 = ${ i % 2 } ( ${ i mod 2 })<br>
관계 : ${ i > 4 } ( ${ i gt 4 })
	  ${ i < 4 } ( ${ i lt 4 })
	  ${ i >= 5 } ( ${ i ge 5 })
	  ${ i <= 5 } ( ${ i le 5 })<br>
논리 : ${ i > 4 && i < 6 } ( ${i gt 4 and i lt 6 })
	  ${ i > 6 || i < 3 } ( ${i gt 6 or i lt 3 })<br>
	  
<!-- EL에서는 문자가 없다. 문자열을 표현할 때 ",' 모두 사용가능 -->
삼항: ${ i % 2 == 0 ? "짝수" : "홀수" }
	 ${	i mod 2 eq 0 ? "짝수" : "홀수" }<br>
	 
<!-- scope 객체가 가지고 있는 i 값이 0~10 사이라면 유효 그렇지 않으면 "무효를 출력 -->
${i ge 0 and i le 10 ? "유효" : "무효" }<br>
<%
	String str = null; //객체가 생성되지 않음
	String str2 = ""; //literal에 비어있는 값(empty)을 할당
	List<String> list = new ArrayList<String>(); //빈 리스트 생성
	if(new Random().nextBoolean()){
		list.add("EL사용함.");
	}
	
	pageContext.setAttribute("str", str);
	pageContext.setAttribute("str2", str2);
	pageContext.setAttribute("list", list);
%>
null 비교 : ${ empty str }<br>
""비교 : ${ empty str2 }<br>
list size가 0인지 비교 : ${ empty list }<br>
</div>
</main>
<footer class="text-body-secondary py-5">
<jsp:include page="../common/jsp/footer.jsp"></jsp:include>
</footer>
</body>
</html>