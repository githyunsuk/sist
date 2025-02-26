package day0115;
/**
진수 사용
*/
class Radix 
{
	public static void main(String[] args) 
	{
		int binary = 0b1010;
		int octal = 012;
		int decimal = 10;
		int hex = 0xa;
	
		//개발자가 어떤 진수를 사용하든 JVM에서 2진수가 저장/연산, 결과는 10진수
		System.out.println(binary);
		System.out.println(octal);
		System.out.println(decimal);
		System.out.println(hex);
		System.out.println(binary+octal+decimal+hex);
		
		int i = 36;
		System.out.printf("%d를 2진수로 변환하면 %s \n", i, Integer.toBinaryString(i));
		
		i = 24;
		System.out.printf("%d를 8진수로 변환하면 %s \n", i, Integer.toOctalString(i));
		
		
		
		
	

		
	}//main
}//class

// 36 -> 0010 0100
// 25 -> 0001 1001
// 89 -> 0101 1001
// 300 -> 0001 0010 1100

// 030 -> 0001 1000 -> 24
// 0201 -> 0000 1000 0001 -> 129
// 0300 -> 0000 1100 0000 -> 192

//0x25 -> 0010 0101 -> 37
//0x1D -> 0001 1101 -> 29
//0xFF -> 1111 1111 -> 255