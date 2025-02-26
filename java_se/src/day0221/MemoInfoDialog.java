package day0221;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MemoInfoDialog extends JDialog{

	private MemoDesign md;
	private JLabel labelDialog;
	private JButton closeButton;
	
	
	public MemoInfoDialog(MemoDesign md) {
		super(md, "메모장 정보", true);
		this.md = md;
		
		setLayout(new BorderLayout());
		String text = "Java 메모장 Version1.0 이 메모장은 KPL(Kang Public License)로서 아무나 가져다 변환 및 배포 가능합니다. 편하게 가져다 사용해주세요";
		JTextArea jta = new JTextArea(text);
		jta.setLineWrap(true);
		closeButton = new JButton("닫기");
		
		MemoInfoEvt mie = new MemoInfoEvt(this);
		addWindowListener(mie);
		closeButton.addActionListener(mie);
		
		add("Center",jta);
		add("South",closeButton);
		
        setBounds(100,100,300, 200);
        setVisible(true);
	
	}


	public MemoDesign getMd() {
		return md;
	}


	public JLabel getLabelDialog() {
		return labelDialog;
	}


	public JButton getCloseButton() {
		return closeButton;
	}
	
	
}
