package smk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class LogAnalysis extends Panel {

	private JButton logAnalysisBtn;
	private JButton reportBtn;
	private JButton openFileBtn;
	private JLabel opendFileLabel;
	private JTextField lineFrom;
	private JTextField lineTo;
	
	private DefaultTableModel dtm;
	private JTable jt;
	private JScrollPane jsp;
	
	private JLabel q1Label;
	private JLabel q2Label;
	private JLabel q3Label;
	private JLabel q4Label;
	private JLabel q5Label;
	private JLabel q6Label;
	
	private JLabel a1Label; 
	private JLabel a2Label; 
	private JLabel a3Label; 
	private JLabel a4Label; 
	private JLabel a5Label; 
	private JLabel a6Label; 
	
	
	public JLabel getQ1Label() {
		return q1Label;
	}

	public JLabel getQ2Label() {
		return q2Label;
	}

	public JLabel getQ3Label() {
		return q3Label;
	}

	public JLabel getQ4Label() {
		return q4Label;
	}

	public JLabel getQ5Label() {
		return q5Label;
	}

	public JLabel getQ6Label() {
		return q6Label;
	}

	public JTable getJt() {
		return jt;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public JTextField getLineFrom() {
		return lineFrom;
	}

	public JTextField getLineTo() {
		return lineTo;
	}


	public DefaultTableModel getDtm() {
		return dtm;
	}


	public JButton getLogAnalysisBtn() {
		return logAnalysisBtn;
	}


	public JButton getReportBtn() {
		return reportBtn;
	}


	public JButton getOpenFileBtn() {
		return openFileBtn;
	}


	public JLabel getOpendFileLabel() {
		return opendFileLabel;
	}

	public JLabel getA1Label() {
		return a1Label;
	}

	public JLabel getA2Label() {
		return a2Label;
	}

	public JLabel getA3Label() {
		return a3Label;
	}

	public JLabel getA4Label() {
		return a4Label;
	}

	public JLabel getA5Label() {
		return a5Label;
	}

	public JLabel getA6Label() {
		return a6Label;
	}

	public LogAnalysis() {

//상단 버튼
		logAnalysisBtn = new JButton("로그파일 분석");
		reportBtn = new JButton("레포트 생성");
		openFileBtn = new JButton("가져오기");
		opendFileLabel = new JLabel("");
		opendFileLabel.setPreferredSize(new Dimension(1000, 30));
		opendFileLabel.setBorder(new LineBorder(Color.black));
		lineFrom = new JTextField(10);
		lineTo = new JTextField(10);
//--------------------------------------------------------
		JPanel openPanel = new JPanel();
		openPanel.add(openFileBtn);
		openPanel.add(opendFileLabel);
//--------------------------------------------------------
		JPanel lineNumText = new JPanel();
		lineNumText.add(lineFrom);
		lineNumText.add(new Label(" to "));
		lineNumText.add(lineTo);
		lineNumText.setBorder(new TitledBorder("Line 요청"));
		
		JPanel logBtnPanel = new JPanel();
		logBtnPanel.setLayout(new GridLayout(1,2));
		logBtnPanel.add(logAnalysisBtn);
		logBtnPanel.add(reportBtn);
		
		JPanel lineLogPanel = new JPanel();
		lineLogPanel.setLayout(new GridLayout(1,2));
		lineLogPanel.add(lineNumText);
		lineLogPanel.add(logBtnPanel);
//--------------------------------------------------------
		JPanel logAnalysisPanel = new JPanel();
		logAnalysisPanel.setLayout(new GridLayout(2, 1));
		logAnalysisPanel.add(openPanel);
		logAnalysisPanel.add(lineLogPanel);
//--------------------------------------------------------
		

//중앙 JTable
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new BorderLayout());
		
		//String[] columnNames = new String[0];
		//String[][] logData = new String[0][0];
		
		dtm = new DefaultTableModel();
		jt = new JTable(dtm);
		jsp = new JScrollPane(jt);
		
		centerJPanel.add(jsp, "Center");
		
		this.setLayout(new BorderLayout());
		//logAnalysisPanel.setPreferredSize(new Dimension(700, 150));
		//centerJPanel.setPreferredSize(new Dimension(700, 450));
		add(logAnalysisPanel, "North");
		add(centerJPanel, "Center");
//--------------------------------------------------------
		//South에 로그파일 분석 내용 적시
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(6,1));
		southPanel.setBorder(new TitledBorder("로그파일 분석"));
		southPanel.setPreferredSize(new Dimension(800, 300));
		
		JPanel q1Panel = new JPanel();
		q1Panel.setLayout(new GridLayout(1,2));
		q1Label = new JLabel("최다 사용키와 횟수 :", JLabel.CENTER);
		a1Label = new JLabel("", JLabel.CENTER);
		q1Panel.add(q1Label);
		q1Panel.add(a1Label);
		
		JPanel q2Panel = new JPanel();
		q2Panel.setLayout(new GridLayout(1,2));
		q2Label = new JLabel("브라우저별 접속횟수, 비율 :", JLabel.CENTER);
		a2Label = new JLabel("", JLabel.CENTER);
		q2Panel.add(q2Label);
		q2Panel.add(a2Label);
		
		
		JPanel q3Panel = new JPanel();
		q3Panel.setLayout(new GridLayout(1,2));
		q3Label = new JLabel("200응답 횟수, 404응답 횟수 :", JLabel.CENTER);
		a3Label = new JLabel("", JLabel.CENTER);
		q3Panel.add(q3Label);
		q3Panel.add(a3Label);
		
		JPanel q4Panel = new JPanel();
		q4Panel.setLayout(new GridLayout(1,2));
		q4Label = new JLabel("요청이 가장 많은 시간 :", JLabel.CENTER);
		a4Label = new JLabel("", JLabel.CENTER);
		q4Panel.add(q4Label);
		q4Panel.add(a4Label);
		
		JPanel q5Panel = new JPanel();
		q5Panel.setLayout(new GridLayout(1,2));
		q5Label = new JLabel("403응답 횟수, 비율 :", JLabel.CENTER);
		a5Label = new JLabel("", JLabel.CENTER);
		q5Panel.add(q5Label);
		q5Panel.add(a5Label);
		
		JPanel q6Panel = new JPanel();
		q6Panel.setLayout(new GridLayout(1,2));
		q6Label = new JLabel("books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 :", JLabel.CENTER);
		a6Label = new JLabel("", JLabel.CENTER);
		q6Panel.add(q6Label);
		q6Panel.add(a6Label);
		
		
		southPanel.add(q1Panel);
		southPanel.add(q2Panel);
		southPanel.add(q3Panel);
		southPanel.add(q4Panel);
		southPanel.add(q5Panel);
		southPanel.add(q6Panel);
		
		add(southPanel, "South");
//--------------------------------------------------------
//이벤트 추가
		LogAnalysisEVT lae = new LogAnalysisEVT(this);
		openFileBtn.addActionListener(lae);
		logAnalysisBtn.addActionListener(lae);
		reportBtn.addActionListener(lae);
		
	}
	
	
}
