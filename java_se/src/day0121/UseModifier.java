package day0121;

/**
 * 같은 패키지에서 다양한 접근지정자를 가진 클래스의 변수를 사용. 
 */
public class UseModifier {

	public static void main(String[] args) {
		ModifierA ma = new ModifierA();
		ModifierB mb = new ModifierB();
		
		System.out.println("ma public " + ma.a);
		System.out.println("mb public " + mb.a);
		
		System.out.println("ma protected " + ma.b);
		System.out.println("mb protected " + mb.b);
		
		System.out.println("ma default " + ma.c);
		System.out.println("mb default " + mb.c);
		
		//private은 외부에서 사용할 수 없다
		
	}

}
