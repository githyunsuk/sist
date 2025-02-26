package day0123;

/**
 *Polymorphism: 다형성 - 클래스 안에서는ㄴ 같은 이름의 method를 하나만 정의할 수 있다.
 */
public class Overload {
	
	public void printStar() {
		System.out.println("*");
	}
	
	public void printStar(int starCnt) {
		for(int i=0; i<starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Overload ol = new Overload();
		ol.printStar();
		ol.printStar(10);
		
	}

}
