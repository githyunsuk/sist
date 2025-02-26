package day0121;

/**
 * while: 시작과 끝일 모를 때 사용하는 반복문
 * 최소 0번 수행, 최대 조건까지 수행
 */
public class TestWhile {

	public static void main(String[] args) {

		int i = 0;
		while(i < 10) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("-------------------------");
		int sum = 0;
		i = 1;
		while(i<101) {
			if(i % 3 == 0) sum += i;
			i++;
		}
		System.out.println(sum);
		
		while(true) {
			System.out.println("무한루프");
			break;
		}
	}

}
