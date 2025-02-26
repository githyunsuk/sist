package day0213;

public class ScoreVO {
	private String name;
	private int java;
	private int oracle;
	
	public ScoreVO() {
		
	}
	
	public ScoreVO(String name, int java, int oracle) {
		this.name = name;
		this.java = java;
		this.oracle = oracle;
	}

	public String getName() {
		return name;
	}

	public int getJava() {
		return java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
}