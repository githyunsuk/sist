package smk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;

/**
 * 인증정보는 ID,PASSWORD 가 
 * ‘admin,1234’, ‘root, 1111’,’administrator,12345’로 인증 될 수 있습니다.
 * 이때 root계정으로 인증하면 report문서를 생성할 수 없습니다를 보여줍니다.
 * 
 * 
 * 	private String memberId;
	private String password;
	private String name;
	
 */
public class LoginEVT extends WindowAdapter implements ActionListener {

	private LoginPage loginPage;
	
	private static List<MemberVO> memberLIst;
	
	public LoginEVT(LoginPage loginPage) {
		this.loginPage = loginPage;
		this.memberLIst = new ArrayList<MemberVO>();
	}
	
	public LoginEVT() {
		//기본생성자
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//로그인 버튼 클릭시
		if(e.getSource() == loginPage.getLoginBtn()) {
			
			loginPro(); //로그인 수행
		}
	}
	
	public void loginPro() {
		System.out.println("로그인 수행");
		String memberId = loginPage.getLoginField().getText();
		char[] memberPwChar = loginPage.getPwField().getPassword();
		String memberPW = memberPwChar.toString();

		//아이디 검증 
		MemberVO vo;
		Set<String> keyIdSet = new HashSet<String>();
		for(int i = 0; i < memberLIst.size(); i++) {
			vo = memberLIst.get(i);
			keyIdSet.add(vo.getMemberId());
		}
		if(!keyIdSet.contains(memberId)) {
			String inputedId = loginPage.getLoginField().getText();
			String message = " 님은 현재 회원이 아닙니다.";
			String wrongIdInfo = inputedId + message;
			loginPage.getLoginField().setForeground(Color.RED);
			loginPage.getLoginField().setText(wrongIdInfo);
		} else {
				loginPage.getLoginField().setEnabled(false);
				loginPage.getLoginField().setFont(new Font("맑은 고딕", Font.BOLD, 30));
				loginPage.getLoginField().setBackground(new Color(0xE2E2E2));
			
		}
		
		//비밀번호가 검증 
		Set<String> keyPwSet = new HashSet<String>();
		for(int i = 0; i < memberLIst.size(); i++) {
			vo = memberLIst.get(i);
			keyPwSet.add(vo.getPassword());
		}
		if( loginPage.getLoginField().getText().isEmpty() && !keyPwSet.contains(memberPW)) {
			
			//String message = "비밀번호가 옳지 않습니다. 다시한번 확인해주세요.";
			loginPage.add(new JLabel("비밀번호가 옳지 않습니다. 다시한번 확인해주세요", JLabel.CENTER));
			//loginPage.getPwField().setForeground(Color.RED);
			//loginPage.getPwField().setText(message);
		} else {
			
			//아이디와 비밀번호까지 모두 맞음, -> 로그인 성공 처리 
			//MainPage.LOGINUSER = 
			
		}
		
		
			
			
		
		
		
	}
	
	public void saveTempMember() {
		//‘admin,1234’, ‘root, 1111’,’administrator,12345’
		MemberVO vo1 = new MemberVO("admin", "1234", "관리자A");
		MemberVO vo2 = new MemberVO("root", "1111", "거절된root");
		MemberVO vo3 = new MemberVO("administrator", "12345", "관리자B");
		memberLIst.add(vo1);
		memberLIst.add(vo2);
		memberLIst.add(vo3);
		System.out.println("회원 admin, root, administrator 3명 가입 완료");
		
	}

}
