package day0121;

/**
 * package 접근 지정자를 가진 클래스 (외부 패키지에서 접근 가능)
 */
class ModifierB {

	public int a;
	protected int b;
	int c;
	private int d;
	
	public static void main(String[] args) {
		ModifierB ma = new ModifierB();
		System.out.println("public 접근 지정자 " + ma.a);
		System.out.println("protected 접근 지정자 " + ma.b);
		System.out.println("default 접근 지정자 " + ma.c);
		System.out.println("private 접근 지정자 " + ma.d);
		
	}
}
