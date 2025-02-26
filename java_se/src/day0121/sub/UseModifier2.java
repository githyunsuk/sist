package day0121.sub;

import day0121.ModifierA;

/**
 * 다른 패키지에 존재하는 클래스를 사용하는 클래스 
 */
public class UseModifier2 {

	public static void main(String[] args) {
		ModifierA ma = new ModifierA(); //public 접근지정자를 가진 클래스
		//MOdifierB - package 접근 지정자는 같은 패키지 안에서만 접근 가능
		
		System.out.println("public " + ma.a);
		//protected, default, private 접근 불가
	}

}
