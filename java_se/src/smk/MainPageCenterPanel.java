package smk;

import java.awt.CardLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPageCenterPanel extends JPanel {

	private CardLayout cardLayout;
	private JPanel mainPanel ,signUpPanel, loginPanel, getMemberPanel, logAnalysisPanel, calendarPanel, BoardPanel;
	
	public MainPageCenterPanel() {
		
		cardLayout = new CardLayout(); // JPanel레이아웃(기본값: FlowLayout) -> CardLayout() 
		setLayout(cardLayout);
		
		//메인 배경화면 
		mainPanel = new JPanel();
		URL imageUrl = getClass().getResource("espa.jpg");
		
	    if (imageUrl != null) {
	    	//이미지 크기 수정함 
	    	ImageIcon originalIcon = new ImageIcon(imageUrl);
	    	Image modifyImage = originalIcon.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH);
	    	ImageIcon resizedIcon = new ImageIcon(modifyImage);
	    	
            JLabel jlabel = new JLabel(resizedIcon);
            jlabel.setToolTipText("에스파입니다");
            mainPanel.add(jlabel);
        } else {
            System.out.println("이미지 파일 없음 ");
        }
	    
		//회원가입
		signUpPanel = new JPanel();
		signUpPanel.add(new JLabel("회원가입 화면입니다."));
		
		//로그인 
		loginPanel = new JPanel();
		LoginPage loginPage = new LoginPage();
		loginPanel.add(loginPage);
		
		//멤버조회 
		getMemberPanel = new JPanel();
		getMemberPanel.add(new JLabel("멤버조회 화면입니다."));
		
		//로그분석
		logAnalysisPanel = new JPanel();
		LogAnalysis logAnalysis = new LogAnalysis();
		logAnalysisPanel.add(logAnalysis);
		
		
		//달력
		calendarPanel = new JPanel();
		CalendarMain clmain = new CalendarMain();
		calendarPanel.add(clmain); //JFrame을 JPanel에 추가하려고 하면 오류발생 
		
		//게시판 
		BoardPanel = new JPanel();
		Board_JTable board = new Board_JTable();
		BoardPanel.add(board);
		
		//cardLayout에 add중 
		add(mainPanel, "MAIN");
		add(signUpPanel, "SIGNUP");
		add(loginPanel, "LOGIN");
		add(getMemberPanel, "GETMEMBER");
		add(logAnalysisPanel, "LOGANALYSIS");
		add(calendarPanel, "CALENDAR");
		add(BoardPanel, "BOARD");
		
		cardLayout.show(this, "MAIN");
		
	}
	
	public void showPanel(String panelName) {
		cardLayout.show(this, panelName);
	}
	
}
