package yys;



import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



@SuppressWarnings("serial")
public class LoginForm extends JFrame{
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton btnLogin, btnCancel;
	public static final Map<String, String> mapLoginData = new HashMap<String, String>();
	
	
	public static void initializeLoginData()  {
		mapLoginData.put("admin", "1234");
		mapLoginData.put("root", "1111");
		mapLoginData.put("administrator", "12345");
	

}
	public LoginForm() {
		setTitle("로그인");
		setLayout(300,400);
		
		
		JLabel jlblTitle= new JLabel("로그인", JLabel.CENTER);
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		
	
		JPanel jpCenter= new JPanel();
		jpCenter.setLayout(new GridLayout(3,1));
		jpCenter.setBorder(new TitledBorder("입력정보"));
		
		
		jtfId= new JTextField();
		jpfPass=new JPasswordField();
		
		
		Font font=new Font("맑은 고딕", Font.BOLD, 20);
		jtfId.setFont(font);
		jpfPass.setFont(font);
		
		
		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		
		jpCenter.add(jtfId);
		jpCenter.add(jpfPass);
		
		
		JPanel jpButton=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnLogin= new JButton("확인");
		btnCancel= new JButton("취소");
		
		
		
		btnLogin.setFont(font);
		btnCancel.setFont(font);
		
		jpButton.add(btnLogin);
		jpButton.add(btnCancel);
		
		
		add(jlblTitle,"North");
		add(jpCenter, "Center");
		add(jpButton,"South");
		
		LoginFormEvt lfe= new LoginFormEvt(this);
		
		btnLogin.addActionListener(lfe);
		btnCancel.addActionListener(lfe);
		
		 initializeLoginData();
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

	
	
	
	private void setLayout(int i, int j) {
		
	}
	public JTextField getJtfId() {
		return jtfId;
	}
	public JPasswordField getjpfPass() {
		return jpfPass;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}


	public static void main(String[] args) {
		new LoginForm();
	}
	
	
}//class


