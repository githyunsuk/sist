package day0213;

public class Test {

	public void method() {
		System.out.println("method 호출");
		method();
	}
	
	public static void main(String[] args) {

		Test t = new Test();
		t.method();
	}

}
