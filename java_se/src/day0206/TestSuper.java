package day0206;

/**
 * 부모클래스
 */
public class TestSuper {
	
	int i;
	int j;
	
	public TestSuper() {
		this(100);
		i = 2;
		System.out.println("부모 기본 생성자");
	}
	 
	
	public TestSuper(int i) {
		this.i = i;
		System.out.println("부모 매개 생성자:" + i);
	}
}
