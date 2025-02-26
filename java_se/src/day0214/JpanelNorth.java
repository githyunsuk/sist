package day0214;

import javax.swing.*;

@SuppressWarnings("serial")
public class JpanelNorth extends JPanel {

	public JpanelNorth() {
		
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(15);
		JButton jbtnAdd = new JButton("입력");
		
		add(jlblName);
		add(jtfName);
		add(jbtnAdd);
		
	}
	
}
