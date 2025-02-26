package day0218;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJComboBox extends JFrame implements ActionListener{
	
	private DefaultComboBoxModel<String> dcbm;
	private JComboBox<String> jcbDomain;
	
	public UseJComboBox() {
		
		super("JComboBox 사용");
		
		//1.데이터를 가지는 Model 단의 클래스 객체화
		dcbm = new DefaultComboBoxModel<String>();
		//2.데이터를 사용하여 화면을 만드는 View단 클래스를 객체화.(has a)
		jcbDomain = new JComboBox<String>(dcbm);
		
		jcbDomain.addActionListener(this);
		
		//도메인을 추가 ( 데이터 ) => Model 사용
		dcbm.addElement("gmail.com");
		dcbm.addElement("naver.com");
		dcbm.addElement("daum.net");
		dcbm.addElement("hotmail.com");
		dcbm.addElement("hotmail.net");
		
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("이메이 입력"));
		
		jp.add(new JTextField(15));
		
		setBounds(100, 100, 400 ,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new UseJComboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int selectedIndex = jcbDomain.getSelectedIndex();
		System.out.println("선택한 인덱스" + selectedIndex);
	}

}
