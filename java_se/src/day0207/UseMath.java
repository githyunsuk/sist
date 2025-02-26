package day0207;

/**
 * Math.
 * 객체화 할 수 없고, 제공되는 method를 호출하여 일을 수행하는 클래스. 
 */
public class UseMath {

	public static void main(String[] args) {

		int i = 7;
		double d = 2.7;
		
		int iResult = Math.abs(i);
		double dResult = Math.abs(d);
		
		System.out.println(i + "의 절대값 " + iResult);
		System.out.println(d + "의 절대값 " + dResult);
		
		d = 2.7;
		System.out.println(Math.round(d));
		
		d = 2.000000000000001;
		System.out.println(Math.ceil(d));
		
		d = 2.7;
		System.out.println(Math.floor(d));
		
		System.out.println("절사:"+(int)d);
	
		//난수
		d = Math.random();
		System.out.println(d);
		System.out.println(d*10);
		System.out.println((int)(d*10));
	
		//객체 생성
		UseMath um = new UseMath();
		//비밀번호를 char[]에 저장
		char[] passWord = um.createPassword();
		//콘솔에 출력
		um.printPassword(passWord);
		

	}
	
	
	
	//비밀번호 생성 반환 method
	public char[] createPassword() {
		//비밀번호 8자: 대문자(65~90), 소문자(97~122), 숫자(48~57)
		char[] tempPass = new char[8];
		int tempChar = 0;
		for(int i=0; i<tempPass.length; i++) {
			tempChar = (int)(Math.random()*123);
			if((tempChar>47 && tempChar<58) || (tempChar>65 && tempChar<91) || (tempChar>96 && tempChar<123)) {
				tempPass[i] = (char)tempChar;
			}else {
				i--;
			}
		}
			
		return tempPass;
		
	}
	//비밀번호 출력  method
	public void printPassword(char[] pw) {
		System.out.println(pw);
	}

}
