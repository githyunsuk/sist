package day0212;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseScanner3 {

	public UseScanner3() {
		//이름을 계속 입력받아 list에 넣고 Y나 y를 입력하면 종료한 후
		//이름을 가진 list를 반환하고, list의 값을 콘솔에 출력하는 코드
		Scanner scan = new Scanner(System.in);
		List<String> lst = new ArrayList<String>();
		System.out.println("이름 입력. 종료하려면 Y or yw");
		while(true) {
			String temp = scan.nextLine();
			if(temp.equals("Y") || temp.equals("y")) {
				break;
			}
			lst.add(temp);
		}
		System.out.println(lst);
	}
	
	public static void main(String[] args) {

		new UseScanner3();
	}

}
