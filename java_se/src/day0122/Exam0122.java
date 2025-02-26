package day0122;

public class Exam0122 {

	//1. 자신의 이름을 콘솔에 출력
	public void printName() {
		System.out.println("주현석");
	}
	//2. 자신의 이름 중 성을 반환
	public char returnFirstName(String name) {
		return name.charAt(0);
	}
	//3. 점수를 입력 받아 점수의 판정을 콘솔에 출력
	public void result(int score) {
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
	//4. 문자를 입력 받아 대소문자,숫자 구분하여 출력
	public void isAlpha(char c) {
		if(Character.isUpperCase(c)) {
			System.out.printf("\"%c-대문자\" \n",c);
		}else if(Character.isLowerCase(c)){
			System.out.printf("\"%c-소문자\" \n",c);
		}else {
			System.out.printf("\"%c-숫자\" \n",c);
		}
	}
	//5. 태어난 해 입력 받아 나이 반환
	public int returnAge(int birth) {
		return 2025 - birth + 1;
	}
	//6. 숫자 3개 입력 받아 가장 작은 수 반환
	public int returnMinNum(int a, int b, int c) {
		return Math.min(Math.min(a,b),c);
	}
			

	public static void main(String[] args) {

		//객체화
		Exam0122 e = new Exam0122();
		//1.
		e.printName();
		System.out.println("-------------------------");
		//2.
		System.out.println(e.returnFirstName("주현석"));
		System.out.println("-------------------------");
		//3.
		e.result(40);
		System.out.println("-------------------------");
		//4.
		e.isAlpha('a');
		System.out.println("-------------------------");
		//5.
		System.out.println(e.returnAge(1999));
		System.out.println("-------------------------");
		//6.
		System.out.println(e.returnMinNum(1, 10, 100));
		
	}
	
	

}
