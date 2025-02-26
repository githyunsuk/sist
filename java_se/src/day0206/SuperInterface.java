package day0206;

/**
 * 구현클래스가 구현해야 하는 업무들의 목록만 제공.
 */
public interface SuperInterface {

//	int i; //인스턴스 변수 선언 불가능
//	public SuperInterface() { //생성자 가질 수 없다->객체 생성 불가
//		
//	}
//	public void test() {} // 일반 method도 불가 -> 직접 업무 구현x
	public static final int MAX = 10000;
	
	//interface는 abstract 접근지정자를 기술하지 않아도 추상메서드가 된다.
	public void methodA();
	public abstract String methodB();
	public void methodD();
	
}
