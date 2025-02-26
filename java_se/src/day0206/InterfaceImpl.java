package day0206;

public class InterfaceImpl implements SuperInterface {


	@Override
	public void methodA() {
		System.out.println("구현클래스에서 오버라이딩");
	}

	@Override
	public String methodB() {
		return "눈 오는 목요일";
	}
	
	@Override
	public void methodD() {
		System.out.println("클래스의 일반 method");
	}
	public static void main(String[] args) {
		//인터페이스는 직접 객체화 할 수 없다.
//		SuperInterface si = new SuperInterface();
		System.out.println(SuperInterface.MAX);
		
		//구현클래스를 생성하여 heap의 주소는 저장할 수 있다.
		SuperInterface si = new InterfaceImpl();
		//객체명으로 호출할 수 있는 것은 1.상수, 2.Override 한 method, 3.default method
		si.methodA();
		System.out.println(si.methodB());
		si.methodD();
		
	}

}
