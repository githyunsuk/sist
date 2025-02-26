package day0214;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 흐름 레이아웃과 컴포넌트 사용. 
 */
@SuppressWarnings("serial")
public class UseFlowLayout extends JFrame {

	public UseFlowLayout() {
		super("FlowLayout");
		
		JLabel jlblName = new JLabel("이름");
		JTextField  jtfName = new JTextField(10);
		
		JRadioButton jrbMale = new JRadioButton("남자",true);
		JRadioButton jrbFemale = new JRadioButton("여자");
		
		JButton jbtnAdd = new JButton("입력");
		
		//버튼이 버튼 그룹으로 묶여져야 둘 중 하나만 선택된다.
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbMale);
		bg.add(jrbFemale);
		
		setLayout(new FlowLayout());
		
		add(jlblName);
		add(jtfName);
		add(jrbMale);
		add(jrbFemale);
		add(jbtnAdd);
		
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new UseFlowLayout();
	}

}
