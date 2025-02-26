package day0131;

/**
 * 사용자 정의 데이터형(값을 저장할 목적으로 생성)
 * 자바에서 제공하는 데이터형을 모아서 새로운 이름의 데이터형을 만들고 사용 
 * 학생의 정보를 저장할 목저의 데이터형 생성
 */
public class StudentInfo {

	private int num;
	private String name;
	private String email;
	private int age;
	private double height;
	private double weight;
	
	/**
	 * 기본생성자를 사용하여 객체화
	 */
	public StudentInfo() {
		this(0,null,null,0,0.0,0.0);
	}
	
	/**
	 * 인자 있는 생성자를 사용하여 객체화
	 * @param num 번호
	 * @param name 이름
	 * @param email 이메일
	 * @param age 나이
	 * @param height 키
	 * @param weight 몸무게
	 */
	public StudentInfo(int num, String name, String email, int age, double height, double weight) {
		this.num = num;
		this.name = name;
		this.email = email;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
