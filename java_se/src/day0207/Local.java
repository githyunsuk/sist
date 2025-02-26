package day0207;

/**
 * 안쪽 클래스를 지역 변수처럼 사용할 때 
 */
public class Local {
	
	int outI;
	
	public Local() {
		System.out.println("바깥 클래스의 생성자");
	}
	
	public void methodA(int paramA, int paramB) {
		
		//int localA = 0;
		//int localb = 0;
		
		///////////지역 클래스 시작////////////
		class Inner{
			int i;
			public Inner() {
				System.out.println("Local 클래스 생성자");
			}
			public void method() {
				System.out.println("method호출 " + i);
				System.out.println(outI); //외부 클래스의 instance 변수는 사용가능
			}
		}
		///////////지역 클래스 끝////////////
		Inner in = new Inner();
		in.i = 20;
		in.method();
	}
	

	public static void main(String[] args) {

		Local lo = new Local();
		lo.methodA(2,7);
	}

}
