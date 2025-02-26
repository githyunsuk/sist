package day0221;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Multiple {

	public int multiplicationInput() {
		int input = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력:");
		input = scan.nextInt();
		scan.close();
		return input;
	}
	
	public void printMultiplicationTable(int input) throws MultiplicationException {
		if(input<2 || input>9) {
			throw new MultiplicationException();
		}
		System.out.println(input+"단");
		for(int i=1; i<10; i++) {
			System.out.printf("%d x %d = %d\n",input,i,input*i);
		}
	}
	
	public static void main(String[] args) {
		
		Multiple ex = new Multiple();
		String msg = "구구단 출력 완료";
		try {
			ex.printMultiplicationTable(ex.multiplicationInput());
		} catch (MultiplicationException e) {
			msg = e.getMessage();
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(null, msg);
		}
	}
}
