package day0214;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseGridLayout extends JFrame {

	public UseGridLayout() {
		super("GridLayout 연습");
		
		JTextField field = new JTextField();
		JButton jbtn = new JButton("버튼 1");
		JButton jbtn2 = new JButton("버튼 2");
		JButton jbtn3 = new JButton("버튼 3");
		JButton jbtn4 = new JButton("버튼 4");
		JButton jbtn5 = new JButton("버튼 5");
		JButton jbtn6 = new JButton("버튼 6");
		
		setLayout(new GridLayout(2,3));
		
		add(jbtn);
		add(jbtn2);
		add(jbtn3);
		add(jbtn4);
		add(jbtn5);
		add(jbtn6);
		
		setSize(400, 200);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new UseGridLayout();
	}

}
