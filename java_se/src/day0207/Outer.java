package day0207;

/**
 * 안쪽 클래스를 인스턴스 변수처럼 사용할 때. 
 */
public class Outer {

	int outI;
	
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}
	
	public void outMethod() {
//		inI = 10; 안쪽 클래스의 자원은 직접 사용 불가
		//바깥 클래스에서 안쪽 클래스의 자원을 사용하려면 안쪽 클래스를 객체화 하여 사용
		Inner in = this.new Inner();
		in.intI = 10;
		in.inMethod();
	}
	
	//////////////inner class 시작/////////////////////////
	public class Inner {
		int intI;
		
		public Inner() {
			System.out.println("Inner class 생성자");
		}
		
		public void inMethod() {
			System.out.println("안쪽클래스의 method");
			System.out.println("바깥 클래스의 변수 " + outI                                                                                                                                                                                                                                                                                                                    );
		}
	}
	//////////////inner class 끝/////////////////////////
	
	public static void main(String[] args) {
		//1.외부 클래스 객체화
		Outer out = new Outer();
		//2.외부 클래스의 객체를 사용하여 내부 클래스의 객체 생성
//		Outer.Inner in = out.new Inner();       
//		in.inMethod();
		out.outMethod();
		
	}
}
