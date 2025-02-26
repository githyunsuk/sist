package day0210;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormat
 * letter 반복하여 pattern 을 만들고,
 * pattern 을 일정 format 으로 만들어 원하는 형식의 날짜를 만드는 예제
 */
public class UseSimpleDataFormat {
	
	public UseSimpleDataFormat() {
//		1. SimpleDataFormat 생성 (DateFormat 생성 -> SimpleDataFormat 생성)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a H,k,KK,hh : mm : ss EEEE", Locale.KOREA);
//		Locale 을 사용하면 다른 나라의 날짜형식을 얻을 수 있음
		
//		2. method 호출
//		부모의 format method 를 Date 클래스에 객체를 넣어 호출
//		(코드의 재사용성, DataFormat 과 Data 가 has a 관계를 가진다)
		String formatDate=sdf.format(new Date());
		
		System.out.println(formatDate);
		
		String temp=new SimpleDateFormat("MM월 dd일 yyyy년")
				.format(new Date());
		System.out.println(temp);
		
	} //UseSimpleDataFormat

	public static void main(String[] args) {
		new UseSimpleDataFormat();
	} //main

} //class
