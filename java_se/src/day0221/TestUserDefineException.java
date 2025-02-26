package day0221;

import java.util.Random;

public class TestUserDefineException {

	/**
	 * 사용자 정의 예외 발생
	 * @return 메시지
	 * @throws TabaccoException 담배에 대한 예외
	 */
	public String taeil() throws TabaccoException {
		String msg = "";
		String[] grade = {"대학생", "고등학생", "중학생", "초등학생"};
		
		int random = new Random().nextInt(grade.length);
		String selectGrade = grade[random];
		if (random == 3) {
			throw new TabaccoException(selectGrade + "이 감히 담배를?");
//			throw new TabaccoException();
		}
		
		msg = selectGrade + "이 흡연중";
		return msg;
	}

	public void useTaeil() {

		try {
			System.out.println(taeil());
		} catch (TabaccoException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		TestUserDefineException tude = new TestUserDefineException();
		tude.useTaeil();
	}

}
