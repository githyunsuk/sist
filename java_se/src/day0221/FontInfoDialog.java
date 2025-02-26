package day0221;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FontInfoDialog extends JDialog {

	private MemoDesign md;
	
	private JTextField jtfFont, jtfStyle, jtfSize;
	private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
	private JList<String> jlFont, jlStyle, jlSize;
	private JLabel jlblFontPreview;
	private JButton jbtnOk, jbtnCancel;
	
	public FontInfoDialog(MemoDesign md) {
		super(md, "글꼴", true);
		this.md = md;
		
		jtfFont = new JTextField("글꼴(F):");
		jtfStyle = new JTextField("글꼴 스타일(Y):");
		jtfSize = new JTextField("크기(S):");
		
		dlmFont = new DefaultListModel<String>();
		dlmFont.addElement("고딕체");
		dlmFont.addElement("궁서체");
		dlmFont.addElement("Consolas");
		dlmFont.addElement("새굴림");
		dlmFont.addElement("맑은 고딕");
		jlFont = new JList<>(dlmFont);
		
		dlmStyle = new DefaultListModel<String>();
		dlmStyle.addElement("일반");
		dlmStyle.addElement("굵게");
		dlmStyle.addElement("기울임꼴");
		dlmStyle.addElement("굵은 기울임꼴");
		jlStyle = new JList<>(dlmStyle);
		
		dlmSize = new DefaultListModel<String>();
		dlmSize.addElement("8");
		dlmSize.addElement("9");
		dlmSize.addElement("10");
		for(int i=12; i<=80; i+=2) {
			dlmSize.addElement(String.valueOf(i));
		}
		jlSize = new JList<>(dlmSize);
		
		add(jlFont);
		add(jlStyle);
		add(jlSize);
		setBounds(100,100,400,600);
        setVisible(true);
		
	}

	public MemoDesign getMd() {
		return md;
	}

	public JTextField getJtfFont() {
		return jtfFont;
	}

	public JTextField getJtfStyle() {
		return jtfStyle;
	}

	public JTextField getJtfSize() {
		return jtfSize;
	}

	public JLabel getJlblFontPreview() {
		return jlblFontPreview;
	}

	public JButton getJbtnOk() {
		return jbtnOk;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}
	
	
}
