package kr.co.sist.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import kr.co.sist.service.LobService;
import kr.co.sist.view.LobView;
import kr.co.sist.vo.LobVO;

public class LobEvent extends WindowAdapter implements ActionListener {
	private LobView lv;
	private File addFile;

	public LobEvent(LobView lv) {
		this.lv = lv;
	}// LobEvent

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lv.getJbtnAdd()) {
			addMember();
		} // end if

		if (ae.getSource() == lv.getJbtnExit()) {
			closeWindow();
		} // end if

		if (ae.getSource() == lv.getJbtnSerch()) {
			searchMember();
		} // end if

		if (ae.getSource() == lv.getJbtnSelect()) {
			uploadImage();
		} // end if
	}// actionPerformed

	private void uploadImage() {
		JFileChooser jfc=new JFileChooser();
		jfc.showOpenDialog(lv);
		
		addFile=jfc.getSelectedFile();
		if( !addFile.exists() ) {
			JOptionPane.showMessageDialog(lv, "파일이 존재하지 않습니다.");
			return;
		}//end if
		
		ImageIcon preview=new ImageIcon(addFile.getAbsolutePath());
		lv.getJlblImage().setIcon(preview);
		
	}// uploadImage

	private void addMember() {
		
		LobVO lVO=new LobVO();
		lVO.setName(lv.getJtfName().getText().trim());
		lVO.setEmail(lv.getJtfName().getText().trim());
		lVO.setImg_name( addFile!=null && addFile.exists() ? addFile.getAbsolutePath():"" );
		lVO.setTel(lv.getJtfTel().getText().trim());
		lVO.setIntro(lv.getJtaIntroduction().getText() );

		LobService ls=new LobService();
		String msg="회원정보가 추가되지 않았습니다";
		if(ls.addMember(lVO)) {
			msg="회원정보가 추가 되었습니다.";
		}//end if
		
		lv.getJtfName().setText("");
		lv.getJtfNum().setText("");
		lv.getJtfTel().setText("");
		lv.getJtfEmail().setText("");
		addFile=new File("");
		lv.getJlblImage().setIcon(new ImageIcon("C:/dev/workspace/jdbc_lob_prj/src/kr/co/sist/view/default_img.png"));
		lv.getJtaIntroduction().setText("");
		
		JOptionPane.showConfirmDialog(lv, msg);
	}// addMember

	private void searchMember() {
		LobService ls=new LobService();
		try {
		int num= Integer.parseInt(lv.getJtfNum().getText().trim());
		LobVO lVO=ls.searchMember(num);
		
		if(lVO == null ) {
			JOptionPane.showMessageDialog(lv, num+"번 회원정보는 ㅇㅅㅇ!");
			lv.getJtfNum().setText("");
			return;
		}//end if 
		
		//DBMS 테이블에서 검색된 결과를 View에 뿌린다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		lv.setTitle("입력일 : "+ sdf.format(lVO.getInput_date()));
		
		lv.getJtfName().setText(lVO.getName());
		lv.getJtfEmail().setText(lVO.getEmail());
		lv.getJtfTel().setText(lVO.getTel());
		
		String iconPath="C:\\dev\\workspace\\jdbc_lob_prj\\src\\kr\\co\\sist\\view\\default_img.png";
		if( lVO.getImg_name() != null ) {
			File file=new File("c:/dev/img"+File.separator +lVO.getImg_name());
			if(file.exists()) {
				iconPath=file.getAbsolutePath();
			}//end if
		}//end if 
			ImageIcon icon=new ImageIcon( iconPath );
			lv.getJlblImage().setIcon(icon);
		
			if(lVO.getIntro() != null ) {
				lv.getJtaIntroduction().setText(lVO.getIntro());
			}//end if
		
		}catch(NumberFormatException nfe ) {
			JOptionPane.showMessageDialog(lv, "번호는 숫자만 간으합니다.");
		}//end if
	}// searchMember

	private void closeWindow() {
		lv.dispose();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		closeWindow();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}// windowClosed

}// class
