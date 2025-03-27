package day0327;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchZipCodeViewEvt extends MouseAdapter implements ActionListener {

	private SearchZipCodeView szv;
	
	public SearchZipCodeViewEvt(SearchZipCodeView szv) {
		this.szv = szv;
	}//SearchZipCodeViewEvt


	@Override
	public void mouseClicked(MouseEvent e) {
		sendZipcode();
	}//mouseClicked
	
	@Override
	public void actionPerformed(ActionEvent e) {
		searchZipcode();
	}//actionPerformed
	
	public void sendZipcode() {
		int selectedBtn = JOptionPane.showConfirmDialog(szv, "사용할거?");
		switch(selectedBtn) {
		case JOptionPane.OK_OPTION:
			
			JTable table = szv.getTable();
			//JTable에 선택된 행의 값을 얻기
			int selectedRow = table.getSelectedRow();
			MemberView mv = szv.getMv();
			
			mv.getJtfZipcode().setText((String)table.getValueAt(selectedRow, 0));
			mv.getJtfAddress().setText((String)table.getValueAt(selectedRow, 1));
			mv.getJtfDetails().requestFocus();
			szv.dispose();
//			int colmnCnt = table.getSelectedColumnCount();
//			for(int col=0; col<=colmnCnt; col++) {
//				System.out.println(table.getValueAt(selectedRow, col));
//			}
		}
	}//sendZipcode
	
	public void searchZipcode() {
		String dong = szv.getJtfDongName().getText().trim();
		if(dong.isEmpty()) {
			JOptionPane.showMessageDialog(szv, "동 이름은 필수 입력");
			return;
		}
		
		SearchZipcodeService szs = new SearchZipcodeService();
		List<ZipcodeVO> list = szs.searchZipcode(dong);
		
		//조회결과를 JTable에 추가
		//1.조회결과를 배열로 만들고
		String[] data = null;
		Iterator<ZipcodeVO> ita = list.iterator();
		
		ZipcodeVO zVO = null;
		StringBuilder addr = new StringBuilder();
		
		DefaultTableModel dtm = szv.getDtm(); //모델을 받는다.
		
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(szv, "존재하는 동을 입력해");
			szv.getJtfDongName().setText("");
			return;
		}
		//기존 행수가 하나 이상이라면 
		if(dtm.getRowCount() > 0) {
			//행수를 초기화한다.
			dtm.setRowCount(0);
		}
		//새로운 데이터를 추가
		while(ita.hasNext()) {
			zVO = ita.next();
			addr.delete(0,addr.length());
			
			addr
			.append(zVO.getSido()).append(" ")
			.append(zVO.getGugun()).append(" ")
			.append(zVO.getDong()).append(" ")
			.append(zVO.getBunji());
			
			data = new String[2];
			data[0] = zVO.getZipcode();
			data[1] = addr.toString();
			
			//2.DefaultTableModel에 추가(addRow)
			dtm.addRow(data);
		}
		
		szv.getJtfDongName().setText("");
		
	}//searchZipcode
	
	
}//class
