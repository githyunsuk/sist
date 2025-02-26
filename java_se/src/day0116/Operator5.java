package day0116;

/**
 * 논리 연산자
 * 일반논리: 여러개의 관계연산자를 붙여서 비교해야할 때 사용 - &&(둘 다 참일 떄) / ||(하나라도 참일 때)
 * 
 * 비트논리
 */
public class Operator5 {

	public static void main(String[] args) {
		
		int i = 1, j = 16, k = 1, l = 16;
		System.out.printf("%d < %d && %d < %d = %b \n", i, j, k, l, (i<j && k<l));
		
		boolean flag = true, flag2 = false, flag3 = true, flag4 = false;
		System.out.println("일반논리연산자");
		System.out.printf("%b && %b = %b \n", flag, flag3, flag&&flag3);
		System.out.printf("%b && %b = %b \n", flag, flag2, flag&&flag2);
		System.out.printf("%b && %b = %b \n", flag2, flag, flag2&&flag);
		System.out.printf("%b && %b = %b \n", flag2, flag4, flag2&&flag4);

		System.out.printf("%b || %b = %b \n", flag, flag3, flag||flag3);
		System.out.printf("%b || %b = %b \n", flag, flag2, flag||flag2);
		System.out.printf("%b || %b = %b \n", flag2, flag, flag2||flag);
		System.out.printf("%b || %b = %b \n", flag2, flag4, flag2||flag4);
		
		//후항을 연산하지 않는 예제 코드
		flag = false; flag2 = false; flag3 = false;
		flag3 = (flag = 3 > 4) && (flag2 = 5 < 6);
		
		System.out.println("------------비트 논리 연산자-----------");
		i = 25; j = 15; // 0001 1001 & 0000 1111 -> 0000 1001(9)
 		System.out.printf("%d & %d = %d \n", i, j, i&j);
 		
 		i = 33; j = 17; // 0010 0001 | 0001 0001 -> 0011 0001(49)
 		System.out.printf("%d | %d = %d \n", i, j, i|j);
 		
 		i = 7; j = 17; // 0000 0111 ^ 0001 0001 -> 0001 0110(22)
 		System.out.printf("%d & %d = %d \n", i, j, i^j);
 		
 		
 		
	}
}
