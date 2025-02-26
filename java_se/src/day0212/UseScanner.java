package day0212;

import java.util.Scanner;

public class UseScanner {
	
	public UseScanner() {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("아무 문자열이나 입력하고 엔터");
//		String temp = scanner.next();
		//next() 이벤트가 발생하기 전까지 멈춰있다가, 이벤트가 발생하면 계속 동작을 이너나는 일.
		//코드의 실행을 멈추는 blocking method
		String temp = scanner.nextLine();
		System.out.println("입력 값:" + temp);
		
		System.out.println("나이 입력");
		int age = scanner.nextInt();
		System.out.println("당신의 나이" + age);
		
		System.out.println("태어난 해 입력");
		int birth = scanner.nextInt();
		System.out.println("태어난 해" + birth);
		
		scanner.nextLine();
		
		System.out.println("거주지 입력");
		String add = scanner.nextLine();
		System.out.println("주소" + add);
	}

	public static void main(String[] args) {

		new UseScanner();
	}

}
