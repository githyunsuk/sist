package day0212;

import java.util.Calendar;
import static java.lang.Integer.parseInt;

/**
 * 입력된 년과 월로 해당 월의 달력을 생성하여 반환하는 일. 
 */
public class Exam0211 {
	
	/** 
	 * 달력을 생성하는 일
	 * @param year
	 * @param month
	 * @return
	 */
	public String createCalendar(String paramYear, String paramMonth) {
		StringBuilder tempCal = new StringBuilder();
		
		Calendar cal = Calendar.getInstance(); //현재 년, 월을 가진 달력 객체 생성
		//값이 입력되지 않는 경우의 처리
		int tempYear = 0;
		int tempMonth = 0;
		if((paramYear != null && !paramYear.isEmpty())) {
			//매개변수가 참조형 일 때는 객체가 생성되었는지 물어봐야하고 ( != null)
			//객체에 따라 연결하여(&&) 추가 작업을 수행해야 할 수도 있다.(isEmpty())
			tempYear = parseInt(paramYear);
			cal.set(Calendar.YEAR, tempYear); //값이 있는 경우에 년을 변경한다.
		}
		if((paramMonth != null && !paramMonth.isEmpty())) {
			//매개변수가 참조형 일 때는 객체가 생성되었는지 물어봐야하고 ( != null)
			//객체에 따라 연결하여(&&) 추가 작업을 수행해야 할 수도 있다.(isEmpty())
			tempMonth = parseInt(paramMonth);
			cal.set(Calendar.MONTH, tempMonth-1); //값이 있는 경우에 년을 변경한다.
		}

		tempYear = cal.get(Calendar.YEAR);
		tempMonth = (cal.get(Calendar.MONTH)+1);
		
		cal.set(Calendar.DAY_OF_MONTH,1);
		
		tempCal.append("\t\t    ").append(tempYear).append("년").append(tempMonth).append("월\n")
		.append("---------------------------------------------------\n")
		.append("일\t월\t화\t수\t목\t금\t토\n")
		.append("---------------------------------------------------\n");
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일의 요일 얻기
		//1일 출력 전에 공백 생성
		for(int blank=1; blank<dayOfWeek; blank++) {
			tempCal.append("\t");
		}

		int lastDay = cal.getActualMaximum(Calendar.DATE); //해당 월 마지막 날
		for(int tempDay=1; tempDay<=lastDay; tempDay++) {
			//증가하는 가상의 일(tempDay)로 Calendar 객체를 설정
			cal.set(Calendar.DAY_OF_MONTH, tempDay);
			tempCal.append(tempDay).append("\t");
			
			//가상의 날로 설정된 일자의 요일을 가져와서 토요일(7)이면 줄넘김
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				tempCal.append("\n");
			}
		}
		
		return tempCal.toString();
	}
	
	public void printCalendar(String calendar) {
		System.out.println(calendar);
	}

	public static void main(String[] args) {
		Exam0211 ex = new Exam0211();
		String calendar = ex.createCalendar("2025", "3");
		ex.printCalendar(calendar);
	}

}
