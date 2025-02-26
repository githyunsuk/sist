package day0214;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	public Calculator() {
		super("계산기");
		
		JTextField jtfNumber = new JTextField();
		
		String[] btnLabel = "7,8,9,4,5,6,1,2,3,+/-,0,.".split(",");
		JButton[] btnArr = new JButton[btnLabel.length];
		
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(4,3)); //FlowLayout ==> GridLayout 전환
		
		for(int i=0; i<btnArr.length; i++) {
			btnArr[i] = new JButton(btnLabel[i]); //String 방의 값으로 배열을 생성하고
			jpCenter.add(btnArr[i]);
		}
		
		add("North",jtfNumber);
		add("Center",jpCenter);
		
		setSize(250, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {

		new Calculator();
	}

}
