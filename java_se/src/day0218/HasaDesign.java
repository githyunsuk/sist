package day0218;


import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * is a 관계로 window component 사용 
 */
//1. 윈도우 컴포넌트를 상속
//1. 발생된 Event를 처리할 수 있는 xxxListener 구현.
public class HasaDesign extends JFrame {
	public HasaDesign() {
		super("is a 관계로 window component 사용");
		
		//2.일반 컴포넌트 생성
		JButton jbtn = new JButton("클릭해봐");
		//디자인 클래스와 이벤트 처리 클래스의 관계를 설정.
		HasaEvent hae = new HasaEvent(this);
		
		//3.컴포넌트에서 이벤트를 발생할 수 있도록 이벤트에 등록하고, 이벤트가
		//발생했을 때 처리할 곳을 기술한다.
		jbtn.addActionListener(hae);
		add(jbtn);
		
		setSize(300, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {

		new HasaDesign();
	}

}
