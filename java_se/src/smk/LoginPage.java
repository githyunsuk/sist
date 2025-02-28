package smk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 로그인 패널 
 */
@SuppressWarnings("serial")
public class LoginPage extends JPanel{
	
	private JButton joinBtn;
	private JButton loginBtn;
	private JTextField loginField;
	private JPasswordField pwField;

	public LoginPage() {
		
		//Non-Visual Component
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 20);
		Color memBtnFColor = Color.WHITE;
		Color memBtnBColor = Color.BLUE;
		
		
		//컴포넌트 생성 및 옵션 
		JLabel titleLabel = new JLabel("WELCOME", JLabel.CENTER);
		titleLabel.setFont(titleFont);
		
		JButton fbBtn = new JButton("페이스북");
		JButton googleBtn = new JButton("구글");
		JButton kakaokBtn = new JButton("카카오");
		JButton githubBtn = new JButton("깃허브");
		JButton naverBtn = new JButton("네이버");
		
		loginField = new JTextField(10); //아이디 공간
		pwField = new JPasswordField(10); //비밀번호 공간
		
		joinBtn = new JButton("회원가입");
		loginBtn = new JButton("로그인");
		
		
//폰트, 컬러 (맥북에서 적용 불가)
/**
		joinBtn.setBackground(memBtnBColor);
		joinBtn.setForeground(memBtnFColor);
		joinBtn.setOpaque(true);
		loginBtn.setBackground(memBtnBColor);
		loginBtn.setForeground(memBtnFColor);
		loginBtn.setOpaque(true);
*/
		//sns로그인 UI 컴포넌트 설정 
		JPanel socialPanel = new JPanel();
		socialPanel.setLayout(new GridLayout(2,3));
		TitledBorder snsBorder = new TitledBorder("sns 로그인");
		snsBorder.setTitleFont(new Font("맑은 고딕", Font.BOLD, 15));
		socialPanel.setBorder(snsBorder);
		socialPanel.add(fbBtn);
		socialPanel.add(googleBtn);
		socialPanel.add(kakaokBtn);
		socialPanel.add(githubBtn);
		socialPanel.add(naverBtn);
		
//중간 UI 컴포넌트 설정 (미사용)
		JLabel horizenLabel = new JLabel("----아이디로 로그인----", JLabel.CENTER);
		horizenLabel.setForeground(Color.GRAY);
		horizenLabel.setBorder(null); //테두리제거 
		
		//하단 로그인 설정 
		loginField.setBorder(new TitledBorder("아이디"));
		TitledBorder titleBorder = new TitledBorder("비밀번호");
		//pwField.setBorder(new TitledBorder("비밀번호")); // TitleBorder와 LineBorder는 겹침 
		//pwField.setBorder(new LineBorder(Color.RED)); //나중에 응용하기, 비밀번호 틀릴 때 적요ㅇ 
		LineBorder lineBorder =new LineBorder(Color.RED);
		pwField.setBorder(new CompoundBorder(titleBorder, lineBorder)); //보더 두개 동시적용하기 : CompoundBorder()
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(2,1));
		loginPanel.setBorder(new TitledBorder("기존 아이디로 로그인"));
		loginPanel.add(loginField);
		loginPanel.add(pwField);
		
		JPanel loginBtnPanel = new JPanel();
		loginBtnPanel.setLayout(new GridLayout(1,2));
		loginBtnPanel.add(joinBtn);
		loginBtnPanel.add(loginBtn);
		
		
		//레이아웃 설정
		this.setLayout(new GridLayout(3,1));
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		
		//배치 
		northPanel.add(titleLabel, "North");
		northPanel.add(socialPanel, "South");
		southPanel.add(loginPanel, "North");
		southPanel.add(loginBtnPanel, "South");
		
		socialPanel.setPreferredSize(new Dimension(400, 100));
		loginPanel.setPreferredSize(new Dimension(400, 150));
		loginBtnPanel.setPreferredSize(new Dimension(400, 50));
		
		add(northPanel);
		add(southPanel);
		
//입력정보가 틀리면 비밀번호 칸을 비우면서, 다시한번 확인해달라 텍스트 표시 

//이벤트 처리 
		LoginEVT loginEVT = new LoginEVT(this);
		
		joinBtn.addActionListener(loginEVT);
		loginBtn.addActionListener(loginEVT);
		
	}

	public JButton getJoinBtn() {
		return joinBtn;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getPwField() {
		return pwField;
	}
	
	
	
}
