package day0213;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * has a 관계로 Window Component 사용.
 */
public class FrameHasA {
	//2.생성자에서 외부에서 생성된 Window
	public FrameHasA(JFrame frame) {
		JButton jbtn = new JButton("버튼");
		frame.add(jbtn);
		frame.setSize(400,250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//1.외부에서 Window Component 생성되고
		JFrame jf = new JFrame("has a 관계로 window component 사용");
		new FrameHasA(jf);
	}

}
