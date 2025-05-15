<%@page import="day0515.Dept"%>
<%@page import="java.util.List"%>
<%@page import="day0515.DeptService"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
    
<%
	DeptService ds = new DeptService();
	
	List<Dept> list = ds.searchAllDept();
	//1. JSONArray 생성) [ ]
	JSONArray jsonArr = new JSONArray();
	
	JSONObject jsonTemp = null;
	
	for(Dept deptDTO : list){
		//2. data를 사용하여 JSONObject 생성
		jsonTemp = new JSONObject();
		jsonTemp.put("deptno", deptDTO.getDeptno());
		jsonTemp.put("dname", deptDTO.getDname());
		jsonTemp.put("loc", deptDTO.getLoc());
		//3. JSONObject를 JSONArray 배치
		jsonArr.add(jsonTemp);
	}
	
	//4. JSONArray 값을 출력
	String strJSON = jsonArr.toJSONString();
%>
<%= strJSON %>
