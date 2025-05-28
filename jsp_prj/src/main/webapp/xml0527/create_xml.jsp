<%@page import="org.jdom2.Attribute"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
    info=""%>
<%
//1.XML문서 객체 생성
Document doc = new Document();

//2.최상위 부모노드 생성
Element rootNode = new Element("root");

//3.자식 노드 생성
Element msgNode = new Element("msg");
//자식노드에 값 설정
msgNode.setText("안녕하세요?");

//자식노드에 속성을 설정
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//속성객체 생성
Attribute attr = new Attribute("today", null);
//자식 노드에 배치
msgNode.setAttribute(attr);

//자식노드를 부모노드에 배치
rootNode.addContent(msgNode);
//모든 자식노드를 가진 부모노드를 문서객체에 배치
doc.addContent(rootNode);

//출력객체 생성
XMLOutputter xOut = new XMLOutputter(Format.getPrettyFormat());


try {
	//out 내장객체를 할당하면 web browser로 출룍
	xOut.output(doc,out);
	//xOut.output(doc, new FileOutputStream("C:/dev/workspace/sist/jsp_prj/src/main/webapp/xml0527/create.xml"));
} catch (IOException e) {
	e.printStackTrace();
}

%>