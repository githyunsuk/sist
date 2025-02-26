package day0121;

public class TestFor3 {

	public static void main(String[] args) {

		for (int i = 0, j = 10, k = 100; i < 10; i++, j--, k += 3) {
			System.out.printf("%d %d %d \n", i, j, k);
		}

		for (int i = 0;; i++) {
			System.out.println("무한 루프:" + i);
			if (i == 50) {
				break;
			}
		}
		System.out.println("안녕");
		for(;;) {
			System.out.println("무한루프");
			break;
		}
		
		for(int i=1; i<101; i++) {
			if(i % 2 == 0) continue;
			System.out.print(i + " ");
		}
		
	}

}
