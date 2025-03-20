package day0320;

/**
 * 업무를 실행하기 위해서 제공하는 클래스 
 */
public class RunWork {

	public static void main(String[] args) {

		Work w = new Work();
		System.out.println(w.randomNumber());
		
		String msg = "오늘은 목요일 입니다.";
		try {
			System.out.println(w.sub(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
