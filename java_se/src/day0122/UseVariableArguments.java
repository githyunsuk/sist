package day0122;

/**
 *jdk1.5에서 부터 지원되는 Variable Arguments의 사용.
 *매개변수는 하나이지만 인수(입력값)을 여러개 넣을 수 있는 기능. 
 */
public class UseVariableArguments {
	
	/**
	 * V.A의 사용
	 * @param va
	 */
	public void vaMethod(int...va) {
		//V.A는 배열로 처리된다.
		//System.out.println(va);
		for(int i=0; i<va.length; i++) {
			System.out.println(va[i]);
		}
	}
	//V.A는 단일형의 parameter와 함께 정의하면 가장 마지막에 정의한다.
	public void va2(int i, int...j) {
		
	}
	public void va3(int i, char c, int...j) {
		
	}
	//public void va4(int...j, int i) {} - V.A는 가장 마지막에 정의해야한다.

	public static void main(String[] args) {
		//객체화)
		UseVariableArguments uva = new UseVariableArguments();
		uva.vaMethod();
		uva.vaMethod(1);
		uva.vaMethod(1,2,3,4,5,6);
		
	}

}
