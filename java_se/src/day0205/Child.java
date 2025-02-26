package day0205;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 자식 클래스
 * extends 키워드로 부모클래스 선택.
 * 자식 클래스에서는 선택한 부모 클래스의 자원을 자신식의 객체명으로 사용할 수 있다. => 코드의 재사용성
 */
public class Child extends Parent {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		
		Child c = new Child();
		c.setName("자식클래스");
		c.setAge(25);
		
		System.out.println(c.getName() + "님의 나이는 " + c.getAge());
		
		String str =new String("집가기 한시간전");
		Date date = new Date();
		StringTokenizer stk = new StringTokenizer(str);
		
		System.out.println(c); //객체를 출력하면 heap의 주소가 출력된다.
		System.out.println(c.toString()); //객체를 출력하면 heap의 주소가 출력된다.
		System.out.println(str.toString());
		System.out.println(date);
		System.out.println(stk);
		
		c.toString();
	}
	
	@Override
	public String toString() {
		return "나는 주소가 싫어요!!";
	}

}
