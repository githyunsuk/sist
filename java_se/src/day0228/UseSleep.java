package day0228;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

//1. Runnable 구현
public class UseSleep extends JFrame implements Runnable {
	private JLabel jlbl;
	private SimpleDateFormat sdf;
	
	public UseSleep() {
		super("지금 시간은?");
		sdf = new SimpleDateFormat("yyyy-MM-dd EEE hh:mm:ss");
		
		jlbl = new JLabel(sdf.format(new Date()), JLabel.CENTER);
		jlbl.setFont(new Font("맑은 고딕", Font.BOLD , 30));
		
		add("Center", jlbl);
		setBounds(100,100,400,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//2. run() override
	@Override
	public void run() {
		// 3.동시에 실행되어야할 코드 정의

		try {
			while (true) {
				jlbl.setText(sdf.format(new Date()));
				Thread.sleep(1000);
			}
//			for (int i = 0; i < 10; i++) {
//				System.out.println(i);
//				Thread.sleep(1000); //running <-> block
//			}
		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// 4. 스레드로 돌려야하는 클래스를 객체화
		UseSleep us = new UseSleep();
		// 5. Thread 클래스와 has a 설정
		Thread t = new Thread(us);
		// 6. Thread 객체에 start() 호출
		t.start();
	}

}
