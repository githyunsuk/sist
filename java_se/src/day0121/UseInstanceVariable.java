package day0121;

/**
 * instance(member) variable 사용.
 * -객체마다 생성되고 사용되는 변수.
 * 객체화 후 객체명.변수명으로 사용.
 * 객체마다 같은 이름의 변수가 생성된다. 
 */
public class UseInstanceVariable {
	//1.변수의 선언
	public int i;
	
	public void temp() {
		i = 100;
	}
	public static void main(String[] args) {
		//2. static 영역에서 instance 변수를 사용하기 위해 객체화가 선행되어야 한다.
		//객체화의 문법: 클래스명 객체명 = new 클래스명();
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv2 = new UseInstanceVariable();
		//3. 값 할당
		uiv.i = 10; //객체(uiv)마다 같은 이름의 변수(i)가 존재
		uiv2.i = 21; //객체(uiv2)마다 같은 이름의 변수(i)가 존재
		
		//4. 값 사용) 객체명.변수명
		System.out.println("uiv의 i " + uiv.i);
		System.out.println("uiv2의 i " + uiv2.i);
		
		for(int i=0; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println(i);
		}
	}

}
