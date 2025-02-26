package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 키보드 입력된 엔터가 쳐지기 전까지 한줄을 읽기
 * 한글이 깨짐 -> Stream을 결합 
 */
public class UseLineInput {

	public UseLineInput() throws IOException {
		System.out.println("이름 넣고 엔터");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String name = br.readLine();
			System.out.println(name + "님 안녕?");
		} finally {
			//반드시 실행되어야할 코드
			if(br != null) {
				br.close();
			}
		}
	}

	public static void main(String[] args) {
		try {
			new UseLineInput(); //업무처리 코드와 
		} catch(IOException e) {
			e.printStackTrace(); //문제가 발생했을 때 처리 코드를 분리하여 작성할 수 있다.
		}
	}
}
	