package day0218;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Exam0218 extends JFrame implements ActionListener {
	
	private JRadioButton male;
	private JRadioButton female;
	private JButton input;
	private JTextArea jta;
	
	public Exam0218() {
		male = new JRadioButton("남자");
		female = new JRadioButton("여자");
		input = new JButton("입력");
		jta = new JTextArea(5, 20);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(male);
	    group.add(female);
	    
	    JPanel jp = new JPanel();
		
		jp.add(male);
		jp.add(female);
		jp.add(input);
		add("North",jp);
		add("Center",new JScrollPane(jta));
		
		input.addActionListener(this);
		
		setBounds(100, 100, 500 ,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(male.isSelected()) {
			jta.append(male.getText() + "\n");
		}else if(female.isSelected()) {
			jta.append(female.getText() + "\n");
		}
	}

	public static void main(String[] args) {

		new Exam0218();
	}

}
