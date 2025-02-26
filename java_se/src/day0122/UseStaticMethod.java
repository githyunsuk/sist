package day0122;

/**
 * static method: 객체화 하지 않고 클래스명으로 직접 호출할 수 있는 method.
 * 객체가 가지고 있는 값을 사용하지 않고, parameter로 입력되는 값이나 static 변수에
 * 입력된 값으로 업무를 구현해야할 때 사용함 
 */
public class UseStaticMethod {

	public static int dayOfMonth = 22, a = 5, b = 10;
	
	/**
	 * 콘솔에 메시지를 출력하는 일.
	 * 1.method 선언)
	 */
	public static void printMessage() {
		System.out.println("안녕하세요? 오늘은 " + dayOfMonth + "일 입니다.");
	}
	
	public static void printSum(int a, int b) {
		System.out.println(a+b);
	}
	public static void main(String[] args) {
		//2.호출)
		printMessage();
		UseStaticMethod.printMessage();
		int i = Integer.parseInt(args[0]), j = Integer.parseInt(args[1]);
		printSum(a, b);
		printSum(i, j);
	}

}
