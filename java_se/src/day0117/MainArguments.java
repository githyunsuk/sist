package day0117;

public class MainArguments {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[0]+args[1]);
		
		//wrapper class를 사용하여 문자열을 분석하여 정수로 변환하여 반환하는 일을 하는 method 사용
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		System.out.println(num1+num2);
		
	}
}
