package day0218;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 이벤트 처리에 집중.
 */
//1. XxxListener 구현
public class HasaEvent implements ActionListener {

	public HasaEvent(HasaDesign hasAdesign) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has a 관계로 이벤트를 처리!!");
	}
	
	
	
}
