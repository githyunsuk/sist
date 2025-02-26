package day0219;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 윈도우 이벤트 처리와 키보드 이벤트 처리
 */
@SuppressWarnings("serial")
//1.윈도우 이벤트를 처리하기 위해 WindowListener를 구현
public class TestKeyDesign extends JFrame implements WindowListener {

	private JTextField jtf;
	
	public TestKeyDesign() {
		
		super("윈도우 이벤트 처리");
		
		jtf = new JTextField();
		
		add("Center", jtf);
		
		//키보드 이벤트 등록
		jtf.addKeyListener(new TestKeyEvt(this));
		
		//발생된 윈도우 이벤트를 등록
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //inner class는 외부 클래스의 자원 직접 사용 가능
			}
			
		});
		setBounds(100, 100, 400 ,300);
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose(); //현재 윈도우 객체를 닫고 종료 상태로 이동
	}


	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}


	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}


	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

	public static void main(String[] args) {
		new TestKeyDesign();
		new TestKeyDesign();
	}
}
