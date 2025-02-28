package yys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormEvt extends WindowAdapter implements ActionListener{

	private LoginForm lf;
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton btnLogin, btnCancel;
	
	public LoginFormEvt(LoginForm lf) {
		this.lf=lf;
		this.jtfId=lf.getJtfId();
		this.jpfPass=lf.getjpfPass();
		this.btnLogin=lf.getBtnLogin();
		this.btnCancel=lf.getBtnCancel();
	}
	
	

	private boolean idChk() {
		boolean flag= jtfId.getText().trim().isEmpty();
		if(flag) {
			JOptionPane.showMessageDialog(lf, "아이디는 필수 입력입니다.", "입력오류", JOptionPane.WARNING_MESSAGE);
			jtfId.requestFocus();
			
		}else {
			jpfPass.requestFocus();
		}
		return flag;
	}
	
	private void passChk() {
		if(idChk()) return;
		
		String id= jtfId.getText().trim();
		String pass = new String(jpfPass.getPassword());
		String msg="아이디나 비번을 확인하세요";
		
		if(LoginForm.mapLoginData.containsKey(id) && LoginForm.mapLoginData.get(id).equals(pass)) {
			msg="로그인 성공";
			JOptionPane.showMessageDialog(lf, msg,"로그인", JOptionPane.INFORMATION_MESSAGE);
			lf.dispose();
			//SwingUtilities.invokeLater(LogAnalyerGUI :: new); //로그 분석 GUI 실행
			
			new LogAnalyzerGUI(); 
		}else {
			
			JOptionPane.showMessageDialog(lf, msg,"로그인실패", JOptionPane.ERROR_MESSAGE);
		}
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnLogin) {
			passChk();
			
		}else if(ae.getSource()==btnCancel) {
			lf.dispose();
		}
	}

}//class
