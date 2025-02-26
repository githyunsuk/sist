package day0123;

/**
 * variable arguments가 도입된 console 출력 method 사용. 
 */
public class UsePrintf {

	public void useVariableArguments() {
		int year = 2025, month = 1, day = 23;
		System.out.printf("정수를 출력 %d\n", year);
		System.out.printf("정수 자릿수 출력 [%6d]\n", year); //오른쪽 정렬
		System.out.printf("정수 자릿수 출력 [%-6d]\n", year); //왼쪽 정렬
		System.out.printf("오늘은 %d년 %d월 %d일\n", year, month, day);
		
		char c = 'A';
		System.out.printf("문자 [%c][%3c][%-3c]\n",c,c,c);
		
		double d = 2025.01;
		System.out.printf("실수 출력 %f\n",d);
		d = 12.1234;
		System.out.printf("실수 자릿수 출력 [%10.2f]\n",d);
		System.out.printf("실수 자릿수 출력 [%-10.2f]\n",d);
		System.out.printf("실수 자릿수 출력 [%.2f]\n",d);
		
		boolean b = true, b2 = false;
		System.out.printf("불린 출력 %b %b\n", b, b2);
		System.out.printf("불린 자릿수 출력 [%6b] [%-8b]\n", b, b2);
		
		String name = "주현석";
		System.out.printf("문자열 출력 %s\n", name);
		System.out.printf("문자열 자릿수 출력 [%5s] [%-5s]\n", name, name);
	}
	public static void main(String[] args) {

		UsePrintf up = new UsePrintf();
		up.useVariableArguments();
	}

}
