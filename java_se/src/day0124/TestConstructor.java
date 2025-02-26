package day0124;

/**
 * 생성자의 사용 
 */
public class TestConstructor {

	public TestConstructor() {
		System.out.println("default constructor!!!");
	}
	
	public TestConstructor(int i) {
		System.out.println("오버로드된 매개변수 있는 생성자!!!");
		test(); //method 직접 호출
	}
	
	public void test() {
		System.out.println("test method!!!");
	}
	public static void main(String[] args) {
		
		new TestConstructor();
		new TestConstructor(1);
	}

}
