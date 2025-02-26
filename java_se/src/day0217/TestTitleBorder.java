package day0217;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TestTitleBorder extends JFrame {
	
	public TestTitleBorder() {
		super("로그인");
		//컴포넌트 선언 및 생성
		JLabel jlblTitle = new JLabel("로그인",JLabel.CENTER);
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(3,1));
		jpCenter.setBorder(new TitledBorder("입력정보"));
		
		JTextField jtfId = new JTextField();
		JPasswordField jpfPass = new JPasswordField();
		JLabel jlblOutput = new JLabel();
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		jtfId.setFont(font);
		jpfPass.setFont(font);
		jlblOutput.setFont(font);
		
		//border
		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		jlblOutput.setBorder(new LineBorder(Color.RED));
		
		jpCenter.add(jtfId);
		jpCenter.add(jpfPass);
		jpCenter.add(jlblOutput);

		//레이아웃 설정
		
		//배치
		add("North", jlblTitle);
		add("Center",jpCenter);
		
		//크기 설정
		setBounds(50,50,300,250);
		//가시화
		setVisible(true);
		//종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new TestTitleBorder();
	}

}
