package day0210;

import java.util.Date;

/**
 * Date 사용하는 예제
 */
public class UseDate {

	public UseDate() {
		
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		Date date=new Date();	//시스템의 날짜를 연산하여, 현재 날짜정보를 가진 객체가 생성
		System.out.println(date);
		
//		현재날짜가 아닌 다른 날짜를 얻을 때
		System.out.println(1000L*60*60*24*30*12*10);
//		연산결과가 21억을 초과하면 int 형은 값을 저장할 수 없기 때문에 long 형으로 연산
		Date date2=new Date(System.currentTimeMillis()+(1000L*60*60*24*30*12*10));
		System.out.println(date2);
		
//		어제의 날짜
		Date date3=new Date(System.currentTimeMillis()-(60*60*24*1));
		System.out.println(date3);
	} //UseDate
	
	public static void main(String[] args) {
		new UseDate();
	} //main

} //class
