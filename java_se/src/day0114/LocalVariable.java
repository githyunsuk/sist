/**
지역변수를 사용하기 위한 클래스.
*/
package day0114;
class LocalVariable
{
	int dayOfMonth; //instance(member) variable: class field 영역
	/**
	 JAVA Application을 생성하기 위한 method. (main method)
	 */
	public static void main(String[] args)
	{
		//1.선언) 데이터형 변수명; 초기화 값이 들어가지 않는다
		int nowYear;
		int nowMonth;
		int dayOfMonth; //영역이 다르면 같은 이름의 변수 선언 가능
		
		//2.값 할당) 변수명 = 값;
		nowYear = 2025;
		nowMonth = 1;
		dayOfMonth = 14;
		
		//3.값 사용) 출력, 연산, 재할당. 지역변수는 개발자가 초기화를 수동으로 해주어야한다.
		System.out.print(nowYear+"년");
		System.out.print(nowMonth+"월");
		System.out.println(dayOfMonth+"일"); //14
		
		//변수는 값 할당을 여러번 할 수 있다
		dayOfMonth = 15;
		System.out.println(dayOfMonth+"일"); //15: 같은 이름의 변수지만 다른 값이 출력
		
		int 내나이 = 27;
		System.out.println("나의 나이는 " + 내나이 + "살");
	}
}