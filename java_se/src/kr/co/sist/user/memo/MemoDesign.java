package kr.co.sist.user.memo;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MemoDesign extends JFrame {

	//이벤트 발생시 비교해야할 컴포넌트는 class field에 선언
	private JMenuItem jmiNew; //파일 > 새글
	private JMenuItem jmiOpen; //파일 > 열기
	private JMenuItem jmiSave; //파일 > 저장
	private JMenuItem jmiNewSave; //파일 >새이름으로 저장
	private JMenuItem jmiClose; //파일 > 닫기 
	private JMenuItem jmiFont; //편집 > 글꼴
	private JMenuItem jmiMemoInfo; //도움말 > 메모장 정보
	
	private JTextArea jtaMemo; //글을 쓰기 위한 JTextArea
	
	public MemoDesign() {
		super("메모장 - 제목없음");
		
		//컴포넌트 선언 생성

		//메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		//메뉴 생성
		JMenu jmFile = new JMenu("파일");
		JMenu jmEdit = new JMenu("편집");
		JMenu jmHelp = new JMenu("도움말");
		//메뉴 아이템 생성
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiNewSave = new JMenuItem("새 이름으로 저장");
		jmiClose = new JMenuItem("닫기");
		
		jmiFont = new JMenuItem("글꼴");
		jmiMemoInfo = new JMenuItem("메모장 정보");
		jtaMemo = new JTextArea();
		JScrollPane jspJtaMemo = new JScrollPane(jtaMemo);
		
		jtaMemo.setFont(new Font("맑은 고딕",Font.PLAIN,100));
				
		//배치관리자 선언
		
		//컴포넌트 배치
		jmFile.add(jmiNew); //새글
		jmFile.addSeparator();
		jmFile.add(jmiOpen); //열기
		jmFile.add(jmiSave); //저장
		jmFile.add(jmiNewSave); //새이름으로
		jmFile.addSeparator();
		jmFile.add(jmiClose); //닫기
		
		jmEdit.add(jmiFont);
		
		jmHelp.add(jmiMemoInfo);
		
		//JTextArea 배치
		add(jspJtaMemo,"Center");
		
//		//하위 메뉴 연습
//		JMenu jmTemp = new JMenu("하위메뉴");
//		jmTemp.add(new JMenuItem("하위1"));
//		jmTemp.add(new JMenuItem("하위2"));
//		jmTemp.add(new JMenuItem("하위3"));
//		
//		jmFile.add(jmTemp);
		//메뉴 메뉴바 배치
		jmb.add(jmFile);
		jmb.add(jmEdit);
		jmb.add(jmHelp);
		
		//메뉴바 JFrame 설정
		setJMenuBar(jmb);
		
		//윈도우 크기 설정
		setBounds(10,50,900,800);
		//가시화
		setVisible(true);
		//종료
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

	public JMenuItem getJmiNewSave() {
		return jmiNewSave;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}


	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiMemoInfo() {
		return jmiMemoInfo;
	}
	
	public JTextArea getJtaMemo() {
		return jtaMemo;
	}
	
}
