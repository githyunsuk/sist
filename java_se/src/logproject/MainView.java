package logproject;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 로그 분석과 리포트 생성을 할 수 있는 버튼이 있는 mainview 클래스 
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JTextField inputLineFieldA, inputLineFieldB;
	private JButton logAnalyzeBtn, createReportBtn;
	private JTextArea jta;
	private LoginView lv;
	
	public MainView(LoginView lv) { //로그인뷰를 매개변수로 받음
		
		super("로그 파일 분석");
		this.lv = lv;
		setLayout(new BorderLayout());
		
		inputLineFieldA = new JTextField(10); //원하는 라인 입력
		inputLineFieldB = new JTextField(10); //원하는 라인 입력
		logAnalyzeBtn = new JButton("로그 분석");
		createReportBtn = new JButton("리포트 생성");
		
		jta = new JTextArea(60, 80);
		jta.setFont(new Font("궁서체", Font.ITALIC, 24));
		JScrollPane jsp = new JScrollPane(jta);
		
		//컴포넌트 추가
		JPanel topPanel = new JPanel();
		topPanel.add(inputLineFieldA);
		topPanel.add(inputLineFieldB);
		topPanel.add(logAnalyzeBtn);
		topPanel.add(createReportBtn);
	
		add(topPanel, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		//이벤트 생성
		MainViewEvt mve = new MainViewEvt(this, lv);
		addWindowListener(mve);
		logAnalyzeBtn.addActionListener(mve);
		createReportBtn.addActionListener(mve);
		
		setVisible(true);
		setBounds(100,100,800,600);
	}

	
	public JTextField getInputLineFieldA() {
		return inputLineFieldA;
	}


	public JTextField getInputLineFieldB() {
		return inputLineFieldB;
	}


	public JButton getLogAnalyzeBtn() {
		return logAnalyzeBtn;
	}

	public JButton getCreateReportBtn() {
		return createReportBtn;
	}

	public JTextArea getJta() {
		return jta;
	}

	public LoginView getLv() {
		return lv;
	}
	
}
