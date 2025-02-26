package day0203;

public class Exam0203 {

	public static String getEmail(String email) {
		int atIndex = email.indexOf('@');
		int dotIndex = email.indexOf('.');
		
		if(email.length() < 7) {
			return "이메일이 유효하지 않습니다.";
		}else if(atIndex == -1) {
			return "@ 없습니다.";
		}else if(dotIndex == -1 || atIndex > dotIndex) {
			return ". 없습니다";
		}else {
			return "정상적인 이메일";
		}
		
	}
	
	public static void main(String[] args) {

		System.out.println(Exam0203.getEmail("test@test.com"));
	}

}
 