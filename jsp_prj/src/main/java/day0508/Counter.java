package day0508;

public class Counter {
	private int cnt;

	private Counter() {
		System.out.println("Counter 생성");
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;
	}

}
