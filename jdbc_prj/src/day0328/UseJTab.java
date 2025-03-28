package day0328;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {

	public UseJTab() {
		super("탭");
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("상품", new ProductPane());
		jtp.addTab("추천", new RecomPane());
		jtp.addTab("회원정보", new ProductPane());
		
		add("Center",jtp);
		setBounds(100,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(ABORT);
	}
}
