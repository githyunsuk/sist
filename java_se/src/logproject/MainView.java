package logproject;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * 로그 분석과 리포트 생성을 할 수 있는 버튼이 있는 mainview 클래스 
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JTextField inputLineField;
	private JButton logAnalyzeBtn, createReportBtn;
	private LoginView lv;
	
	public MainView(LoginView lv) { //로그인뷰를 매개변수로 받음
		
		super("로그 파일 분석");
		this.lv = lv;
		setLayout(new FlowLayout());
		
		inputLineField = new JTextField(20); //원하는 라인 입력
		logAnalyzeBtn = new JButton("로그 분석");
		createReportBtn = new JButton("리포트 생성");
		
		//컴포넌트 추가
		add(inputLineField);
		add(logAnalyzeBtn);
		add(createReportBtn);
		
		//이벤트 생성
		MainViewEvt mve = new MainViewEvt(this, lv);
		addWindowListener(mve);
		logAnalyzeBtn.addActionListener(mve);
		createReportBtn.addActionListener(mve);
		
		setVisible(true);
		setBounds(100,100,600,400);
	}

	public JTextField getInputLineField() {
		return inputLineField;
	}

	public JButton getLogAnalyzeBtn() {
		return logAnalyzeBtn;
	}

	public JButton getCreateReportBtn() {
		return createReportBtn;
	}
	
}
