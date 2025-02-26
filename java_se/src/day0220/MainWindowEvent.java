package day0220;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * MainWindow의 이벤트를 처리하기 위한 has a 관계의 클래스 
 */
public class MainWindowEvent extends WindowAdapter implements ActionListener {

	private MainWindow mw;
	
	public MainWindowEvent(MainWindow mw) {
		this.mw = mw;
	}
	
	private void windowClosing() {
		//윈도우를 종료하기 전에 처리해야할 코드(가 있다면)
		mw.dispose();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		windowClosing();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mw.getJmiSubwin()) { //다이얼로그 실행
			new SubWin(mw);
		}
		
		if(ae.getSource() == mw.getJmiClose()) { //윈도우 종료
			windowClosing();
		}
		
	}

}
