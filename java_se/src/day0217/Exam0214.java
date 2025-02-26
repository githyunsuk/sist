package day0217;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Exam0214 extends JFrame {

	public Exam0214() {
		super("자바 달력");
		
		Calendar cal = Calendar.getInstance();
		StringBuilder calTitle = new StringBuilder();
		calTitle.append(cal.get(Calendar.YEAR)).append("-")
		.append(cal.get(Calendar.MONTH)+1).append("-")
		.append(cal.get(Calendar.DAY_OF_MONTH));
		//컴포넌트 생성
		JLabel jlblCalendar = new JLabel(calTitle.toString(),JLabel.CENTER);
		
		PanelCalendar pc = new PanelCalendar();
		
		jlblCalendar.setFont(new Font("맑은 고딕",Font.BOLD, 25));
		
		//배치관리자 설정
		add(jlblCalendar,BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		//배치
		
		//크기 설정
		setBounds(100,50,550,500);
		//가시화
		setVisible(true);
		//종료처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		new Exam0214();
	}

}
