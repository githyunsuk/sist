package day0210;

import java.util.Date;	//util 패키지의 클래스 하나를 사용할때 : 권장O
//import java.sql.Date;	//권장 X

//import java.util.List;
//import java.util.ArrayList;

//import java.util.*;	//util package의 모든 클래스나 인터페이스를 참조하여 사용 : 권장 X, 속도느림

/**
 * 현재 day0210 package 의 다른 클래스,
 * java.lang package 에서 제공하는 클래스들은
 * import 없이 사용가능
 */
public class ImportTest {

	public static void main(String[] args) {
//		String ss="ddd";						//java.lang
		Math.abs(33);							//java.lang
//		StringBuilder sb=new StringBuilder();	//java.lang
		
		UseStringTokenizer ust=new UseStringTokenizer();	//현재 package 의 다른 클래스
		System.out.println(ust);
		
		Date d=new Date();		//java.util
		System.out.println(d);
//		full path로 처리해야 오류가 나지 않음
		java.sql.Date d2=new java.sql.Date(System.currentTimeMillis());		//java.sql
		System.out.println(d2);
		
		/*
		List l=new ArrayList();	//java.util
		System.out.println(l);
		*/
		
		java.awt.List list=new java.awt.List();	//java.awt
		System.out.println(list);
	} //main

} //class
