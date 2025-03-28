package day0328;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsePanel extends JFrame implements ActionListener {

	private CardLayout cl;
	private JPanel mainPenel;
	private JButton jbtnPrd, jbtnMem, jbtnRecom;
	
	private MemberPane mp;
	private ProductPane pp;
	private RecomPane rp;
	
	public UsePanel() {
		super("카드레이아웃 연습");
		jbtnPrd=new JButton("상품목록");
		jbtnMem=new JButton("회원목록");
		jbtnRecom=new JButton("추천상품");
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(jbtnPrd);
		jpNorth.add(jbtnRecom);
		jpNorth.add(jbtnMem);
		
		//CardLayout설정
		cl=new CardLayout();
		//main패널이 여러 패널을 변경하여 보여줘야 하기 때문에 CardLayout을 설정
		mainPenel=new JPanel(cl);
		
		mp=new MemberPane();//카드레이아웃에 배치될 패널
		rp=new RecomPane();
		pp=new ProductPane();
		
		//메인패널에 각각의 패널을 배치
		mainPenel.add(mp,"mp");
		mainPenel.add(rp,"rp");
		mainPenel.add(pp,"pp");
		
		add("North",jpNorth);
		add("Center", mainPenel);
		
		jbtnMem.addActionListener(this);
		jbtnPrd.addActionListener(this);
		jbtnRecom.addActionListener(this);
		
		setBounds(100,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생하면 Card에 보여줄 패널을 설정하여 보여준다
		if(e.getSource()==jbtnMem) {
			cl.show(mainPenel, "mp");
		}//end if
		if(e.getSource()==jbtnPrd) {
			cl.show(mainPenel, "pp");
			
		}//end if
		if(e.getSource()==jbtnRecom) {
			cl.show(mainPenel, "rp");
			
		}//end if

	}//actionPerformed

	public static void main(String[] args) {
		new UsePanel();
	}//main

}//class
