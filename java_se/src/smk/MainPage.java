package smk;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *	프로그램 첫 화면
 *	회원가입, 로그인, 계산기, 달력(당일식당메뉴 등록,수정,조회), 간단한댓글 게시판(등록,삭제,조회)
 *	
 *	JFrame을 상속한 메인 프레임에서 CardLayout을 사용하여 화면 전환을 관리하고, 
 *	각각의 화면을 JPanel을 상속한 클래스로 화면 전환
 *	즉, JFrame이 메인 창, CardLayout이 화면 전환 담당, JPanel이 각 화면을 담당! 
 *
 *	Frame은 동시에 한개의 Layout만 set이 가능해요. 그래서 존재하는게 JPanel 이지요.
 *	근데, JPanel은 FlowLayout이 기본 셋팅이라서, setLayout으로 GridLayout을 설정하든지 해서 커스텀해줘야 해요. 
 */
@SuppressWarnings("serial")
public class MainPage extends JFrame { 
	private MainPageCenterPanel mainPageCenterPanel;
	
	public static String LOGINUSER;
	
	public MainPage() {

		//컴포넌트 모음 (North)
		MainPageButtons mPButtons = new MainPageButtons();
		add(mPButtons, "North");
		
		//메뉴바를 윈도우 컴포넌트(JFrame)에 설정 
		setJMenuBar(new MenuUI(this).getJmb());
		
		// 배경화면 등록 (Center)
		mainPageCenterPanel = new MainPageCenterPanel();
		add(mainPageCenterPanel, "Center");
		
        //버튼 클릭 시 화면변경 액션 
		mPButtons.getPostMember().addActionListener(e -> mainPageCenterPanel.showPanel("SIGNUP")); //showPanel(panel명) 호출 
		mPButtons.getLogin().addActionListener(e -> mainPageCenterPanel.showPanel("LOGIN"));
		mPButtons.getGetMember().addActionListener(e -> mainPageCenterPanel.showPanel("GETMEMBER"));
		mPButtons.getLogAnalysis().addActionListener(e -> mainPageCenterPanel.showPanel("LOGANALYSIS"));
		mPButtons.getGetCalendar().addActionListener(e -> mainPageCenterPanel.showPanel("CALENDAR"));
		mPButtons.getBoard().addActionListener(e -> mainPageCenterPanel.showPanel("BOARD"));

	    // 날짜,시간정보 (South)
	    LocalDateTime localDateTime = LocalDateTime.now();
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd [EEE] hh:mm:ss [a]", Locale.US);
	    String timeNow = localDateTime.format(dtf);
	    
	    JLabel timeLabel = new JLabel(timeNow, JLabel.CENTER); //가운데정렬 옵션 
	    timeLabel.setFont(new Font("Arial", Font.ITALIC, 16)); //폰트수정	
	    //timeLabel.setHorizontalAlignment(SwingConstants.CENTER); //가운데정렬 
	    
	    add(timeLabel, "South");
	    
	    //시간 실시간 출력 (swing.timer)
	    Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDateTime now = LocalDateTime.now();
				String realTime = now.format(dtf);
				
				timeLabel.setText(realTime);
			}
		});
	    timer.start();
	    
	    //프레임 크기 설정
		setBounds(400,10,1200,1020);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//----------------------------------------------------------------------------------------------------------
		
	public static void main(String[] args) {
		new MainPage();
		new LoginEVT().saveTempMember(); //임시 회원 3명 등록, 로그인기능을 구현하기위함 
	}

	
}

/**
 * setLayout의 종류에따라, add된 컴포넌트들의 배치 위치가 달라짐
 * 
 * setLayout(new BoerderLayout()) : 바깥 테두리 기본레이아웃, 생략가능
 * 	add(컴포넌트객체, South||North||West||East )
 * setLayout(new FolowLayout()) : 컴포넌트가 고유 크기를 가지며 왼쪽->오른쪽 순으로 배치
 * 	add(컴포넌트객체)
 * setLayout(new GridLayout(m,n)) : 행, 열을 가지는 레이아웃. 행,열에 맞춰 정렬된다. 컴포넌트가 고유 크기를 잃고, 모두 일정한 크기를 갖게된다.
 *  add(컴포넌트객체)
 *  
 * JPanel 클래스 상속하여, 여러 컴포넌트를 묶어 객체 생성하고, 그 객체를 레이아웃 할 수도 있음 
 * 
 * 컴포넌트 종류: 
 * 	JLabel
 * 	JButton
 * 	JTextArea (scrollbar 있음)
 * 	JTextField (scrollbar 없음, 한줄짜리 텍스트이니까.. )
 * 	JRadioButton ("", true)
 * 	ButtonGroup
 * 		- buttonGroup.add(JRadioButton객체);
 * 	JScrollPane(JTextArea 객체)
 * 	JPasswordField 
 * 	JComboBox<E>()
 * 		- jComboBox.addItem("");
 * 		
 *  //4. 윈도우의 크기 설정(사용자UI)
 *	setSize(400,400);
 *	//5. 윈도우를 보여주기 위한 설정 
 *	setVisible(true);
 *	//6. 윈도우 종료처리 (x버튼 눌렀을때, 인스턴스 소멸되게)
 *	setDefaultCloseOperation(EXIT_ON_CLOSE);
 *
 *
 *	//------------------------ 2월 17일 배움 ---------------------------------
 *	폰트, 색 설정
 *	Font 클래스
 *	Color 클래스
 *
 *	메뉴
 *	JMenuBar
 *	JMenu
 *	JMenuItem
 *		- jmenuBar.add(jmenu);	//메뉴를 메뉴바에 배치 (메뉴바는 사용자에게 제공할 모든 메뉴를 가진다)
 *		- jmenu.add(jmenuItem); //메뉴아이템을 메뉴에 배치
 *	
 *	메뉴바를 Frame설정
 *		- setJMenuBar(jmenuBar); //setJMenuBar로 JFrame에 설치 
 *
 *
 *	Border
 *	- 컴포넌트들을 묶어서 보여줄 때 
 *	- javax.swing.border 패키지에서 Border클래스 제공 
 *	- 
 *
 *
 *
 *
 */
