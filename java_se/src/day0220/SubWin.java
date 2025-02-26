package day0220;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MainWindow를 부모로 하는 SubWindow(Dialog: 부가적인 서비스 제공)
 */
@SuppressWarnings("serial")
public class SubWin extends JDialog {
	
	public SubWin(MainWindow mw) {
		//super(mw, "다이얼로그", true); true - 모달
		super(mw, "다이얼로그", false); //false - 비모달
		
		//컴포넌트를 생성
		ImageIcon imgMain = new ImageIcon("C://dev//workspace//java_se//src//day0218//images//img4.png");
		JLabel jlbl = new JLabel(imgMain);
		
		JPanel jpSouth = new JPanel();
		JButton jbtnClose = new JButton("닫기");
		
		jpSouth.add(jbtnClose);
		add("Center",jlbl);
		add("South",jpSouth);
		
		SubWinEvent swe = new SubWinEvent(this);
		addWindowListener(swe);
		jbtnClose.addActionListener(swe);
		
		setBounds(mw.getX()+300,mw.getY()+300,300,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
