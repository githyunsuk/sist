package day0226;

import java.io.Serializable;


public class UserDataVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 76627086003339750L;
	private String name;
	private double height;
	private double weight;
	
	public UserDataVO(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	
	public String getName() {
		return name;
	}


	public double getHeight() {
		return height;
	}


	public double getWeight() {
		return weight;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "UserDataVO [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
}
