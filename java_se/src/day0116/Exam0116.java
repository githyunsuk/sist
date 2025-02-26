package day0116;

public class Exam0116 {
	
	public static void main(String[] args) {
		
		//#1
		int a = 10, b = 20;
		System.out.println("큰 값은:" + (a>b?a:b));
		
		//#2
		int i = 3, j = 5, k = 7;
		System.out.println("작은 값은:" + ((i<j?i:j)<k?(i<j?i:j):k));
		
		//#3
		int temp = 10, temp2 = 20;
		System.out.println(++temp + temp2--); //++temp는 전위연산자라 값을 올리고 출력하며, temp2--는 후위 연산자라 출력하고 감소한다. 즉 11 + 20 = 31
		System.out.println("temp:" + temp +",temp2:" + +temp2); //temp는 이미 증가했으므로 11, temp2는 위 출력 후 감소하므로 19이다
		
		//#4 
		int maxValue = Integer.MAX_VALUE; //0111 1111 1111 1111 1111 1111 1111 1111
		int num = 65535; // 0000 0000 0000 0000 1111 1111 1111 1111
		System.out.println(maxValue & num); //& 연산자 사용
		System.out.println(maxValue & Character.MAX_VALUE);
		System.out.println(maxValue & 0xFFFF);
		System.out.println(maxValue>>15); //쉬프트 연산자 사용
		
	}

}
