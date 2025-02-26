package day0220;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JMenuItem jmiSubwin;
	private JMenuItem jmiClose;
	
	public MainWindow() {
		super("다이얼로그 연습");
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmDialog = new JMenu("다이얼로그");
		
		jmiSubwin = new JMenuItem("다이얼로그 열기");
		jmiClose = new JMenuItem("닫기");
		
		//메뉴 아이템을 메뉴에 배치
		jmDialog.add(jmiSubwin);
		jmDialog.addSeparator();
		jmDialog.add(jmiClose);
		
		//메뉴 메뉴바 배치
		jmb.add(jmDialog);
		
		//메뉴바를 프레임에 배치
		setJMenuBar(jmb);
		
		//이벤트 등록
		MainWindowEvent mwe = new MainWindowEvent(this);
		addWindowListener(mwe);
		jmiSubwin.addActionListener(mwe);
		jmiClose.addActionListener(mwe);
		
		setVisible(true);
		setBounds(10,10,1000,1000);
	}

	public JMenuItem getJmiSubwin() {
		return jmiSubwin;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}
	
}
