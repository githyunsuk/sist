package day0217;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;

@SuppressWarnings("serial")
public class PanelCalendar extends JPanel {
	
	public static final int NUMBER_OF_DAYS = 7;

	public PanelCalendar() {
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		Color btnForeground = new Color(0x2A5893);
		Color btnBackground = new Color(0xCBD7E9);
		
		//마지막 날의 행의 수 얻기
		Calendar cal = Calendar.getInstance(); //년-월-오늘의 정보
		//오늘 얻기
		int nowDay = cal.get(DAY_OF_MONTH);
		//마지막 날 얻기
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//오늘의 정보를 가진 달력 객체에 마지막 날을 설정
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		//마지막 날의 주의 번호
		int lastWeek = cal.get(Calendar.WEEK_OF_MONTH);
				
		//패널에 배치할 컴포넌트 선언
		JButton[][] jbtnDays = new JButton[lastWeek][NUMBER_OF_DAYS];
		
		//배치관리자 변경
		setLayout(new GridLayout(lastWeek, NUMBER_OF_DAYS));
		//배치
		//1일을 설정하고, 요일의 수 얻기
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int weekNumber = cal.get(Calendar.DAY_OF_WEEK);
		//1일 전에 공백을 생성
		Color colorBlank = new Color(0xEBF2F6);
		for(int jbtnBlank=1; jbtnBlank<weekNumber; jbtnBlank++ ) {
			jbtnDays[0][jbtnBlank-1] =new JButton("");
			jbtnDays[0][jbtnBlank-1].setBackground(colorBlank);
		}
		
		//1일부터 마지막 날까지 반복
		int rowCnt = 0;
		int columnCnt = 0;
		
		JButton jbtnTemp = null;
		for(int tempDay=1;;tempDay++) {
			//calendar에 1씩 증가하는 임시일자 설정
			cal.set(Calendar.DAY_OF_MONTH, tempDay);
			//tempDay가 2월인 경우 28이 들어가면 28이 나오는데 29가 들어가면 다음달 1일 반환
			if(cal.get(Calendar.DAY_OF_MONTH) != tempDay) {//설정된 일자와 임시 일자가 다르면
				//cal객체는 다음 달 1일로 설정.
				//빠져나가기 전에 공백을 만든다.
				for(int jbtnBlank=cal.get(Calendar.DAY_OF_WEEK); jbtnBlank < 8; jbtnBlank++) {
					jbtnTemp =new JButton("");
					jbtnTemp.setBackground(colorBlank);
					jbtnDays[rowCnt][jbtnBlank-1] = jbtnTemp;
				}
				break; //반복문 종료
			}
			//증가하는 임시번호 일자를 설정, 글자색, 바닥색 설정
			columnCnt = cal.get(Calendar.DAY_OF_WEEK);
			jbtnTemp = new JButton(String.valueOf(tempDay));
			jbtnTemp.setBackground(btnBackground);
			jbtnTemp.setForeground(btnForeground);
			if(tempDay == nowDay) {
				jbtnTemp.setBackground(new Color(0x5B7AAA));
			}
			jbtnDays[rowCnt][columnCnt-1] = jbtnTemp;
			switch(columnCnt) {
			case Calendar.SATURDAY:
				rowCnt++;
			}
		}
		
		//버튼 배열의 생성이 종료 Panel에 배치
		
		for(JButton[] jbtArr : jbtnDays) {
			for(JButton jbtn : jbtArr) {
				add(jbtn);
			}
		}
		
		
	}
}
