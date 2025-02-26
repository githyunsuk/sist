package day0218;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * is a 관계로 window component 사용 
 */
//1. 윈도우 컴포넌트를 상속
//1. 발생된 Event를 처리할 수 있는 xxxListener 구현.
public class IsaEvent extends JFrame implements ActionListener {

	public IsaEvent() {
		super("is a 관계로 window component 사용");
		
		JButton jbtn = new JButton("클릭해봐");
		//3. 컴포넌트에서 이벤트를 발생할 수 있도록 이벤트에 등록
		jbtn.addActionListener(this);
		add(jbtn);
		
		setSize(300, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("is a 관계로 이벤트를 처리합니다.");
	}
	public static void main(String[] args) {

		new IsaEvent();
	}

}
