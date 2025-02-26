package day0113;
class ConsolePrint
{
	public static void main(String[] args) 
	{
		/*
		System.out.println("안녕 자바");
		System.out.println("오늘은 월요일 입니다.");
		
		System.out.print("안녕 자바");
		System.out.print("오늘은 월요일 입니다.");
		*/
		//상수 출력
		System.out.println(2025); //정수상수
		System.out.println(1.13); //실수상수
		System.out.println('A'); //문자상수
		System.out.println(true); //불린상수
		System.out.println("안녕하세요?"); //문자열상수
		
		//변수 출력
		int i = 13;
		System.out.println(i);
		ConsolePrint cp = new ConsolePrint();
		System.out.println(cp);
		
		//연산식: 연산된 결과만 출력
		System.out.println(1+13);
		//문자열에 +는 붙임
		System.out.println("1+13=" + (1+13));
		System.out.println("정수상수: " + 2025);
		System.out.println("변수: " + i);
		System.out.println("참조형 데이터형: " + cp);
		System.out.println();
		//System.out.print(); API에서 제공하지 않는 method는 사용할 수 없다.
	}
}
