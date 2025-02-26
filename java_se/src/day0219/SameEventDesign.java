package day0219;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SameEventDesign extends JFrame {

	private JButton jbtOpen;
	private JButton jbtSave;
	
	public SameEventDesign() {
		
		super("같은 이벤트 처리");
		
		jbtOpen = new JButton("파일 다이얼로그 열기");
		jbtSave = new JButton("파일 다이얼로그 저장");
		
		JPanel jpCenter = new JPanel();
		jpCenter.add(jbtOpen);
		jpCenter.add(jbtSave);
		
		add(jpCenter);
		
		//윈도우 종료 이벤트 처리
		//has a 관계 객체 생성
		SameEvent se = new SameEvent(this);
		//윈도우에 이벤트 등록
		addWindowListener(se);
		//버튼에 이벤트 등록
		jbtOpen.addActionListener(se);
		jbtSave.addActionListener(se);
		
		
		setBounds(50,50,400,300);
		setVisible(true);

	}
	
	public JButton getJbtOpen() {
		return jbtOpen;
	}
	
	public JButton getJbtSave() {
		return jbtSave;
	}
	
	public static void main(String[] args) {
		new SameEventDesign();
	}
}
