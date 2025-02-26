package day0116;

/**
 * 관계연산자의 사용법 
 * >, <, >=, <=, ==, !=
 */
public class Operator4 {

	public static void main(String[] args) {

		int i = 1, j = 16, k = 1;
		System.out.printf("%d == %d = %b \n", i, j, i==j);
		System.out.printf("%d == %d = %b \n", i, k, i==k);
		System.out.printf("%d != %d = %b \n", i, j, i!=j);
		System.out.printf("%d != %d = %b \n", i, k, i!=k);
	}//main

}//class
