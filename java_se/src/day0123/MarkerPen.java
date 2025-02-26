package day0123;

/**
 * 마카펜을 대상선정하여 만드는 설계도
 * 마카펜을 추상화(객체모델링)
 * 명사적 특징 - 눈에 보이는 특징(값 저장): 뚜껑, 몸체, 색 
 * 동사적 특징 - 객체가 제공하는 기능: 쓴다.
 */
public class MarkerPen {
	private int cap;
	private int body;
	private String color;
	
	/**
	 * 마커펜 클래스의 기본 생성자
	 * 뚜껑 1개, 물체 1개, 검은색인 마카펜
	 */
	public MarkerPen() {
		this.cap = 1;
		this.body = 1;
		this.color = "검은";
	}
	
	/**
	 * 마카펜 클래스의 매개변수 있는 생성자
	 * 뚜껑 1개, 몸체 1개, 검은색인 마카펜을 생성
	 * 뚜껑과 몸체는 1~10개 까지만 설정할 수 있고, 색은 검/파/빨로만 설정할 수 있다.
	 * 설정되는 값이 맞지 않으면 뚜껑과 몸체는 1개로 설정되고, 색은 검은색으로
	 * @param cap
	 * @param body
	 * @param color
	 */
	public MarkerPen(int cap, int body, String color) {
		
		if(!(cap > 0 && cap < 11)) {
			this.cap = 1;
		}
		if(!(body > 0 && body < 11)) {
			this.body = 1;
		}
		if(!("검은".equals(color) || "파란".equals(color) || "빨간".equals(color))) {
			this.color = "검은";
		}
		this.cap = cap;
		
		this.body = body;
		this.color = color;
	}
	
	/**
	 * 생성된 마카펜 객체의 뚜껑 개수를 설정하는 일
	 * 뚜껑의 개수 1개로만 설정 가능
	 * @param cap 설정할 뚜껑의 개수
	 */
	public void setCap(int cap) {
		if (cap != 0) {
			cap = 1;
		}
		this.cap = cap;
	}
	
	/**
	 * 생성된 마카펜 객체의 몸체 개수를 설정하는 일
	 * 몸체 개수 1개로만 설정 가능
	 * @param body
	 */
	public void setBody(int body) {
		if(body != 1) {
			body = 1;
		}
		this.body = body;
	}
	
	/**
	 * 생성된 마카펜 객체의 색을 설정하는 일.
	 * 색은 검/파/빨만 가능
	 * 다른 색이 설정되면 검은색으로 고정
	 * @param Color
	 */
	public void setColor(String color) {
		if(!("검은".equals(color)) && !("파란".equals(color)) && !("빨간".equals(color) )) {
			color = "검은";
		}
		this.color = color;
	}
	
	/**
	 * 생성된 마카펜 객체의 설정된 뚜껑의 개수를 반환
	 * @return 뚜껑의 수
	 */
	public int getCap() {
		return cap;
	}
	
	/**
	 * 생성된 마카펜 객체에 설정된 몸체의 개수를 반환
	 * @return 몸체의 수
	 */
	public int getBody() {
		return body;
	}
	
	/**
	 * 생성된 마카펜 객체에 설정된 색을 반환
	 * @return color;
	 */
	public String getColor() {
		return color;
	}
	
	
	
	public String write(String msg) {
		return color+"색으로 "+msg+"를 칠판에 쓴다.";
	}
}
