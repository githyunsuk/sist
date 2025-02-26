package day0120;

/**
 * 다중 for: 바깥 for가 한 번 돌 때, 안쪽 for는 몇 번 반복하는가?
 *  
 */
public class TestFor2 {

	public static void main(String[] args) {
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("i = %d, j = %d \n", i, j);
			}
			System.out.println("--------------------");
		}
		
		for(int i=2; i<10; i++) {
			System.out.println(i+"단 시작");
			for(int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d \n", i, j, i*j);
			}
			System.out.println(i+"단 끝");
		}
		
		System.out.println("---------------");
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=i; j++) {
				System.out.printf("%d %d ", i, j);
			}
			System.out.println();
		}
		
		System.out.println("---------------");
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<5; j++) {
				System.out.printf("%d %d ", i, j);
			}
			System.out.println();
		}
	}

}
