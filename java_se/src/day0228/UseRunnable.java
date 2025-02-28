package day0228;

//1. Runnable 구현
public class UseRunnable implements Runnable {
//2. run() override
	@Override
	public void run() {
		//3. Thread로 동작해야할 코드 ( 동시에 실행되어야할 코드 정의 )
		for(int i=0; i<500; i++) {
			System.out.println("run method i ==== " + i);
		}
	}
	
	public void method() {
		for(int i=0; i<500; i++) {
			System.out.println("method i ------- " + i);
		}
	}

	public static void main(String[] args) {
		//4. Runnable을 구현한 클래스를 객체화
		UseRunnable ur = new UseRunnable();
		//5. Thread 클래스를 Runnable 구현 클래스와 has a 관계로 객체화
		Thread t = new Thread(ur);
		//6. Thread 객체의 start() 호출
		t.start();
		ur.method();
	}

}
