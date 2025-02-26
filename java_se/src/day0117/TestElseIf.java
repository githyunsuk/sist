package day0117;

/**
 * 다중 if: 연관된 여러 조건을 비교할 때 사용
 */
public class TestElseIf {

	public static void main(String[] args) {
		// 점수판별
		// 점수는 0보다 작을 수 없고, 100보다 클 수 없다.
		// 0보다 작은 경우 작아서 실패 출력, 100보다 크면 커서 실패
		// 아니면 정상범위 점수
		int score = 10;
		if (score < 0)
			System.out.println("0보다 작아서 실패");
		else if (score > 100)
			System.out.println("100보다 커서 실패");
		else
			System.out.println("정상범위");

		int age = Integer.parseInt(args[0]);
		if (age >= 1 && age < 10)
			System.out.println("어린이");
		else if (age >= 10 && age < 20)
			System.out.println("10대");
		else if (age >= 20 && age <= 100)
			System.out.println("어른");
		else
			System.out.println("일반적인 나이가 아님");

		int birth = Integer.parseInt(args[1]);
		int tempNum = birth % 12;
		String result = "없음";
		if (tempNum == 0)
			result = "원숭이";
		else if (tempNum == 1)
			result = "닭";
		else if (tempNum == 2)
			result = "개";
		else if (tempNum == 3)
			result = "돼지";
		else if (tempNum == 4)
			result = "쥐";
		else if (tempNum == 5)
			result = "소";
		else if (tempNum == 6)
			result = "호랑이";
		else if (tempNum == 7)
			result = "토끼";
		else if (tempNum == 8)
			result = "용";
		else if (tempNum == 9)
			result = "뱀";
		else if (tempNum == 10)
			result = "말";
		else
			result = "양";
		System.out.printf("태어난 해:%d, %s띠 \n", birth, result);

	}

}
