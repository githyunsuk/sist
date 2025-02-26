package day0206;

public class TestSub extends TestSuper {

	int i;

	public TestSub() {
		super();
		System.out.println("자식의 기본 생성자");
	}
	
	public TestSub(int i) {
		this(); 
		this.i = i;
		System.out.println("자식의 매개 생성자:" + i);
	} 
}
