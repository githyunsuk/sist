package day0228;

//1. Thread를 상속받는다.
public class UseThread extends Thread {

	//2.run Method Override
	@Override
	public void run() {
		//3.Thread로 동작해야할 코드( 동시에 실행되어야할 코드 정의 )
		for(int i=0; i<500; i++) {
			System.out.println("run method i ==== " + i);
		}
	}//run
	
	public void method() {
		for(int i=0; i<500; i++) {
			System.out.println("method i ------- " + i);
		}
	}
	
	public static void main(String[] args) {
		//4. Thread를 상속 받은 자식 클래스를 객체화
		UseThread ut = new UseThread();
		//5. start()를 호출하여 스레드로 코드가 동작되도록 수행한다.
		ut.start(); //start()에 의해서 run() 호출되어야한다. (run()직접 호출하면 스레드 x)
		ut.method();
		System.out.println("프로그램 끝!");
	}//main

}//class
