package logproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 메인뷰의 이벤트를 처리하는 클래스
 */
public class MainViewEvt extends WindowAdapter implements ActionListener {

	private MainView mv;
	private LoginView lv;
	private LogAnalyzeEvt lae;
	
	private File logFile;
	private ArrayList<LogVO> lvoList;
	
	private StringTokenizer stk;
	private String[] strArr;
	
	public MainViewEvt(MainView mv, LoginView lv) {
		this.mv = mv;
		this.lv = lv;
	}

	//파일 불러오기 method
	public void openFile() throws IOException {
		
		//기존 불러왔던 파일이 남아있을 수 있으니 테이블과 openFileLbl, inputLine 초기화
		mv.getDtm().setRowCount(0);
		mv.getOpenFileLbl().setText("");
		mv.getInputLineFrom().setText("");
		mv.getInputLineTo().setText("");
		lvoList = new ArrayList<LogVO>(); //LogVO 객체 배열 초기화 - 파일 불러올 때 마다 배열이 초기화 되어야함
		
		JFileChooser jfc = new JFileChooser("c:/dev");
		jfc.showOpenDialog(mv);
		logFile = jfc.getSelectedFile();

		if (logFile == null || !logFile.exists()) {
			JOptionPane.showMessageDialog(mv, "파일이 존재하지 않습니다");
		    return;  
		}
		
		//try ~ with ~ resources
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(logFile)))) {
	        String msg;
	        int startLine = 0;
	        while ((msg = br.readLine()) != null) {
	            lvoList.add(new LogVO(msg)); //LogVO 배열에 모든 문자열을 저장
	            setLogTable(startLine++, msg); //범위 입력 전 우선 모든 내용을 테이블에 띄움
	        }
	    }
		mv.getOpenFileLbl().setText(logFile.getAbsolutePath()); //불러온 파일명을 파일라벨에 띄움
	}
	
	//로그 분석 이벤트 클래스 생성
	public void logAnalyze() {
		if(logFile == null) { //파일을 아직 불러오지 않았으면
			JOptionPane.showMessageDialog(mv, "파일을 먼저 불러와주세요");
			return;
		}
		
		try {
			lae = new LogAnalyzeEvt(mv, this, lvoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//로그 테이블을 채우는 method(LogAnalyzeEvt에서 재사용)
	public void setLogTable(int startLine, String line) {
		int i = 0;
		stk = new StringTokenizer(line, "[]");
		strArr = new String[stk.countTokens()];
		while(stk.hasMoreTokens()) {
			strArr[i++] = stk.nextToken();
		}
		
		String[] newData = {String.valueOf(startLine + 1), strArr[0], strArr[1], strArr[2], strArr[3]};
		mv.getDtm().addRow(newData);
	}
	
	//리포트 생성 클래스
	public void generateReport() {
		String id = lv.getIdField().getText();
		if(id.equals("root")) { //만약 아이디가 root면 실행 거부 후 return
			JOptionPane.showMessageDialog(mv, "권한이 없습니다.");
			return;
		}
		
		//로그 파일을 안누르고 리포트 버튼을 누룰시
		if( lae == null) {
			JOptionPane.showMessageDialog(mv,"우선 로그 분석을 완료하세요");
			return;
		}
		
		//로그 분석을 완료한 객체를 넘겨주고 GenerateReportEvt 클래스 생성
		try {
			new GenerateReportEvt(mv, lae, logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//윈도우 종료
	@Override
	public void windowClosing(WindowEvent we) {
		mv.dispose();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		//불러오기 버튼을 누르면
		if(ae.getSource() == mv.getOpenFileBtn()){
			try {
				openFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//로그파일 분석 버튼을 누르면
		if(ae.getSource() == mv.getLogAnalyzeBtn()) {
			logAnalyze();
		}
		
		//리포트 생성 버튼을 누르면
		if(ae.getSource() == mv.getGenerateReportBtn()) {
			generateReport();
		}
		
		//로그아웃 버튼을 누르면
		if(ae.getSource() == mv.getLogoutBtn()) {
			mv.dispose();
			new LoginView();
		}
	}
}
