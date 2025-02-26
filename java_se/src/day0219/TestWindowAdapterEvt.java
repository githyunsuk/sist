package day0219;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * XxxAdapter 상속 
 */
//windowAdapter 클래스는 추상 메서드가 없음 
public class TestWindowAdapterEvt extends WindowAdapter {
	
	private TestWindowAdapter twa;
	
	public TestWindowAdapterEvt(TestWindowAdapter twa) {
		this.twa = twa;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
//		dispose(); TestWindowAdapterEvt 클래스의 상속관계에서는 window가 존재 x
	}

}
