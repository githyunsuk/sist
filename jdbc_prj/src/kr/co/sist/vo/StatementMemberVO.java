package kr.co.sist.vo;

import java.sql.Date;

public class StatementMemberVO {
	private int num, age;
	private String name, gender, tel;	
	private Date inputDate;
	
	public StatementMemberVO() {
	
	}

	public StatementMemberVO(int num, int age, String name, String gender, String tel, Date inputDate) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
		this.inputDate = inputDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		return "StatementMemberVO [num=" + num + ", age=" + age + ", name=" + name + ", gender=" + gender + ", tel="
				+ tel + ", inputDate=" + inputDate + "]";
	}
	
}	
	
	
