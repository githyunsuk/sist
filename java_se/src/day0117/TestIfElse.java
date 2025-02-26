package day0117;

/**
 * if ~ else
 * 둘 중 하나의 코드를 실행해야할 때 사용하는 
 */
public class TestIfElse {
	
	public static void main(String[] args) {
		
		int num = 26;
		System.out.printf("%d은(는)",num);
		if (num % 2 == 0) System.out.println("짝수");
		else System.out.println("홀수");
		
		if (num >= 0) System.out.println("양수");
		else System.out.println("음수");
		
		String tp = args[0];
		if (tp.equals("버스") || tp.equals("지하철") || tp.equals("마을버스")) {
			System.out.printf("%s은(는) 대중교통 \n", tp);
		}
		else {
			System.out.printf("%s은(는) 대중교통이 아님. \n", tp);
		}
		
	}

}
