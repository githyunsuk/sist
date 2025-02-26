package day0218;

import javax.swing.*;

@SuppressWarnings("serial")
public class UseJList extends JFrame {

	public UseJList() {
		super("JList 사용");
		
		//1.모델 생성
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		//2.모델과 has a 관계로 view를 생성
		JList<String> jl = new JList<String>(dlm);
		
		//JList는 scrollbar가 없음
		JScrollPane jsp = new JScrollPane(jl);
		
		//데이터 추가: 모델
		dlm.addElement("java se");
		dlm.addElement("oracle dbms");
		dlm.addElement("jdbc");
		dlm.addElement("html5");
		dlm.addElement("javascript");
		dlm.addElement("css6");
		dlm.addElement("java ee");
		
		add("North", new JLabel("학습 과목들"));
		add("Center", jsp);
		
		setBounds(100,100,300,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UseJList();
		new UseJTable();
	}

}
