package day0207;

import day0205.Fly;
import day0205.Clark;

public class Anony {

	public void useFly(Fly fly) {
		System.out.println("양력: " + fly.lift());
		System.out.println("추진력: " + fly.thrust());
	}
	public static void main(String[] args) {
		
		Anony anony = new Anony();
		//인터페이스는 객체화될 수 없지만 구현 클래스의 객체 주소는 저장할 수 있다.
		Clark superman = new Clark();
		anony.useFly(superman);
		FlyImpl f = new FlyImpl();
		anony.useFly(f);
		
		//구현 클래스를 별도로 생성하지 않고, 이름이 없는 클래스를 생성하여 arguments로 입력할 수 있다.
		anony.useFly(new Fly() {
			@Override
			public String thrust() {
				return null;
			}
			@Override
			public String lift() {
				return null;
			}
		});
	}

}
