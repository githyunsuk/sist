package day0122;

/**
 * method의 4가지 형태 
 */
public class MethodType {

	/**
	 * 고정일 - 항상 같은 일을 수행한다
	 * 반환 값 없고, 매개변수 없는 형
	 */
	public void typeA() {
		System.out.println("고정일");
	}
	
	/**
	 * 가변 일
	 * @param param
	 */
	public void typeB(int param) {
		System.out.println("가변일:" + param);
	}
	
	/**
	 * 고정 값 - 항상 같은 값을 반환한다.
	 * @return
	 */
	public int typeC() {
		int year = 2025;
		return year;
	}
	
	/**
	 * 가변 값 - 반환형 있고, 매개변수 있는 형.
	 * @param d 실수의 입력된 값
	 * @return 정수로 변환 된 값
	 */
	public int typeD(double d) {
		return (int)d;
	}
	public static void main(String[] args) {
		
		MethodType mt = new MethodType();
		System.out.println("---------------------");
		mt.typeA();
		
		System.out.println("---------------------");
		mt.typeB(22);
		mt.typeB(23);

		System.out.println("---------------------");
		mt.typeC();
		//반환형이 있는 method는 값이므로 사용해야한다(출력, 연산, 재할당)
		System.out.println(mt.typeC());
		System.out.println(mt.typeC()+1);
		
		System.out.println("---------------------");
		mt.typeD(2025.1);
		System.out.println("출력:" + mt.typeD(1.22));
		System.out.println("연산:" + (mt.typeD(2025.01)+1));
		int i = mt.typeD(3.16);
		System.out.println("재할당:" + i);
	}

}
