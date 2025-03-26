package day0324;

/**
 * Singleton이 도입된 클래스 
 */
public class Singleton {
	private static Singleton s;
	
	//1.클래스 외부에서 직접 객체화 할 수 없도록 생성자를 private으로 설정
	private Singleton() {
		System.out.println("객체생성");
	}
	
	//2.객체명 없이 객체를 얻어가는 일을 하는 method
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

}
