package day0219;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;

public class SameEvent extends WindowAdapter implements ActionListener {

	private SameEventDesign sed;
	
	public SameEvent(SameEventDesign sed) {
		this.sed = sed;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {

		sed.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
//		String label = ae.getActionCommand();
//		if(label.equals("파일 다이얼로그 열기")) {
//			System.out.println("열기 버튼을 클릭");
//		}else if(label.equals("파일 다이얼로그 저장")) {
//			System.out.println("저장 버튼을 클릭");
//		}

		Object obj = ae.getSource(); //이벤트를 발생시킨 객체의 주소 얻기
		if(obj == sed.getJbtOpen()) {
			FileDialog fdOpen = new FileDialog(sed,"몰래 열어봐",FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			//선택한 파일의 경로를 얻기
			String dir = fdOpen.getDirectory();
			//선택한 파일명 얻기
			String file = fdOpen.getFile();
			//타이틀바에 선택한 파일의 경로와 파일명 추가
			if(dir != null) {
				sed.setTitle(dir+file);				
			}
		}
		if(obj == sed.getJbtSave()) {
//			System.out.println("저장 클릭");
//			FileDialog fdSave = new FileDialog(sed,"저장해",FileDialog.SAVE);
//			fdSave.setVisible(true);
			JFileChooser jfcSave = new JFileChooser();
			jfcSave.showSaveDialog(sed);
			//파일 디렉토리와 파일명을 타이틀바에 출력
			sed.setTitle(jfcSave.getSelectedFile().toString());
			
		}
	}

	
}
