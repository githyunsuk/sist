package day0508;

public class DataDTO {

	private String name;
	private int myAge;

	public DataDTO() {
		System.out.println("DataDTO 기본 생성자");
	}

	public DataDTO(String name, int myAge) {
		this.name = name;
		this.myAge = myAge;
		System.out.println("DataDTO 매개변수 있는 생성자");
	}

	public String getName() {
		System.out.println("getName 호출");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName 호출");
		this.name = name;
	}

	public int getMyAge() {
		System.out.println("getMyAge 호출");
		return myAge;
	}

	public void setMyAge(int myAge) {
		System.out.println("setMyAge 호출");
		this.myAge = myAge;
	}

	@Override
	public String toString() {
		return "DataDTO [name=" + name + ", myAge=" + myAge + "]";
	}

}
