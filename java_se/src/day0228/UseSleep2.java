package day0228;

import java.util.Random;

//1. Runnable 구현
public class UseSleep2 implements Runnable {
//2. run() override
	@Override
	public void run() {
		System.out.print("loading");
		//3. Thread로 동작해야할 코드 ( 동시에 실행되어야할 코드 정의 )
		Random r = new Random();
		for(int i=0; i<15; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(100*r.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("finish");
	}

	public static void main(String[] args) {
		//4. Runnable을 구현한 클래스를 객체화
		UseSleep2 ur = new UseSleep2();
		//5. Thread 클래스를 Runnable 구현 클래스와 has a 관계로 객체화
		Thread t = new Thread(ur);
		//6. Thread 객체의 start() 호출
		t.start();
	}

}
