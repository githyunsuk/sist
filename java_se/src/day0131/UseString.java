package day0131;

/**
 * String(문자열)을 저장할 수 있는 데이터형 java.lang.String
 * 기본형 형식) new 사용하지 않고 java.lang.String을 사용
 * String str = "abc";
 * 참조형 형식) new를 사용
 * String str = new String("abc");
 */
public class UseString {

	public static void main(String[] args) {

		//기본형 형식의 사용
		String str = "ABC";
		String str2 = new String("ABC");
		
		//참조형 형식의 사용
		
		System.out.println("기본형" + str);
		System.out.println("참조형" + str2);
		
		// ==은 참조형 데이터혀에선 주소 같은지 여부
		System.out.printf("기본형 %s와 ABC는 %b\n",str,str=="ABC");
		System.out.printf("참조형 %s와 ABC는 %b\n",str2,str2=="ABC");
		
		//equals method는 기본형이든 참조형이든 동일한 비교
		System.out.printf("기본형 equals %s와 ABC는 %b\n",str,str.equals("ABC"));
		System.out.printf("참조형 equals %s와 ABC는 %b\n",str2,str2.equals("ABC"));
		
		str = "abcdef";
		String email = "wngustjr1306@naver.com";
		
		System.out.println("str의 글자수" + str.length());
		System.out.println("email의 글자수" + email.length());
		
		String upperCase = str.toUpperCase();
		System.out.println("대문자 변환:" + upperCase);
		System.out.println("소문자 변환:" + upperCase.toLowerCase());
		
		//str = "abcdef";
		//       012345 - index
		//특정 인덱스의 문자 얻기
		System.out.printf("%s의 3번째 인덱스 문자: %c\n",str,str.charAt(3));
		int index = 5;
		char tempChar = str.charAt(index);
		System.out.printf("%s의 %d번째 인덱스 문자: %c\n",str,index,tempChar);
		
		/*email의 처음부터 끝까지의 문자를 잘라서 한자씩 출력
		for(int i=0; i<email.length(); i++) {
			System.out.println(email.charAt(i));
		}*/
		
		System.out.printf("%s의 %s문자열의 시작 인덱스 %d\n",str,"c",str.indexOf("c"));
		System.out.printf("%s의 %s문자열의 시작 인덱스 %d\n",str,"def",str.indexOf("def"));
		
		//존재하지 않는 문자열을 입력하면 -1
		System.out.printf("%s의 %s문자열의 시작 인덱스 %d\n",str,"C",str.indexOf("C"));
		System.out.printf("%s의 %s문자열의 시작 인덱스 %d\n",str,"dEf",str.indexOf("dEf"));

		str = "java는 완벽한 oopㅇ언어a yo!";
		System.out.printf("%s의 %s문자열의 시작 인덱스 %d\n",str,"a",str.indexOf("a",str.indexOf("a")+1));
		
		//문자열의 뒤에서부터 특정문자열의 인덱스 얻기
		System.out.printf("%s에서 가장 마지막에 나오는 %s문자열의 시작 인덱스 %d\n",str,"a",str.indexOf("a"));
		
		str = "abcdefg";
		System.out.printf("%s에서 2~4번째 인덱스:%s\n",str,str.substring(2,5));
		System.out.printf("%s에서 3~번째 인덱스:%s\n",str,str.substring(3));
		
		email = "wngustjr1306@naver.com";
		System.out.println("메일주소:" + email.substring(0,email.indexOf("@")));
		System.out.println("도메인주소:" + email.substring(email.indexOf("@")+1));
		
	}

}
