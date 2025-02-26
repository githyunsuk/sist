package logproject;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 로그인 창 클래스
 */
@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JTextField idField;
	private JPasswordField pwField;
	private JButton loginBtn;
	
	public LoginView() {
		super("로그인");
		setLayout(new FlowLayout());
		
		idField = new JTextField(10);
		pwField = new JPasswordField(10);
		loginBtn = new JButton("로그인");
		
		add(idField);
		add(pwField);
		add(loginBtn);
		
		LoginViewEvt lve = new LoginViewEvt(this);
		addWindowListener(lve);
		loginBtn.addActionListener(lve);
		
		setBounds(100,100,400,300);
		setVisible(true);
	
	}

	public JTextField getIdField() {
		return idField;
	}

	public JPasswordField getPwField() {
		return pwField;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

}
