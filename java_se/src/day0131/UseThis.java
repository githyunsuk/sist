package day0131;

/**
 * this의 method 형식
 * this(); 기본 생성자 호출
 * this(값,,,); 매개변수 있는 생성자를 호출
 * 
 *  생성자 안에서 객체 생성 없이 다른 생성자를 호출할 때 사용
 *  생성자의 첫번째 줄에서만 기술가능
 */
public class UseThis {
	
	int i; //instance variable: 객체가 생성되면 자동 초기화
	
	/**
	 * default constructor 
	 */
	public UseThis() {
//		this.i = 2025;
		this(2025);
		System.out.println("기본생성자");
	}
	
	/**
	 * 매개변수 있는 생성자
	 * @param i
	 */
	public UseThis(int i) {
		this.i = i;
		System.out.println("매개변수 받는 생성자");
	}

	public static void main(String[] args) {

		UseThis ut = new UseThis();
		System.out.printf("ut주소:%s, i:%d\n",ut,ut.i);
	}

}
