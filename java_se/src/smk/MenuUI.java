package smk;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuUI extends JPanel {
	
	private MainPage mp;
	
	private JMenuBar jmb;

	private JMenuItem jmiNew; //파일 > 새글 
	private JMenuItem jmiOpen; //파일 >
	private JMenuItem jmiSave;  // 파일 >
	private JMenuItem jmiNewSave; //파일 >
	private JMenuItem jmiClose;  //파일 >
	
	private JMenuItem jmiFont; //편집 > 글꼴
	
	private JMenuItem jmiMenuInfo; //도움말 > 메뉴장정보 
	
	public JMenuBar getJmb() {
		return jmb;
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
	public JMenuItem getJmiNewSave() {
		return jmiNewSave;
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

	public MainPage getMp() {
		return mp;
	}
	public MenuUI(MainPage mp) {
		this.mp = mp;
		jmb = new JMenuBar();
		
		//메뉴 생성 n개 
		JMenu jmFile = new JMenu("파일"); //파일 = {새글, 열기, 저장, 새이름으로 저장, 닫기}
		JMenu jmEdit = new JMenu("편집"); //편집 = {글꼴}
		JMenu jmHelp = new JMenu("도움말"); //도움말 = {메모장 정보}
		//메뉴 아이템 생성
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiNewSave = new JMenuItem("새이름으로 저장");
		jmiClose = new JMenuItem("닫기");
		
		jmiFont = new JMenuItem("글꼴");
		
		jmiMenuInfo = new JMenuItem("메모장 정보");
		
//컴포넌트 배치
		//메뉴 아이템 메뉴 배치
		jmFile.add(jmiNew);
		jmFile.addSeparator(); //메뉴아이템 구분하기 위한 선 추가 
		jmFile.add(jmiOpen);
		jmFile.addSeparator();
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiNewSave);
		jmFile.addSeparator();
		jmFile.add(jmiClose);

		jmEdit.add(jmiFont);
		
		jmHelp.add(jmiMenuInfo);
		
//메뉴를 메뉴바에 배치
		jmb.add(jmFile);
		jmb.add(jmEdit);
		jmb.add(jmHelp);
		
//이벤트 배치
		MenuEVT menuEVT  = new MenuEVT(this);
		jmiNew.addActionListener(menuEVT);
		jmiOpen.addActionListener(menuEVT);
		jmiSave.addActionListener(menuEVT);
		jmiNewSave.addActionListener(menuEVT);
		jmiClose.addActionListener(menuEVT);
		

	}
}
