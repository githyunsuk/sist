package day0213;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * is a 관계로 window component 사용 
 */
public class FrameIsA extends JFrame {

	public FrameIsA() {
		super("is a 관계로 window component 사용");
		
		JButton jbtn = new JButton("버튼");
		
		add(jbtn);
		
		setSize(300, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new FrameIsA();
	}

}
