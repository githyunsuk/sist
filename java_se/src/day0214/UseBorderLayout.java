package day0214;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * BorderLayout(테두리레이아웃) 매니저와 Component의 모양 
 */
@SuppressWarnings("serial")
//1.Window Component를 상속
public class UseBorderLayout extends JFrame {

	public UseBorderLayout() {
		super("BorderLayout 연습"); //Frame의 생성자 호출: 타이틀 바에 들어갈 메시지
		
		//2.컴포넌트 생성
		JLabel jlblNorth = new JLabel("북쪽");
		JLabel jlblSouth = new JLabel("남쪽");
		
		JButton jbtnWest = new JButton("서쪽");
		JButton jbtnEast = new JButton("동쪽");
		
		JTextArea jtaCenter = new JTextArea("가운데");
		//3.컴포넌트 배치
		//배치관리자를 설정(윈도우 분할하는 설정)
		
		setLayout(new BorderLayout()); //기본 레이아웃이므로 생략 가능
		//Constant 사용
		add(jlblNorth, BorderLayout.NORTH);
	
		add(jbtnWest, BorderLayout.WEST);
		add(jtaCenter, BorderLayout.CENTER);
		//문자열 상수 사용
//		add(jlblSouth,"south");
//		add(jbtnEast,"East");
		//4.윈도우의 크기 설정
		setSize(400,400);
		
		//5.윈도우를 보여주기 위한 설정.
		setVisible(true);
		
		//6.윈도우 종료 처리(x 버튼을 눌렀을 때 instance 소멸)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new UseBorderLayout();
	}

}
