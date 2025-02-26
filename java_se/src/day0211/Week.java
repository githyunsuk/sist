package day0211;

/**
 * 한글로 된 요일과 요일의 번호를 저장하는 enum 
 */
public enum Week {

	MON("월요일", 10),
	TUE("화요일", 20),
	WED("수요일", 30),
	THU("목요일", 40),
	FRI("금요일", 50),
	SAT("토요일", 60),
	SUN("일요일", 70),
	;
	
	//변수는 외부에서 접근하지 못하도록 private
	private final String name;
	private final int value;
	
	//생성자 private
	private Week(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 요소로 할당된 이넘 객체의 이름에 저장된 값("월요일") 얻는 일
	 * 사용법)
	 * 1.이넘 얻기
	 * Week week = Week.MON
	 * 2.이름에 저장된 값 얻는다. (월요일)
	 * week.getName()
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
