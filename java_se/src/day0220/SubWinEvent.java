package day0220;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SubWinEvent extends WindowAdapter implements ActionListener {

	private SubWin sw;
	
	public SubWinEvent(SubWin sw) {
		this.sw = sw;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		sw.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sw.dispose();
	}

}
