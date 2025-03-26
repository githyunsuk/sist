package kr.co.sist.vo;

import java.sql.Date;

public class PstmtMemberVO {

	private int num, age;
	private String name, gender, tel, strInputDate;
	private Date inputDate;
	
	public PstmtMemberVO() {
		
	}

	public PstmtMemberVO(int num, String name, int age, String gender, String tel, String strInputDate, Date inputDate) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
		this.strInputDate = strInputDate;
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

	public String getStrInputDate() {
		return strInputDate;
	}

	public void setStrInputDate(String strInputDate) {
		this.strInputDate = strInputDate;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		return "PstmtMemberVO [num=" + num + ", age=" + age + ", name=" + name + ", gender=" + gender + ", tel=" + tel
				+ ", strInputDate=" + strInputDate + ", inputDate=" + inputDate + "]";
	}
		
}//class
