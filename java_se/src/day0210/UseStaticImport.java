package day0210;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
//import static java.lang.Long.MAX_VALUE;
//클래스명은 다르지만 constant 이름이 같기 때문에 오류 발생
/**
 * 다른 클래스의 static 변수(constant)나 static method 를 클래스명 없이 사용할때
 */
public class UseStaticImport {
	
	public UseStaticImport() {
		System.out.println("int의 최고값 : "+MAX_VALUE);
		
		int value=MAX_VALUE;
		System.out.println("int의 최고값 변수 value에 출력 : "+value);
		
		String num="2025.02";
		String num2="2.1";
		
		double d=parseDouble(num);
		double d2=parseDouble(num2);
		
		System.out.printf("문자열 %s의 실수 변경 값 : %.2f\n",num,d);
		System.out.printf("문자열 %s의 실수 변경 값 : %.1f\n",num2,d2);
		
		float f=10.42F;
		String s=valueOf(f);
//		static import 사용하여 method 처리하고 f2 변수를 출력하기
		System.out.printf("실수 %.2f의 문자열 변경 값 : %s\n",f,s);
		
	} //UseStaticImport

	public static void main(String[] args) {
		new UseStaticImport();
	} //main

} //class
