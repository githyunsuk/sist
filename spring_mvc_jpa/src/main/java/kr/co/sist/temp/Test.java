package kr.co.sist.temp;

import java.util.Objects;

public class Test {

	private String name;
	private Integer age;
	
	@Override
	public int hashCode() {
		//값을 가지고 hashCode 생성 : 객체가 달라도 값이 같으면 같은 code가 생성.
		return Objects.hash(name, age);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.name = "이장훈";
		t.age = 25;
		
		Test t2 = new Test();
		t2.name = "장훈이";
		t2.age = 25;
		
		System.out.println(t.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t.getClass());
	}
}
