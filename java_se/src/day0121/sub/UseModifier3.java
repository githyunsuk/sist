package day0121.sub;

import day0121.ModifierA;

/**
 * 다른 패키지에 존재하는 클래스를 상속 받은 자식 클래스
 * 자식 클래스에서는 부모 클래스의 자원(변수, method)을 자신이 가지고 있는 것 처럼 사용  
 */
public class UseModifier3 extends ModifierA{

	public static void main(String[] args) {

		//상속관계에서는 자식 클래스를 생성하여 부모클래스의 변수나 method 사용한다
		UseModifier3 um3 = new UseModifier3();
		System.out.println("public: " + um3.a); //부모의 public 사용가능
		System.out.println("protected: " + um3.b); //부모의 protected 사용 가능
		//부모의 default, private 사용 불가
	}

}
