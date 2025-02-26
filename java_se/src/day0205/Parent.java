package day0205;

/**
 * 부모 클래스: 자식 클래스들에서 공통적으로 사용하는 값이나 업무를 구현 
 */
public class Parent {

	private int age;

	/**
	 * 부모의 getter method
	 * @return 부모가 가진 age 변수 값
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 부모의 setter method
	 * @param age 부모의 변수에 설정할 값
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
