package day0221;

/**
 * 업무명 + Exceptipn을 클래스명을 설정.
 * 기본생성자: 예외 발생 시 고정적인 메시지를 설정할 때.
 * Overload 생성자: 예외 발생 시 고정적인 메시지를 설정할 때
 */
@SuppressWarnings("serial")
public class TabaccoException extends Exception {

	public TabaccoException() {
		this("담배 피지 마");
		
	}
	
	public TabaccoException(String msg) {
		super(msg);
	}
}
