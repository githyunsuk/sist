package day0211;

import java.util.Calendar;

/**
 * Calendar를 사용하여 다른 날짜 얻기 
 */
public class UseCalendar {
	
	public UseCalendar() {
		//1. 객체 생성: 시스템의 날짜를 가진 객체 생성
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		//cal.set(Calendar.YEAR, 2026);
		//사람이 생각하는 월보다 1 적게 설정.
		//cal.set(Calendar.MONTH, 5-1);
		
		cal.set(2026, 4, 25);
		cal.set(Calendar.DAY_OF_MONTH, 32);
		
		StringBuilder date = new StringBuilder();
		date
		.append(cal.get(Calendar.YEAR)).append("-")
		.append(cal.get(Calendar.MONTH)+1).append("-")
		.append(cal.get(Calendar.DAY_OF_MONTH)).append(" 이번 달의 마지막 날 ")
		.append(cal.getActualMaximum(Calendar.DATE)).append("일 ")
		.append(",일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK)])
		.append("요일 ");
		
		String str = date.toString();
		System.out.println(str);
	}

	public static void main(String[] args) {
		
		new UseCalendar();
	}

}
