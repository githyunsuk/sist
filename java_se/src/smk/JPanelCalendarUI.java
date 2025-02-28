package smk;

import java.awt.GridLayout;
import java.awt.Label;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelCalendarUI extends JPanel {

	private int month;
	//달력 생성
	public JPanelCalendarUI(int month) {
		this.month = month;
		
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		JButton jButton = new JButton();
		
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = cal.get(Calendar.DAY_OF_WEEK); // 시작 요일 (1: 일요일, 2: 월요일 ... 7: 토요일)
		
		String[] weeks = "일,월,화,수,목,금,토".split(","); //일~토요일 변수 배열 
		//JButton[] daysButton = new JButton[lastDay]; // 해당 월의 최대일(갯수)만큼의 JButton 배열 용량 설정 
		//JButton[] weekButton = new JButton[weeks.length]; //일~토 버튼 
        
        // GridLayout 설정 (7열, 행 자동 증가) -> GridBagLayout 사용도 고려해, Java Swing에서 제일 유연한 레이아웃 매니저 중 하나야 
        setLayout(new GridLayout(0, 7));
		
        //요일 레이블 추가
        for (String week : weeks) {
            add(new JLabel(week, JLabel.CENTER));
        }
		
		//1일 전까지 빈칸 대입
        for(int i = 1; i < startDay; i++) {
        	add(new JLabel(""));
        }
		
        // 날짜 버튼 추가
        for (int i = 1; i <= lastDay; i++) {
            add(new JButton(String.valueOf(i)));
        }
		
		
	}
	
	
	
}
