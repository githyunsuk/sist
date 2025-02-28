package smk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class MenuEVT extends WindowAdapter implements ActionListener {

	private MenuUI menuUI;
	
	public MenuEVT(MenuUI menuUI) {
		this.menuUI = menuUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == menuUI.getJmiClose()) {
			
			menuUI.getMp().dispose();
		}
		
		if(e.getSource() == menuUI.getJmiNew()) {
			//새글
		}
		if(e.getSource() == menuUI.getJmiOpen()) {
			//열기
		}
		if(e.getSource() == menuUI.getJmiSave()) {
			//저장
		}
		
		
	}
	
	
	
	

}
