package day0218;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

/**
 * ItemListenerDesign의 이벤트를 처리하기 위해서 만들어진 클래스 
 */
public class ItemLIstenerDesignEvent implements ItemListener, ActionListener {

	private UseItemListenerDesign uild;
	
	public ItemLIstenerDesignEvent( UseItemListenerDesign uild) {
		this.uild = uild;
	}
	
	/**
	 * JTextField에서 이벤트가 발생되었을 때 호출되는 method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField jtfEmail = uild.getJtfEmail();
		JTextField jtfDomain = uild.getJtfDomain();
		
		//이메일과 도메인을 받아와서 이메일 형태의 문자열을 만들고
		StringBuilder outputEmail = new StringBuilder();
		outputEmail.append(jtfEmail.getText()).append("@")
		.append(jtfDomain.getText());
		
		//라벨에 이메일을 출력
		uild.getEmailOutput().setText(outputEmail.toString());
		
		//텍스트필드 초기화
		jtfEmail.setText("");
		jtfDomain.setText("");
		jtfEmail.requestFocus();
	}

	/**
	 * JComboBox에서 이벤트가 발생되었을 때 호출되는 method
	 */
	boolean runFlag;
	@Override
	public void itemStateChanged(ItemEvent e) {
		//선택된 아이템을 받아와서(MVC pattern 도입된 Component)
		//사용자가 선택된 아이템의 번호를 받아와서(Viewer)
		if(runFlag) {
			int selectedIdx = uild.getJcbDomain().getSelectedIndex();
			//아이템 번호에 해당하는 아이템 값을 얻기.(Model)
			String domain = uild.getDcbm().getElementAt(selectedIdx);
			if("직접 입력".equals(domain)) {
				domain = "";
				uild.getJtfDomain().requestFocus();
			}
			uild.getJtfDomain().setText(domain);
		}
		runFlag = !runFlag;
	}

	
}
