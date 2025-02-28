package day0228;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseLambda {

	public static void main(String[] args) {

		//람다식 사용.
		//반환형 없고 매개변수 없는 method : () -> { }
		//선언 : () -> { }, 호출 : 인터페이스객체명.method명();
		System.out.println("----반환형 없고, 매개변수 없는 형-------");
		LambdaTypeA lta = () -> {
			System.out.println("오늘은 금요일");
			System.out.println("내일은 토요일");
		};
		
		//호출
		lta.test();
		
		System.out.println("---------반환형 없고, 매개변수 있는 형--------");
		LambdaTypeB ltb = (int i, String name) -> {
			System.out.println(i);
			System.out.println(i*5);
			System.out.println(name);
			int j = i;
			System.out.println(j);
			
		};
		
		//호출
		ltb.test(1,"3월 1일은 쉽니다");
		System.out.println("---------반환형 있고, 매개변수 없는 형--------");
		LambdaTypeC ltc = () -> {
			String msg = "자바는 완벽한 oop 언어입니다.";
			return msg;
		};
		
		//호출
		String msg = ltc.test();
		System.out.println(msg);
		
		System.out.println("---------반환형 있고, 매개변수 없는 형--------");
		LambdaTypeD ltd = (Date date) -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			return sdf.format(date);
		};
		
		//호출
		String msg2 = ltd.test(new Date());
		System.out.println(msg2);
		
		System.out.println("-----Thread로 구구단 2단을 출력하는 코드를 람다식을 사용하여 출력------------");
		
		Thread t = new Thread(() -> {
			for(int i=1; i<=9; i++) {
				System.out.printf("%d * %d = %d\n", 2, i, 2*i);
			}
		} );
		
		t.start();
	}

}
