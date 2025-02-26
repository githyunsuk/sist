package day0122;

/**
 * instance method 사용.
 * instance variable, static variable, local variable을 사용하여 업무를 처리할 때 정의 
 */
public class UseInstanceMethod {
	
	int dayOfMonth; //instance variable
	
	/**
	 * 인스턴스 변수를 사용하여 콘솔에 일자를 출력하는 일.
	 */
	public void printDay() {
		System.out.println(dayOfMonth + "일");
	}

	public static void main(String[] args) {
		//printDay(); static 영역에서는 instance 영역의 지원 직접 사용 불가
		
		//2.객체화)
		UseInstanceMethod uim = new UseInstanceMethod();
		//3.호출)
		uim.printDay();
		uim.dayOfMonth = 22;
		uim.printDay();
		
		uim.dayOfMonth++;
		uim.dayOfMonth++;
		uim.printDay();
		
		//인스턴스 변수는 객체마다 같은 이름의 변수가 생성
		UseInstanceMethod uim2 = new UseInstanceMethod();
		uim2.dayOfMonth = 31;
		uim2.printDay();

	}

}
