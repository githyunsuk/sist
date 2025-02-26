package day0221;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoDesignEvt extends WindowAdapter implements ActionListener {

	private MemoDesign md;
	
	public MemoDesignEvt(MemoDesign md) {
		this.md = md;
	}
	
	public void newMemo() {
		md.getJtaMemo().setText("");
	}
	
	public void openMemo() {
		FileDialog fd = new FileDialog(md, "파일 열기", FileDialog.LOAD);
		fd.setVisible(true);
		
		String dir = fd.getDirectory();
		String file = fd.getFile();
		
		if (dir != null && file != null) {
            md.setTitle(dir + file + "열기");
        }
	}
	
	public void saveMemo() {
		FileDialog fileDialog = new FileDialog(md, "파일 저장", FileDialog.SAVE);
        fileDialog.setVisible(true);

        String dir = fileDialog.getDirectory(); 
        String file = fileDialog.getFile();          

        if (dir != null && file != null) {
            md.setTitle(dir + file + "저장");
        }
	}
	
	public void closeMemo() {
		md.dispose();
	}
	
	public void fontDialog() {
		new FontInfoDialog(md);
	}
	
	public void memoInfo() {
		new MemoInfoDialog(md);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		closeMemo();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == md.getJmiNew()) {
			newMemo();
		}
		if(ae.getSource() == md.getJmiOpen()) {
			openMemo();
		}
		if(ae.getSource() == md.getJmiSave()) {
			saveMemo();
		}
		if(ae.getSource() == md.getJmiClose()) {
			closeMemo();
		}
		if(ae.getSource() == md.getJmiFont()) {
			fontDialog();
		}
		if(ae.getSource() == md.getJmiMenuInfo()) {
			memoInfo();
		}
	}

}
