package day0120;

/**
 * for: 시작과 끝을 알 때 사용한는 반복문 for (초기값; 조건식; 증,감소식)
 */
public class TestFor {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println("안녕하세요?" + i);
		}

		System.out.println("------------------");
		// 1에서부터 100까지 1씩 증가하는 값을 콘솔에 옆으로
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		}

		System.out.println("\n------------------");
		// 1에서부터 100까지의 수중에 짝수만 콘솔에 옆으로
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println("\n------------------");
		// 1에서부터 100까지의 수중에 홀수만 콘솔에 옆으로
		for (int i = 1; i <= 100; i+=2 ) {
			//if (i % 2 == 1)
				System.out.print(i + " ");
		}

		System.out.println("\n------------------");
		//대문자 모두 출력 //'A' = 65 , 'a' = 97
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n------------------");
		//대문자 소문자 모두 출력 //'A' = 65 , 'a' = 97
		for(char i='A'; i<='Z'; i++) {
			System.out.printf("%c(%c) ",i ,i+32);
		}
		
		System.out.println("\n------------------");
		//1에서 100까지의 합 출력
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("------------------");
		for(int i=1; i<=9; i++) {
			System.out.printf("2 x %d = %d \n",i , 2*i);
		}
		
		System.out.println("------------------");
		for(char i='Z'; i>='A'; i--) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n------------------");
		for(int i=0; i<26; i++) {
			System.out.printf("%c(%c) ", (char)(65+i), (char)(122-i));
		}
		System.out.println();
		char upper = 65, lower = 122;
		for(int i=0; i<26; i++) {
			System.out.printf("%c(%c) ", upper++, lower--);
		}
		System.out.println("\n------------------");
		int multiplicationTable = Integer.parseInt(args[0]);
		if (multiplicationTable > 1 && multiplicationTable < 10) {
			for(int i=1; i<10; i++) {
				System.out.printf("%d x %d = %d \n", multiplicationTable, i, multiplicationTable*i);
			}
		}
		else {
			System.out.println("구구단은 2~9단 까지 입니다.");
		}
		
	}
	

}
