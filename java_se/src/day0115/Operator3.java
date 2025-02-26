package day0115;
/**
shif연산자(비트 밀기 연산)
<< left shift: 비트를 왼쪽으로 밀고, 빈칸을 항상 0으로
>> right shift: 비트를 오른쪽으로 밀고, 빈칸은 최상위 부호 비트에 따라 양수면 0, 음수면 1
>>> unsigned right shift: 비트를 오른쪽으로 밀고, 빈칸은 항상 0으로
*/
class Operator3
{
	public static void main(String[] args)
	{
		int i = 25; //0001 1001 0110 0100
		System.out.printf("%d << 2 = %d \n", i, i<<2);
		
		i = 27;
		System.out.printf("%d >> 3 = %d \n", i, i>>3);
		
		i = 31;
		System.out.printf("%d >>> 4 = %d \n", i, i>>>4);
		
		i = 1;
		System.out.printf("%d << 31 = %d \n", i, i<<31);
		
		i = -1;
		System.out.printf("%d >> 100 = %d \n", i, i>>100);
		System.out.printf("%d >>> 1 = %d \n", i, i>>>1);
	}//main
}//class