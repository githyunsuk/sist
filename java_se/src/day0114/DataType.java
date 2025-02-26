package day0114;
/**
	자바에서 제공하는 primitive type의 사용
*/
class DataType
{
	public static void main(String[] args) 
	{
		System.out.println("정수 상수 값을 저장할 수 있는 데이터형");
		byte byteValue; //signed value: -128 ~ +127
		byteValue = 127;
		System.out.println("byte:" + byteValue);
		
		short shortValue = 32767;
		System.out.println("short:" + shortValue);
		
		int intValue = 2147483647;
		System.out.println("int:" + intValue);
		
		long longValue = 14;
		System.out.println("long:" + longValue);
		
		long money = 100000000000000L;
		System.out.println("money:" + money);
		
		byte num1 = 10; //demotion
		byte num2 = 20; //demotion
		int result = num1 + num2;
		System.out.println(result);
		
		System.out.println("문자 상수 값을 저장할 수 있는 데이터형");
		char upperCase = 'A';
		char lowerCase = 'a';
		char number = '0';
		char hangul = 44032;
		System.out.println("char:" + upperCase + lowerCase + number + hangul);
		
		System.out.println("실수 상수 값을 저장할 수 있는 데이터형");
		float floatValue;
		floatValue = 1.14f; //literal의 크기는 8byte, float 데이터 형은 4byte -> error
		System.out.println("float:" + floatValue);
		double doubleValue = 1.14;
		System.out.println(doubleValue);
		System.out.println(Math.random());
		
		System.out.println("불린 상수 값을 저장할 수 있는 데이터형");
		boolean flag = true;
		boolean flag2 = false;
		System.out.println("boolean:" + flag + flag2);
		
		byte b = 10;
		byte b2 = 20;
		byte c = (byte)(b + b2);
		System.out.println(c);
	}
}
