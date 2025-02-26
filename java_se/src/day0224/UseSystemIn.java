package day0224;

import java.io.IOException;

public class UseSystemIn {

	public static void main(String[] args) {

		System.out.println("아무키나 누르고 엔터");
		
		try {
//			int input = System.in.read();
//			System.out.println("입력 값: " + (char)input);
			int inputData = 0;
			
			while((inputData = System.in.read()) != 10) {
				System.out.print((char)inputData);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
