package logproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

/**
 * 로그 분석과 리포트 생성을 할 수 있는 버튼이 있는 mainview 클래스
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JTextField inputLineFrom, inputLineTo;
	private JButton logAnalyzeBtn, generateReportBtn, openFileBtn, logoutBtn;

	private JLabel openFileLbl, nameLbl;
	private JLabel[] questionLbl = new JLabel[6];
	private JLabel[] answerLbl = new JLabel[6];

	private DefaultTableModel dtm;
	private JTable jt;
	private JScrollPane jsp;

	private LoginView lv;

	public MainView(LoginView lv) { // 로그인뷰를 매개변수로 받음

		super("로그 파일 분석");
		this.lv = lv;

//------------------------상단 설정---------------------------
		logAnalyzeBtn = new JButton("로그파일 분석");
		generateReportBtn = new JButton("레포트 생성");

		nameLbl = new JLabel(lv.getIdField().getText() + "님 안녕하세요?");
		logoutBtn = new JButton("로그아웃");
		openFileBtn = new JButton("불러오기");
		openFileLbl = new JLabel("");
		openFileLbl.setPreferredSize(new Dimension(700, 30));
		openFileLbl.setBorder(new LineBorder(Color.black));

		inputLineFrom = new JTextField(10); // 원하는 라인 입력
		inputLineTo = new JTextField(10); // 원하는 라인 입력

		// 파일 불러오기 및 정보, 로그아웃 라벨
		JPanel topPanel = new JPanel();
		topPanel.add(nameLbl);
		topPanel.add(logoutBtn);
		topPanel.add(openFileLbl);
		topPanel.add(openFileBtn);

		// 라인 요청 라벨
		JPanel lineNumText = new JPanel();
		lineNumText.add(inputLineFrom);
		lineNumText.add(new Label(" to "));
		lineNumText.add(inputLineTo);
		lineNumText.setBorder(new TitledBorder("Line 입력"));

		// 로그분석 & 레포트 생성 버튼 라벨
		JPanel logBtnPanel = new JPanel();
		logBtnPanel.setLayout(new GridLayout(1, 2));
		logBtnPanel.add(logAnalyzeBtn);
		logBtnPanel.add(generateReportBtn);

		// 라인 요청 라벨과 로그&레포트 라벨 합치기
		JPanel lineLogPanel = new JPanel();
		lineLogPanel.setLayout(new GridLayout(1, 2));
		lineLogPanel.add(lineNumText);
		lineLogPanel.add(logBtnPanel);

		// 상단 패널 합치기
		JPanel logAnalysisPanel = new JPanel();
		logAnalysisPanel.setLayout(new GridLayout(2, 1));
		logAnalysisPanel.add(topPanel);
		logAnalysisPanel.add(lineLogPanel);

		add(logAnalysisPanel, "North");

//------------------------중앙 설정-------------------------------

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());

		dtm = new DefaultTableModel();
		jt = new JTable(dtm);
		jsp = new JScrollPane(jt);

		String[] columnNames = { "Index", "응답코드", "URL", "Browser", "Time" };
		dtm.setColumnIdentifiers(columnNames);

//		jta = new JTextArea(60, 80);
//		//스크롤바가 자동으로 밑으로 안내려가게 설정(원리는 모르지만 구글에 검색하니 나왔음...)
//		DefaultCaret caret = (DefaultCaret)jta.getCaret();
//		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
//		jsp = new JScrollPane(jta);

		centerPanel.add(jsp, "Center");

		add(centerPanel, "Center");

//----------------------하단 설정----------------------------------		

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(6, 1));
		southPanel.setBorder(new TitledBorder("분석 결과"));
		southPanel.setPreferredSize(new Dimension(800, 300));

		String[] questionTexts = { "최다 사용키와 횟수:", "브라우저별 접속 횟수, 비율:", "200응답 횟수, 404응답 횟수:", "요청이 가장 많은 시간:",
				"403응답 횟수, 비율:", "books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율:" };

		for (int i = 0; i < 6; i++) {
			questionLbl[i] = new JLabel(questionTexts[i], JLabel.CENTER);
			answerLbl[i] = new JLabel("", JLabel.CENTER);
			JPanel panel = new JPanel(new GridLayout(1, 2));
			panel.add(questionLbl[i]);
			panel.add(answerLbl[i]);
			southPanel.add(panel);
		}

		add(southPanel, "South");

		// 이벤트 생성
		MainViewEvt mve = new MainViewEvt(this, lv);
		addWindowListener(mve);

		openFileBtn.addActionListener(mve);
		logAnalyzeBtn.addActionListener(mve);
		generateReportBtn.addActionListener(mve);
		logoutBtn.addActionListener(mve);

		// 화면 설정
		setVisible(true);
		setBounds(400, 10, 1200, 1020);
	}

	public JTextField getInputLineFrom() {
		return inputLineFrom;
	}

	public JTextField getInputLineTo() {
		return inputLineTo;
	}

	public JButton getLogAnalyzeBtn() {
		return logAnalyzeBtn;
	}

	public JButton getGenerateReportBtn() {
		return generateReportBtn;
	}

	public JButton getOpenFileBtn() {
		return openFileBtn;
	}

	public JButton getLogoutBtn() {
		return logoutBtn;
	}

	public JLabel getOpenFileLbl() {
		return openFileLbl;
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public JLabel[] getQuestionLbl() {
		return questionLbl;
	}

	public JLabel[] getAnswerLbl() {
		return answerLbl;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JTable getJt() {
		return jt;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public LoginView getLv() {
		return lv;
	}

}
