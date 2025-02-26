package logproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 메인뷰의 이벤트를 처리하는 클래스
 */
public class MainViewEvt extends WindowAdapter implements ActionListener {

	private MainView mv;
	private LoginView lv;
	
	public MainViewEvt(MainView mv, LoginView lv) {
		this.mv = mv;
		this.lv = lv;
	}

	public void logAnalyze() {
		//로그 분석 이벤트 클래스 생성
		try {
			new logAnalyzeEvt(mv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createReport() {
		//리포트 생성 클래스
		String id = lv.getIdField().getText();
		if(id.equals("root")) { //만약 아이디가 root면 실행 거부 후 return
			JOptionPane.showMessageDialog(mv, "권한이 없습니다.");
			return;
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		//윈도우 종료
		mv.dispose();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		//로그파일 분석 버튼을 누르면
		if(ae.getSource() == mv.getLogAnalyzeBtn()) {
			logAnalyze();
		}
		//리포트 생성 버튼을 누르면
		if(ae.getSource() == mv.getCreateReportBtn()) {
			createReport();
		}
	}
}
