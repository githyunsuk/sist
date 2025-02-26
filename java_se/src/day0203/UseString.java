package day0203;

/**
 * java.lang,String 클래스의 사용
 */
public class UseString {

	public UseString() {
		String str = "";
		String str2 = null;
		
//		System.out.println(str2 == null);
//		System.out.println(str == null);
		System.out.println(str);
		System.out.println(str.length() == 0);
		System.out.println(str.isEmpty());
		
		if(str != null && !str.isEmpty()) {
			
		}
		
		str = " A BC  ";
		str2 = str.trim(); //"A BC" 할당
		System.out.printf("[%s]의 앞뒤 공백 제거 [%s]\n",str,str2);
		
		str = "자바는 언어!";
		//문자열 비교 - 문자열 모든 값을 알아야 비교
		System.out.println(str.equals("자바는 언어!"));
		System.out.println(str.equals("자바는 언어"));
		
		//문자열 일부 값만 알아도 비교
		str = "이장훈";
		str2 = "이재준";
		String str3 = "서장훈";
		
		//특정 문자열로 시작하는지
		System.out.println(str.startsWith("이"));
		System.out.println(str2.startsWith("이"));
		System.out.println(str3.startsWith("이"));
		
		//특정 문자열로 끝나는지?
		System.out.println(str.endsWith("장훈"));
		System.out.println(str2.endsWith("재준"));
		System.out.println(str3.endsWith("이"));
		
		//특정 문자열 포함?
		System.out.println(str.contains("장"));
		System.out.println(str2.contains("재준"));
		System.out.println(str3.contains("이"));
		
		//문자열 치환
		str = "Java Oracle";
		str2 = str.replace("a", "A");
		System.out.println(str2);
		
		String msg = "피씨방인데 씨방새 어디니?";
		String filter = msg.replace("씨방", "**");
		System.out.println(filter);
		
		filter = msg.replaceAll("씨","*").replaceAll("방","*");
		
		//원하는 형식의 문자열 생성
		int year = 2025;
		double height = 175.9;
		
		String formatStr = String.format("올해는 %d년 내 키는 %f", year, height);
		System.out.println(formatStr);
		
		//정규식(RegEx)
		msg = "hello! 자바 010-1234-5678 내 나이는 25살 우리집 번지는 19-1번지";
		
		//숫자 패턴 \\d
		//문자열에서 모든 숫자를 x로 처리
		str = msg.replaceAll("\\d", "*");
		System.out.println(str);
		
		//문자여 안에서 전화번호 형식을 변경
		str = msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "***-****-****");
		System.out.println(str);
		
		str = msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "$1-****-$3");
		System.out.println(str);
		
		str = msg.replaceAll("(\\d{3})-(\\d{1})(\\d{3}-\\d{4})", "$1-x$3");
		System.out.println(str);
		
		//긍정형 전방탐색
		str = msg.replaceAll("\\d{2}(?=살)", "**");
		System.out.println(str);
		//긍정형 후방탐색
		str = msg.replaceAll("(?<=나이는 )(\\d{2})", "**");
		System.out.println(str);
		//전방과 후방 함께
		str = msg.replaceAll("(?<=나이는 )(\\d{2})(?=살)ㅜ", "**");
		System.out.println(str);
		
		//문자열
		msg = "가나다 Test ~0abc test 자바 z Z1o9!";
		System.out.println(msg.replaceAll("[Test]",""));
		System.out.println(msg.replaceAll("[A-Z]",""));
		System.out.println(msg.replaceAll("[a-z]",""));
		System.out.println(msg.replaceAll("[0-9]",""));
		System.out.println(msg.replaceAll("[~!.,@#$%^&*()]",""));
		System.out.println(msg.replaceAll("[ㄱ-힣]",""));
		
//		String id = "Test1234~+";
//		if (!"".equals(id.replaceAll("[A-Za-z0-9~+]", ""))) {
//			System.out.println("허용되지 않은 문자");
//			return;
//			
//		}
		
		msg = "hello! 내 이메일은 test@test.com";
		str = msg.replaceAll("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b","xxx@xxx.xxx");
		System.out.println(str);
		
		int i = 3;
		str = String.valueOf(i);
		str2 = Integer.toString(i);
		System.out.println(str);
		System.out.println(str2);
	}
	public static void main(String[] args) {
		
		new UseString();
	
	}

}
