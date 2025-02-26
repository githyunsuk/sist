package day0219;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class TestMouseEvent extends JFrame implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004070671136972937L;
	private DefaultComboBoxModel<String> dcbm;
	private JComboBox<String> jcbDomain;
	
	private JTextField jtfEmail;
	private JTextField jtfDomain;
	private JLabel emailOutput;
	
	public TestMouseEvent() {
		
		super("JComboBox 사용");
		
		//1.데이터를 가지는 Model 단의 클래스 객체화
		dcbm = new DefaultComboBoxModel<String>();
		//2.데이터를 사용하여 화면을 만드는 View단 클래스를 객체화.(has a)
		jcbDomain = new JComboBox<String>(dcbm);
		
		//도메인을 추가 ( 데이터 ) => Model 사용
		dcbm.addElement("gmail.com");
		dcbm.addElement("naver.com");
		dcbm.addElement("daum.net");
		dcbm.addElement("hotmail.com");
		dcbm.addElement("직접 입력");
		
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("이메일 입력"));
		
		jtfEmail = new JTextField(15);
		jtfDomain = new JTextField(15);
		emailOutput = new JLabel("출력");
		emailOutput.setBorder(new TitledBorder("출력"));
		
		jp.add(jtfEmail);
		jp.add(new JLabel("@",JLabel.CENTER));
		jp.add(jtfDomain);
		jp.add(jcbDomain);
		
		add("North", jp);
		add("Center", emailOutput);
		
		//디자인에서 발생한 이벤트를 처리하기 위해 이벤트 클래스를 has a 관계로 생성.
		jcbDomain.addMouseListener(this);
		
		setBounds(100, 100, 500 ,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TestMouseEvent();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		System.out.println("클릭한 값:" + jcbDomain.getSelectedItem());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
