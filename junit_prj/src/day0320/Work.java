package day0320;

import java.util.Random;

/**
 * 업무를 제공하는 클래스
 */
public class Work {

	public int randomNumber() {
		int num = 0;

		// 0~10까지 10개의 난수를 발생
		num = new Random().nextInt(11);
		return num;
	}// randomNumber

	public String sub(String msg) throws Exception {
		String str = null;
		try {
			str = msg.substring(0, 10);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("문자열을 자를 수 없습니다.");
		}
		
		return str;
	}
}
