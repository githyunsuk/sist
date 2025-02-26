package day0210;

import java.util.StringTokenizer;

/**
 * 문자열을 짧은 하나의 마디로 구분하는 StringTokenizer 사용
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		
		String data="안녕 하세요? 오늘은 월요일 입니다!";	//자르기위한 대상 문자열
	
//		문자열을 할당하지 않아 토큰에 저장된 주소가 출력
		StringTokenizer stk=new StringTokenizer(data);
		System.out.println(stk);
		
		System.out.println(stk.countTokens());		//잘려질 수 있는 토큰 개수

		String token="";
		while(stk.hasMoreTokens()) {	//토큰 존재여부
			token=stk.nextToken();		//토큰을 얻고, 포인터를 다음으로 이동
			System.out.println(token);
		} //end while
		
		System.out.println("남은 토큰 개수 : "+stk.countTokens());	//잘려질 수 있는 토큰 개수
		
		data="Java,Oracle,JDBC.HTML,CSS,JavaScript~jQuery,Vue.js~Servlet!JSP";
		
		//특정 문자로 토큰을 생성하는 생성자사용
		StringTokenizer stk2=new StringTokenizer(data,",.~J");
		System.out.println(data+" 를 전달했을때 토큰의 개수 : "+stk2.countTokens());
		
		while(stk2.hasMoreTokens()) {	//토큰 존재하면 true
//			stk2.nextToken();			//method 한번 사용할 때마다 포인터가 이동
			System.out.println(stk2.nextToken());
		} //end while
		
		String email="test@sist.com";
		
		StringTokenizer stk3=new StringTokenizer(email, "@.");
		while(stk3.hasMoreTokens()) {	//토큰 존재하면 true
			System.out.println(stk3.nextToken());
		} //end while
		
	} //UseStringTokenizer
	
	public static void main(String[] args) {
		new UseStringTokenizer();

	} //main

} //class
