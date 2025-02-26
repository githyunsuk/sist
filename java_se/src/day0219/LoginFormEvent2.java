package day0219;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormEvent2 extends WindowAdapter implements ActionListener {

	private LoginForm lf;
	private Map<String, String> mapLoginData;

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlblOutput;

	public LoginFormEvent2(LoginForm lf) {
		this.lf = lf;
		// 필요한 컴포넌트를 인스턴스 변수(사용할 컴포넌트)에 할당
		jtfId = lf.getJtfId();
		jpfPass = lf.getJpfPass();
		jlblOutput = lf.getJlblOutput();

		mapLoginData = new HashMap<String, String>();
		mapLoginData.put("kim", "1234");
		mapLoginData.put("park", "Park2025");
		mapLoginData.put("lee", "4321");
		mapLoginData.put("hong", "h_1234");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		lf.dispose();
	}

	private boolean idChk() {
		boolean flag = false;
		String id = jtfId.getText().trim();

		flag = !id.isEmpty();
		if (flag) {
			jpfPass.requestFocus();
		} else {
			jlblOutput.setText("아이디는 필수 입력!");
			jtfId.requestFocus();
		}
		return flag;
	}

	private void passChk() {
		if (!idChk()) {
			return;
		}

		String pass = new String(jpfPass.getPassword());

		if (pass.isEmpty()) {
			jlblOutput.setText("비밀번호 필수 입력!");
			jpfPass.requestFocus();
			return;
		}

		String id = jtfId.getText();
		String msg = "아이디나 비번을 확인";

		if (mapLoginData.containsKey(id) && mapLoginData.containsValue(pass)) {
			msg = "로그인 성공";
		}

		jlblOutput.setText(msg);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jtfId) {
			idChk();
		}

		if (ae.getSource() == jpfPass) {
			passChk();
		}
	}

}
