package smk;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPageButtons extends JPanel { //Label은 기본 FlowLayout 

	private JButton postMember;
	private JButton login;
	private JButton getMember;
	private JButton logAnalysis;
	private JButton getCalendar;
	private JButton Board;
	
	public MainPageButtons() {
		

		//Non-Visual Component
		Font font = new Font("궁서체", Font.BOLD, 15);
		Color backgroundColor = new Color(0xecf5ce);
		Color ForegroundColor = new Color(0x8595e4);
		
		//컴포넌트 생성 
		postMember = new JButton("회원가입");
		login = new JButton("로그인");
		getMember = new JButton("회원조회");
		logAnalysis = new JButton("로그분석");
		getCalendar = new JButton("달력");
		Board = new JButton("게시판");
		
		//폰트적용
		postMember.setFont(font);
		login.setFont(font);
		getMember.setFont(font);
		logAnalysis.setFont(font);
		getCalendar.setFont(font);
		Board.setFont(font);
		
		//색적용
		postMember.setBackground(backgroundColor);
		postMember.setForeground(ForegroundColor);
		login.setBackground(backgroundColor);
		login.setForeground(ForegroundColor);
		getMember.setBackground(backgroundColor);
		getMember.setForeground(ForegroundColor);
		logAnalysis.setBackground(backgroundColor);
		logAnalysis.setForeground(ForegroundColor);
		getCalendar.setBackground(backgroundColor);
		getCalendar.setForeground(ForegroundColor);
		Board.setBackground(backgroundColor);
		Board.setForeground(ForegroundColor);
		
		//배치관리자 설정 
		this.setLayout(new GridLayout(0,3));
		
		//배치	
		add(postMember);
		add(login);
		add(getMember);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(logAnalysis);
		add(getCalendar);
		add(Board);
		
	}

	//메인화면에서 액션메서드에 쓰려고 get해야함
	public JButton getPostMember() {
		return postMember;
	}

	public JButton getLogin() {
		return login;
	}

	public JButton getGetMember() {
		return getMember;
	}

	public JButton getLogAnalysis() {
		return logAnalysis;
	}

	public JButton getGetCalendar() {
		return getCalendar;
	}

	public JButton getBoard() {
		return Board;
	}
	
	
}
