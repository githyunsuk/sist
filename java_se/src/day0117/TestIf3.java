package day0117;
 /**
 * 문자열에 비교
 */
public class TestIf3 {
	
	public static void main(String[] args) {
		
//		if(args[0].equals("Java") || args[0].equals("java")) {
//			System.out.println("WORA, 완벽한 OOP언어, 메모리관리의 편의성");
//		}
		if("Java".equals(args[0]) || "java".equals(args[0])) {
			System.out.println("WORA, 완벽한 OOP언어, 메모리관리의 편의성");
		}
		
		//main method의 두 번째 arguments에 입력 받은 값을 정수로 저장하여
		//0~100 사이인 경우에만 "유효한 점수입니다."
		
		int num = Integer.parseInt(args[1]);
		if (num >= 0 && num <= 100) {
			System.out.printf("%d은(는) 유효한 숫자입니다 \n", num);
		}
		
	}

}
