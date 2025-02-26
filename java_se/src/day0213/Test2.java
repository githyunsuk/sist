package day0213;

import java.awt.Frame;
import java.awt.Window;

public class Test2 extends Window {

	public Test2(Frame frame) {
		super(frame); //window와 frame은 has a 관계
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Frame frame = new Frame("연습");
		new Test2(frame);
	}

}
