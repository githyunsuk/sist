package day0424;

public class ClassLifeCycle {

	private String name;
	public ClassLifeCycle(String name) {
		this.name = name;
		System.out.println(name +" 님 입사.");
	}
	
	@Override
	public void finalize() {
		System.out.println("일 안하고 핸드폰한 " + name + "씨 퇴사!");
	}
	
	public static void main(String[] args) {
		ClassLifeCycle c = new ClassLifeCycle("양준수");
		c = new ClassLifeCycle("강태일");
		c = new ClassLifeCycle("이호빈");
		
		System.gc(); //JVM에서 더이상 참조되지 않는 객체를 소멸
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
