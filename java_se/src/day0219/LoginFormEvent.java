package day0219;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class LoginFormEvent extends KeyAdapter {

	private LoginForm lf;
	HashMap<String, String> map;

	public LoginFormEvent(LoginForm lf) {
		this.lf = lf;
		map = new HashMap<>();
		map.put("kim", "1234");
		map.put("park", "Park2025");
		map.put("lee", "4321");
		map.put("hong", "h_1234");
	}

	@Override
	public void keyReleased(KeyEvent e) {

		Object obj = e.getSource();
		String textId = lf.getJtfId().getText();
		char[] pwChar = lf.getJpfPass().getPassword();
		String textPw = new String(pwChar);

		// 아이디 필드에서 enter키 입력
		if (obj == lf.getJtfId() && e.getKeyCode() == KeyEvent.VK_ENTER) {
			//아이디 필드가 비었다면
			if (textId.isEmpty()) {
				lf.getJlblOutput().setText("아이디는 필수 입력!!");
			} else {
				lf.getJpfPass().requestFocus();
			}
		}

		// 비밀번호 필드에서 enterkey 입력
		if (obj == lf.getJpfPass() && e.getKeyCode() == KeyEvent.VK_ENTER) {
			//아이디 필드가 비었다면
			if (textId.isEmpty()) {
				lf.getJlblOutput().setText("아이디는 필수 입력!!");
				lf.getJtfId().requestFocus();
			}
			//비밀번호 필드가 비었다면
			if (textPw.isEmpty()) {
				lf.getJlblOutput().setText("비밀번호는 필수 입력!!");
				lf.getJpfPass().requestFocus();
			}
			//아이디 & 비밀번호 필드가 입력되었으면
			if (!textId.isEmpty() && !textPw.isEmpty()) {
				//map안에 아이디랑 비밀번호가 있다면
				if (map.containsKey(textId) && map.get(textId).equals(textPw)) {
					lf.getJlblOutput().setText("로그인 성공");
				} else { 
					lf.getJlblOutput().setText("로그인 실패");
					lf.getJtfId().setText("");
					lf.getJpfPass().setText("");
				}
			}

		}
	}

}
