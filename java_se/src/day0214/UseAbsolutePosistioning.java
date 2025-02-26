package day0214;

import javax.swing.*;

@SuppressWarnings("serial")
public class UseAbsolutePosistioning extends JFrame {

	public UseAbsolutePosistioning() {
		super("수동배치");
		
		JButton jbtn = new JButton("나는 버튼");
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Java SE");
		jcb.addItem("oracle dbms");
		jcb.addItem("Jdbc");
		jcb.addItem("html");
		jcb.addItem("css");
		jcb.addItem("Javascript");
		
		JPasswordField jpf = new JPasswordField();
		
		//배치관리자를 해제
		setLayout(null);
		
		//컴포넌트의 크기 설정
		jbtn.setSize(200,80);
		
		//컴포넌트의 위치 설정
		jbtn.setLocation(100,50);
		jcb.setBounds(300,200,250,60);
		jpf.setBounds(470,350,180,50);
		
		//배치
		add(jbtn);
		add(jcb);
		add(jpf);
		
		//setLocation(100,200);
		//setSize(800,600);
		setBounds(100,50,800,600);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {

		new UseAbsolutePosistioning();
	}

}
