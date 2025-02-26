package day0206;

/**
 * Override를 연습용 부모 클래스 
 */
public class OverrideSuper {

	int age, day;
	
	public void helloMsg() {
		System.out.println("오늘은 수요일");
	}
	
	/**
	 * 제공되는 기능을 그대로만 사용해야 할 때 -> 오버라이드 금지
	 */
	public final void helloMsg2() {
		System.out.println("안녕하세요?");
	}
}
