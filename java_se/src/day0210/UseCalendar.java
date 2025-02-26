package day0210;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * java.util.UseCalendar 사용예제
 * 날짜 정보를 얻을 때 사용하는 클래스
 * 추상 클래스이므로 직접 객체화 되지 않음
 * 1. 
 * 2. 자식클래스를 사용하여 객체를 생성함 (is a 관계의 객체화)
 */
public class UseCalendar {

	public UseCalendar() {
//		직접 객체화 할 수 없음
//		Calendar cal=new Calendar();
		
		Calendar cal=Calendar.getInstance();

		//		2. 자식클래스를 사용하여 객체화
		Calendar cal2=new GregorianCalendar();
		System.out.println(cal2);
		
		StringBuilder date = new StringBuilder();
		date.append(cal.get(Calendar.YEAR)).append("년 ")
		.append(cal.get(Calendar.MONTH)+1).append("월 ")
		.append(cal.get(Calendar.DAY_OF_MONTH)).append("일 ")
		.append(cal.get(Calendar.DAY_OF_YEAR)).append("번째날 ");
		
		String[] week="일,월,화,수,목,금,토".split(",");
		date.append(week[ cal.get(Calendar.DAY_OF_WEEK)-1 ]).append("요일 ");
		
		/*
		switch(cal.get(Calendar.AM_PM)) {
		case Calendar.AM : date.append("졸린 오전 "); break;
		case Calendar.PM : date.append("피곤한 오후 "); break;
		} //end switch
		*/
		
		date.append("오전,오후".split(",")[cal.get(Calendar.AM_PM)]).append(" ");
		
		date.append(cal.get(Calendar.HOUR)).append("시 ")
		.append(cal.get(Calendar.HOUR_OF_DAY)).append("시 ")
		.append(cal.get(Calendar.MINUTE)).append("분 ")
		.append(cal.get(Calendar.SECOND)).append("초") ;
		
		System.out.println(date);
//		System.out.println(Calendar.YEAR);
		
	} //UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	} //main

} //class
