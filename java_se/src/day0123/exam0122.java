package day0123;

/**
 * 1월 22일 instance method 연습 
 */
public class exam0122 {
	
	/**
	 * 1. 자신의 이름을 콘솔에 출력 - 고정 일
	 */
	public void printName() {
		System.out.println("주현석");
	}
	
	/**
	 * 2. 자신의 성을 반환 - 고정 값
	 * 반환 형이 존재하는 method는 반환형과 일치하는 데이터 형으로 변수를 선언하고,
	 * 일처리한 결과를 받아서 사용한다.
	 * @return 성
	 */
	public char getFamilyName() {
		return '주';
	}
	
	/**
	 * 3.점수를 입력 받아서 점수의 판정을 콘솔에 출력 - 가변 일
	 * @param score
	 */
	public void printScoreEvaluation(int score) {
		System.out.println("입력된 " + score + "점은");
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
		}else if (score >= 60){
			System.out.println("합격");
		}else if (score >= 40){
			System.out.println("다른과목참조");
		}else {
			System.out.println("과락");
		}
	}
	
	/**
	 * 4.문자를 입력 받아서 대문자/소문자/숫자 판별
	 * @param c
	 */
	public void printClassifyChar(char c) {
		if(Character.isDigit(c)) {
			System.out.println("숫자");
		}
		if(Character.isUpperCase(c)) {
			System.out.println("대문자");
		}
		if(Character.isLowerCase(c)) {
			System.out.println("소문자");
		}
	}
	
	/**
	 * 5.태어난 해를 입력 받아서 나이를 반환
	 * @param birth 태어난 해
	 * @return 태어난 해를 사용하여 연산한 나이
	 */
	public int getAge(int birth) {
		int age = 2025 - birth + 1;
		return age;
	}
	
	/**
	 * 6.정수 숫자 3개를 입력 받아서 가장 작은 수를 반환
	 * @param num 
	 * @param num2
	 * @param num3
	 * @return 가장 작은 수
	 */
	public int findSmallestNum(int num, int num2, int num3) {
		return Math.min(Math.min(num,num2),num3);
	}

	public static void main(String[] args) {
		//static 영역에서 instance 영역의 자원을 사용하기 위해 객체화
		exam0122 exam = new exam0122();
		
		System.out.println("고정 일 호출");
		exam.printName();
		
		System.out.println("고정 값 호출");
		char familyName = exam.getFamilyName();
		System.out.println(familyName);
		
		System.out.println("가변 일 호출");
		int score = 80;
		exam.printScoreEvaluation(score);
		exam.printClassifyChar('A');
		
		System.out.println("가변 값 호출");
		System.out.println(exam.getAge(1995));
		
		System.out.printf("%d, %d, %d 중 가장 작은 수는 %d",1,2,3,exam.findSmallestNum(1, 2, 3));
	}//main

}//class
