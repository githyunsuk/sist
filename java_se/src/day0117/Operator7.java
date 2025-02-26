package day0117;

/**
 * 대입연산자
 * = : 순수대입
 * += -= *= /= %= : 산술대입
 * <<= >>= >>>= : 쉬프트대입
 * &= |= ^= : 비트논리 대입
 */
public class Operator7 {
	
	public static void main(String[] args) {
		
		int i = 3;
		i = 4;
		i += 2;
		i -= 3;
		i *= 3;
		i /= 2;
		//double d = 9 / 2.0;
		//double d = 9.0 / 2;
		//double d = (double)9 / 2;
		double d = 9 / (double)2;
		
		i %= 3;
		
		i <<= 4;
		i >>= 1;
		i >>>= 2;
		
		i &= 10;
		i |= 19;
		i ^= 16;
		System.out.println(i);
		System.out.println(d);
		
	}//main

}//class
