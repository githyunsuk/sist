package day0214;

import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Exam0214 extends JFrame{

	public Exam0214() {
		
		super("달력");
		
		LocalDate date = LocalDate.of(2025, 2, 1);

		int firstDay = date.getDayOfWeek().getValue();
		int lastDate = date.lengthOfMonth();
		
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(0,7)); //0은 행의 수가 자동 조덩
		
		for (int i = 0; i < firstDay; i++) {
            jpCenter.add(new JButton());  // 시작 요일에 맞춰 공백 버튼 추가
        }
		
		for(int i=1; i<=lastDate; i++) { //날짜 버튼 추가
			jpCenter.add(new JButton(String.valueOf(i)));
		}
		
		add("Center",jpCenter);
		
		setSize(600, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Exam0214();
	}

}
