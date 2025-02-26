package day0115;
/**
단항 연산자 - 연산에 필요한 항이 하나인 연산자.
~, !, +, -, ++, --
*/
class Operator1 
{
	public static void main(String[] args) 
	{
		int i = 15, j = -14;
		System.out.println("~"+i+"="+ ~i); //부호변경 1 증가
		System.out.println("~"+j+"="+ ~j); //부호변경 1 감소
		
		i = 3; j = 4;
		System.out.println("!"+i+">"+j+"="+!(i>j));
		
		boolean flag = true;
		System.out.printf("!%b = %b \n", flag, !flag);
		
		i = 15; j = -15;
		System.out.printf("+%d=%d \n", i, +i);
		System.out.printf("+%d=%d \n", j, +j);
		
		//-2의 보수 연산 (부호 변경 연산)
		System.out.printf("-%d=%d \n", i, -i);
		System.out.printf("-%d=%d \n", j, -j);
		
		//++:대상체의 값을 1씩 증가, --:대상체의 값을 1씩 감소
		//전위 연산: 연산자 대상체
		++i; //15 -> 16
		//후위 연산: 대상체 연산자
		i++; //16 -> 17
		System.out.println(i);
		
		--i;
		i--;
		System.out.println(i);
	}
}
