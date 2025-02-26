package day0211;

import java.time.LocalDate;
import java.time.Month;

public class UseWeek {

	public UseWeek() {
		//1.이넘 객체 얻기
		Week week = Week.TUE;
		//2.getter 호출
		System.out.println(week); //영어 요일명
		System.out.println(week.getName()); //한글 요일명
		System.out.println(week.getValue()); //한글 요일의 식별번호
		System.out.println(week.ordinal()); //영어 요일요소의 식별번호
		
		System.out.println("--------------Week enum의 모든 요소 출력----------------");
		for(Week w: Week.values()) {
			System.out.println(w+" / "+w.getName()+" / "+w.getValue()+" / "+w.ordinal());
		}
		
		//switch
		Week key = Week.MON;
		
		switch(key) {
		case MON: System.out.println(key.getName()); break;
		case TUE: System.out.println(key.getName()); break;
		case WED: System.out.println(key.getName()); break;
		case SUN: System.out.println(key.getName()); break;
		}
		
		LocalDate ld = LocalDate.now();
		Month month = ld.getMonth();
		System.out.println(month+" / "+month.ordinal()+" / "+month.getValue());
		
		switch(month) {
		case JANUARY: System.out.println("1월"); break;
		case FEBRUARY: System.out.println("2월"); break;
		}
		//배열로 1~12월 까지를 생성하고 Month를 사용하여 한글로 출력해보세요.
		String[] arr = {"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};
		System.out.println(arr[month.ordinal()]);
		
	}
		
	public static void main(String[] args) {
		new UseWeek();
	}

}
