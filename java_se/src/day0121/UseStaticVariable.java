package day0121;

/**
 * static 변수의 사용.
 */
public class UseStaticVariable {
	
	// 1.선언) : 접근지정자 static 데이터형 변수명;
	public static int i;
	
	//기본 값으로 자동 초기화가 된다.
	public static int a; //정수형의 default value: 0
	public static char c; //문자형의 default value: '\u0000'
	public static double d; //실수형의 default value: 0.0
	public static boolean b; //불린형의 default value: false
	public static UseStaticVariable usv; //참조형 class default value:null
	public static String str; //참조형 String default value : null
	public static int[] arr; //참조형 array default value: null
	
	public static void main(String[] args) {
		//2. 값할당) 클래스명.변수명 = 값; 변수명 = 값;
		UseStaticVariable.i = 21;
		i = 20;
		
		//3. 사용) 클래스명.변수명, 변수명
		System.out.println(UseStaticVariable.i);
		//System.out.println(i);
		
		//객체화: static 변수를 가진 클래스로 객체를 몇개를 생성하든 static 변수는 하나만 생성된다.
		//UseStaticVariable usv = new UseStaticVariable();
		//UseStaticVariable usv2 = new UseStaticVariable();
		//System.out.println(usv.i); //static 변수는 특정객체에 속해있지 않으므로
		//객체명.변수명의 형태로 접근은 할 수 있으나 올바른 문법은 아니다.
		//usv.i = 100;
		//System.out.println(usv2.i);
		
		//static variable, instance variable의 default value 출력
		System.out.println("정수형:" + UseStaticVariable.a);
		System.out.println("문자형:" + UseStaticVariable.c);
		System.out.println("실수형:" + UseStaticVariable.d);
		System.out.println("불린형:" + UseStaticVariable.b);
		System.out.println("참조형 class:" + UseStaticVariable.usv);
		System.out.println("참조형 String:" + UseStaticVariable.str);
		System.out.println("참조형 array:" + UseStaticVariable.arr);
	}

}
