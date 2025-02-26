package day0116;

/**
 * 이 클래스는 이클립스를 사용하기 위한 클래스.
 */
public class Hello2 {
	
	/**
	 * 최고점수를 저장하기 위한 상수.
	 */
	public static final int max_value = 100;

	/**
	 * Java Application을 만들기 위한 main method.
	 * @param args 외부값
	 */
	public static void main(String[] args) {
		
		System.out.println("안녕하세요?");
		
		int i = 0;
		System.out.println(i);
		
		i = 100;
		System.out.println(i);
		
		int j = i >> 2;
		String str = "연습";
		
		i++;
		++i;
		System.out.println(i+" "+j+" "+str);
	}
}//class
