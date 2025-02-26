package day0221;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MemoDesign extends JFrame {

	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiClose, jmiFont, jmiMenuInfo;
	
	private JTextArea jtaMemo;
	private JScrollPane jspJtaMemo;
	
	public MemoDesign() {
		super("메모장");
	
		JMenuBar jmb = new JMenuBar();
		JMenu menuFile = new JMenu("파일");
		JMenu menuForm = new JMenu("서식");
		JMenu menuInfo = new JMenu("도움말");
		
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiClose = new JMenuItem("종료");
		jmiFont = new JMenuItem("글꼴");
		jmiMenuInfo = new JMenuItem("메모장 정보");
		
		menuFile.add(jmiNew);
		menuFile.addSeparator();
		menuFile.add(jmiOpen);
		menuFile.add(jmiSave);
		menuFile.addSeparator();
		menuFile.add(jmiClose);
		
		menuForm.add(jmiFont);
		menuInfo.add(jmiMenuInfo);
		
		jmb.add(menuFile);
		jmb.add(menuForm);
		jmb.add(menuInfo);
		
		setJMenuBar(jmb);
		
		jtaMemo = new JTextArea();
		jspJtaMemo = new JScrollPane(jtaMemo);
		add(jspJtaMemo);
		
		MemoDesignEvt mde = new MemoDesignEvt(this);
		addWindowListener(mde);
		jmiNew.addActionListener(mde);
		jmiOpen.addActionListener(mde);
		jmiSave.addActionListener(mde);
		jmiClose.addActionListener(mde);
		jmiFont.addActionListener(mde);
		jmiMenuInfo.addActionListener(mde);
		
		setVisible(true);
		setBounds(10,10,1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiMenuInfo() {
		return jmiMenuInfo;
	}

	public JTextArea getJtaMemo() {
		return jtaMemo;
	}

	public JScrollPane getJspJtaMemo() {
		return jspJtaMemo;
	}
	
	
}
