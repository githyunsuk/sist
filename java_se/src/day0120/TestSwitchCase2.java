package day0120;

/**
 * switch~case: 일치하는 정수를 비교하는 일 + constant
 */
public class TestSwitchCase2 {

	public static void main(String[] args) {

		int birth = Integer.parseInt(args[0]);
		int zodiacFlag = birth % 12;
		int age = 2025 - birth + 1;
		String result = " ";
		switch (zodiacFlag) {
		case ZodiacStr.MONKEY:
			result = "원숭이";
			break;
		case ZodiacStr.CHICKEN:
			result = "닭";
			break;
		case ZodiacStr.DOG:
			result = "개";
			break;
		case ZodiacStr.PIG:
			result = "돼지";
			break;
		case ZodiacStr.MOUSE:
			result = "쥐";
			break;
		case ZodiacStr.COW:
			result = "소";
			break;
		case ZodiacStr.TIGER:
			result = "호랑이";
			break;
		case ZodiacStr.RABBIT:
			result = "토끼";
			break;
		case ZodiacStr.DRAGON:
			result = "용";
			break;
		case ZodiacStr.SNAKE:
			result = "뱀";
			break;
		case ZodiacStr.HORSE:
			result = "말";
			break;
		case ZodiacStr.SHEEP:
			result = "양";
			break;
		}
		System.out.printf("태어난 해는 %d, 나이는 %d, %s띠 \n", birth, age, result);
	}
}
