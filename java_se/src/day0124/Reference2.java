package day0124;

public class Reference2 {

	int i, j;
	
	
	
	public void setI(int i, Reference2 r) {
		System.out.println("setI에서 받은 객체:" + r);
		r.i = i;
	}
	
	public void setJ(int j) {
		this.j = j;
	}
	
	public int getI() {
		return i;
	}
	
	public static void main(String[] args) {
		
		Reference2 r = new Reference2();
		System.out.println("생성된 객체 " + r);
		r.setI(2025, r);
		r.setJ(20);
		System.out.println(r.getI());
		
		
	}
}
