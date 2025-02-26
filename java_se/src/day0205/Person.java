package day0205;

/**
 * 사람을 대상으로 선정하여 제작하는 클래스
 * 명사적인 특징: 눈, 코, 입
 * 동사적인 특징: 먹는 일
 * 이 클래스는 일반 클래스로 객체화하여 사용
 */
public abstract class Person {
	
	//instance variable: 객체가 생성되면 객체마다 가지게 되는 변수. 자동초기화 된다.
	private int eye, nose, mouth;
	private String name;
	
	/**
	 * 사람 객체가 생성될 때 사용되는 기본 생성자.
	 */
	public Person() {
		this.eye = 2;
		this.nose = 1;
		this.mouth = 1;
	}
	
	/**
	 * 생성자의 Overload
	 * 사람객체가 생성될 때 사용되는 인자있는 생성자.
	 * @param eye 설정할 눈의 개수
	 * @param nose 설정할 코의 개수
	 * @param mouth 설정할 입의 개수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}
	
	/**
	 * 생성된 사람 객체에 눈의 개수 반환
	 * @return
	 */
	public int getEye() {
		return eye;
	}
	/**
	 * 생성된 사람 객체의 눈의 개수 설정
	 * @param eye
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}
	/**
	 * 생성된 사람 객체의 코의 개수 반환
	 * @return
	 */
	public int getNose() {
		return nose;
	}
	/**
	 * 생성된 사람 객체의 코의 개수 설정
	 * @param nose
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}
	/**
	 * 생성된 사람 객체의 입의 개수 반환
	 * @return
	 */
	public int getMouth() {
		return mouth;
	}
	/**
	 * 생성된 사람 객체의 입의 개수 설정
	 * @param mouth
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	/**
	 * 생성된 사람 객체의 이름 반환
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 생성된 사람 객체의 이름 설정
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String eat() {
		return name + "이 밥을 먹는다";
	}	
	
	public String eat(String food, int cost) {
		return name + "이 식당에서 " + food + "인 음식을 " + cost + "원 내고 사먹는다";
	}
	
}
