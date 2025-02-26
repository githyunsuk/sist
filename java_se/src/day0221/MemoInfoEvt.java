package day0221;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoInfoEvt extends WindowAdapter implements ActionListener {

	private MemoInfoDialog mid;
	
	public MemoInfoEvt(MemoInfoDialog mid) {
		this.mid = mid;
	}
	@Override
	public void windowClosing(WindowEvent e) {
		mid.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mid.getCloseButton()) {
			mid.dispose();
		}
	}

}
