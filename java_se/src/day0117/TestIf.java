package day0117;

/**
 * 단일 if 사용 
 */
public class TestIf {

	public static void main(String[] args) {

		int tempNum = -17;
		int abs = tempNum;
		
		if (tempNum < 0) {
			abs = -tempNum;
		}
		
		System.out.printf("%d의 절댓값 %d \n", tempNum, abs);
	}

}
