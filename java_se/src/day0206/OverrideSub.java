package day0206;

/**
 * Override가 필요한 자식 클래스 
 */
public class OverrideSub extends OverrideSuper {

	int day, sub; //부모클래스의 변수명과 동일한 변수명
	@Override
	public void helloMsg() {
		System.out.println("오늘은 목요일");
	}
	
	public void useSuper() {
		System.out.println(this);
		//this가 숨어있다.
		age = 25; //부모와 자식간에 같은 이름의 변수가 없다면 부모의 변수를 사용
		System.out.println("부모의 변수:"+age);
		day = 6; //같은 이름의 변수 있다면 자식의 변수를 사용
		System.out.println("자식의 변수:"+day);
		super.day = 5;
		System.out.println("자식의 변수:"+day+"부모의 변수:"+super.age);
	}
	public static void main(String[] args) {

		OverrideSub os = new OverrideSub();
		os.helloMsg();
		
		//is a 관계의 객체화
		//Overriding: 자식의 method가 최우선적으로 호출됨
		OverrideSuper os2 = new OverrideSub();
		os2.helloMsg();
	
		System.out.println("----------------------------");
		os.useSuper();
	}

}
