package day0214;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UseMultiLayout extends JFrame {

	public UseMultiLayout() {
		
		super("여러개의 레이아웃 사용");
		
		JTextArea jtaNameDisplay = new JTextArea();
		//JTextArea는 scrollbar가 없음. -> JScrollPane인 Container Component를 사용.
		JScrollPane jspNameDisplay = new JScrollPane(jtaNameDisplay);
		
		
		JpanelNorth jpNorth = new JpanelNorth();
		add(jpNorth, "North");
		add(jspNameDisplay, "Center");
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new UseMultiLayout();
	}

}
