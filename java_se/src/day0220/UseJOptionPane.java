package day0220;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame {

	private JButton jbtnInput;
	private JButton jbtnMsg;
	private JButton jbtnConfirm;
	
	private UseJOptionPane ujp;

	public UseJOptionPane() {
		super("JOptionPane 사용");
		jbtnInput = new JButton("input dialog");
		jbtnMsg = new JButton("message dialog");
		jbtnConfirm = new JButton("confirm dialog");

		JPanel jpCenter = new JPanel();
		jpCenter.add(jbtnInput);
		jpCenter.add(jbtnMsg);
		jpCenter.add(jbtnConfirm);

		add("Center", jpCenter);
		ujp = this;

		UseJOptionPane.InnerEvent ie = this.new InnerEvent();
		jbtnInput.addActionListener(ie);
		jbtnMsg.addActionListener(ie);
		jbtnConfirm.addActionListener(ie);

		setBounds(100, 100, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// inner class 시작
	public class InnerEvent implements ActionListener {

		public void useInputDialog() {
			String name = JOptionPane.showInputDialog(ujp,"당신의 이름을 입력해 주세요.","이름",JOptionPane.PLAIN_MESSAGE);
			if (name != null) {
				setTitle(name + "님 어서오세요");
			}
		}

		public void useMessageDialog() {
			JOptionPane.showMessageDialog(ujp, "수고했다\n맛접해라");
		}

		public void useConfirmDialog() {
			int selectBtnIdx = JOptionPane.showConfirmDialog(ujp, "점심 맛있게 드셨어요?","오늘 점심은",JOptionPane.YES_NO_CANCEL_OPTION);
			switch(selectBtnIdx) {
			case JOptionPane.OK_OPTION: 
				JOptionPane.showMessageDialog(ujp, "식당이 어디일까요?" );
				break;
			case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(ujp, "굶었어요?");
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(ujp, "취소");
				break;
			}
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == jbtnInput) {
				useInputDialog();
			}
			if (ae.getSource() == jbtnMsg) {
				useMessageDialog();
			}
			if (ae.getSource() == jbtnConfirm) {
				useConfirmDialog();
			}
		}

	}

	// inner class 끝
	public static void main(String[] args) {
		new UseJOptionPane();
	}

}
