package day0218;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 글꼴 변경
 */
@SuppressWarnings("serial")
public class UseActionListenerDesign extends JFrame {
	private JTextField jtf;
	private JTextArea jta;

	public UseActionListenerDesign() {
		super("Font 사용");
		
		//Non-Visual Component
		Font font = new Font("궁서체", Font.BOLD, 20);
		//Non-Visual Component
		Color color = new Color(0x3E7F84);
		Color color2 = new Color(0x34234);
		
		//컴포넌트 생성
		JLabel jlbl = new JLabel("라벨");
		jtf = new JTextField(10);
		JButton jbtn = new JButton("버튼");
		//폰트를 적용
		jlbl.setFont(font);
		jtf.setFont(font);
		jbtn.setFont(font);
		
		//전경색(글자색)
		//Constant 사용
		jlbl.setForeground(Color.blue);
		jtf.setForeground(Color.MAGENTA);
		jbtn.setForeground(Color.CYAN);
		
		//바닥색 변경
		jlbl.setBackground(Color.GREEN);//배경이 투명하여 바닥이 보이지 않는다.
		jlbl.setOpaque(true);//불투명도를 true로 설정하면 바닥색을 보여줄 수 있다
		jtf.setBackground(Color.GREEN);
		jbtn.setBackground(Color.GREEN);//바닥색이 보이는 이뉴는 불투명도가 설정되었기 때문
		jbtn.setContentAreaFilled(false);//배경이 투명(배경색이 설정되지 않는다)
		
		jta = new JTextArea(5,30);
		jta.setFont(new Font("휴먼편지체", Font.BOLD|Font.ITALIC, 25));
		//객체사용
		jta.setForeground(color);//전경색
		jta.setBackground(color2);
		
		JScrollPane jsp = new JScrollPane(jta);
		//배치관리자 설정
		setLayout(new FlowLayout());
		//컴포넌트 배치
		add(jlbl);
		add(jtf);
		add(jbtn);
		add(jsp);
		
		//컴포넌트를 이벤트에 등록
		//1. 이벤트 처리 클래스와 has a 관계를 설정
		UseActionListenerEvent uale = new UseActionListenerEvent(this);
		//2. 컴포넌트를 이벤트에 등록하고, 이벤트 발생시 처리할 객체를 할당
		jbtn.addActionListener(new UseActionListenerEvent(this));
		//윈도우 크기 설정
		setBounds(100,100,700,300);
		//사용자에게 보여주기
		setVisible(true);
		//윈도우 종료 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public JTextField getJtf() {
		return jtf;
	}


	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}


	public JTextArea getJta() {
		return jta;
	}


	public void setJta(JTextArea jta) {
		this.jta = jta;
	}


	public static void main(String[] args) {

		new UseActionListenerDesign();
	}

}
