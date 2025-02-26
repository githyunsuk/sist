package day0219;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyEvt extends KeyAdapter {

	private TestKeyDesign tkd;
	
	public TestKeyEvt( TestKeyDesign tkd) {
		this.tkd = tkd;
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		System.out.println("2.keyTyped");
//		//키코드가 얻어지지 않는다.
//		System.out.println("눌린 키 코드:" + e.getKeyCode() + ", 눌린키의 문자:" + e.getKeyChar());
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		System.out.println("1.keyPressed");
//		System.out.println("눌린 키 코드:" + e.getKeyCode() + ", 눌린키의 문자:" + e.getKeyChar());
//	}

	@Override
	public void keyReleased(KeyEvent e) {
		//키보드의 키가 올라올 때 작업
		System.out.println("3.keyReleased");
		System.out.println("눌린 키 코드:" + e.getKeyCode() + ", 눌린키의 문자:" + e.getKeyChar());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			tkd.dispose();
			break;
		}
	}
	
	
}
