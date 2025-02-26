package day0207;

/**
 * 긴 문자열 다루기
 * StringBuffer, StringBuilder 
 */
public class UseStringBuilder {
	
	public void useStringBuilder() {
		//1. 생성
		StringBuilder sb = new StringBuilder();
		//2. method 호출)
		//값을 추가) - 기존의 값 뒤에 붙기 때문에 원본이 계속 변경
		sb.append("안녕 하세요?");
		sb.append(25).append("년");
		
		//값 삽입) insert(시작 인덱스, 추가할 값)
		sb.insert(7, " 올해는 ");
		
		//값 삭제) delete(시작 인덱스, 끝 인덱스)
		sb.delete(2,6);
		
		//문자열의 순서 변경
		sb.reverse();
		System.out.println(sb);
	}
	
	public void useStringBuffer() {
		//1. 생성
				StringBuffer sb = new StringBuffer();
				//2. method 호출)
				//값을 추가) - 기존의 값 뒤에 붙기 때문에 원본이 계속 변경
				sb.append("안녕 하세요?");
				sb.append(25).append("년");
				
				//값 삽입) insert(시작 인덱스, 추가할 값)
				sb.insert(7, " 올해는 ");
				
				//값 삭제) delete(시작 인덱스, 끝 인덱스)
				sb.delete(2,6);
				
				//문자열의 순서 변경
				sb.reverse();
				System.out.println(sb);
	}

	public static void main(String[] args) {

		UseStringBuilder usb = new UseStringBuilder();
		System.out.println("-----------------StringBuilder 사용-------------");
		usb.useStringBuilder();
		System.out.println("-----------------StringBuffer 사용-------------");
		usb.useStringBuffer();
	}

}
