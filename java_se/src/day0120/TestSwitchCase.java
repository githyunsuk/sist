package day0120;

/**
 * switch~case 일치하는 정수를 찾을 때
 */
public class TestSwitchCase {
	
	public static final int GRADE_APLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	

	public static void main(String[] args) {
		
		int i = 1;
		switch (i) {
		case 0: System.out.println("영");
		case 1: System.out.println("일");
		case 2: System.out.println("이");
		case 3: System.out.println("삼");
		default:System.out.println("일치하지 않음");
		}

		System.out.println("-------------------------");
		int j = 0;
		switch (j) {
		case 0: System.out.println("영");
		case 1: System.out.println("일"); break;
		case 2: System.out.println("이"); break;
		case 3: System.out.println("삼");
		default:System.out.println("일치하지 않음");
		}
		
		System.out.println("-------------------------");
		//점수에 대한 학점 구하기
		char grade = 'F';
		int score = 80;
		
		if(0<=score && score <=100) {
			switch(score / 10) {
			case TestSwitchCase.GRADE_APLUS:
			case TestSwitchCase.GRADE_A: grade='A'; break;
			case TestSwitchCase.GRADE_B: grade='B'; break;
			case TestSwitchCase.GRADE_C: grade='C'; break;
			case TestSwitchCase.GRADE_D: grade='D'; break;
			default: grade='F'; break;
			}
			System.out.printf("%d 점수의 학점은 %c \n", score, grade);
		}
		else {
			System.out.printf("%d는 잘못된 점수 \n", score);
		}
		System.out.println("-------------------------");
		//break문 최소화(더 안좋은 코드)
		grade = 64;
		score = 100;
		
		if(0<=score && score <=100) {
			switch(score / 10) {
			case GRADE_D: grade++;
			case GRADE_C: grade++;
			case GRADE_B: grade++;
			case GRADE_A:
			case GRADE_APLUS: grade++; break;
			default: grade += 6;
			}
			System.out.printf("%d 점수의 학점은 %c \n", score, grade);
		}
		else {
			System.out.printf("%d는 잘못된 점수 \n", score);
		}
		
	}

}
