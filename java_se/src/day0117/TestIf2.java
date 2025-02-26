package day0117;

/**
 * 단일 if 연습
 */
public class TestIf2 {
	
	public static void main(String[] args) {
		
		int num = 0;
		num = Integer.parseInt(args[0]);
		
		System.out.printf("%d은(는)", num);
		
		if (num % 2 == 0) {
			System.out.println(" 짝수");
		}
		
		if (num % 2 == 1) {
			System.out.println(" 홀수");
		}
	}
}
