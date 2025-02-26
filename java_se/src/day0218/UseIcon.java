package day0218;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseIcon extends JFrame {

	public UseIcon() {
		super("이미지 연습");
		
		ImageIcon ii = new ImageIcon("C:/dev/workspace/java_se/src/day0218/images/img1.png");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/java_se/src/day0218/images/img2.png");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/java_se/src/day0218/images/img3.png");
		ImageIcon ii4 = new ImageIcon("C:/dev/workspace/java_se/src/day0218/images/img4.png");
	
		JButton jbtn = new JButton("우는 차차",ii);
		JButton jbtn2 = new JButton("웃는 차차",ii2);
		JButton jbtn3 = new JButton("차차",ii3);
		JButton jbtn4 = new JButton("랄프",ii4);
		
		jbtn.setToolTipText("울고 있는 차차!");
		jbtn2.setToolTipText("웃고 있는 차차!");
		jbtn3.setToolTipText("보고 있는 차차!");
		jbtn4.setToolTipText("멍때리는 랄프");
		
		jbtn.setVerticalTextPosition(JButton.TOP);
		
		jbtn2.setHorizontalTextPosition(JButton.LEFT);
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);
		jbtn3.setHorizontalTextPosition(JButton.CENTER);
		
		jbtn3.setRolloverIcon(ii4);
		setLayout(new GridLayout(1,3));
		
		add(jbtn);
		add(jbtn2);
		add(jbtn3);
		//add(jbtn4);
		
		setBounds(200,200,1500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {

		new UseIcon();
	}

}
