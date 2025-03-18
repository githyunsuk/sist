package day0220;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

@SuppressWarnings("all")
public class ExamWindowEvent extends WindowAdapter implements ActionListener, MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {

		// #. 유효성 검증
		// 빈공간 클릭시 Early Return
		if (ew.getJlData().getSelectedValue() == null) {
			System.out.print("");
			return;
		} // end if

		// 클릭한 DLM 배열로 데이터 쪼개 담기
		String[] clickDataArr = ew.getJlData().getSelectedValue().split(",");

		// '입력' 패널창에 차근차근 데이터 담자.
		ew.getJtfName().setText(clickDataArr[0]);
		ew.getJtfAge().setText(clickDataArr[1]);
		ew.getJtfPhoneNumber().setText(clickDataArr[3]);

		// 라디오버튼은 if문 써서 데이터 담아야되는구나.. 휴
		if (clickDataArr[2].equals(ew.getJrbMan().getText())) {
			ew.getJrbMan().setSelected(true);
		} // end if

		if (clickDataArr[2].equals(ew.getJrbWoman().getText())) {
			ew.getJrbWoman().setSelected(true);
		} // end if

	}

	/******************** 사용X ************************/
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/******************** 사용X ************************/

	private ExamWindow ew;
	private JButton jbtnAdd;
	private JButton jbtnChange;
	private JButton jbtnDelete;
	private JButton jbtnClose;
	private JButton jbtnAllRemove;

	public ExamWindowEvent(ExamWindow ew) {
		this.ew = ew;
		jbtnAdd = ew.getJbtnAdd();
		jbtnChange = ew.getJbtnChange();
		jbtnDelete = ew.getJbtnDelete();
		jbtnClose = ew.getJbtnClose();
		jbtnAllRemove = ew.getJbtnAllRemove();
	} // ExamWindowEvent

	public void windowClosing() {
		ew.dispose();
	} // windowClosing

	public void addList(String name, String age, String phoneNumber, String gender) {
		// 성별 선택 안되어있으면 Early Return
		if (!(ew.getJrbMan().isSelected() == true) && !(ew.getJrbWoman().isSelected() == true)) {
			return;
		} // end if

		// DLM 데이터에 추가
		ew.getDlm().addElement(name + "," + age + "," + gender + "," + phoneNumber);

		// Total JLabel 값 바꾸기
		ew.getJlblCount2().setText(String.valueOf(ew.getDlm().size()));
	}// addList

	public void deleteList(String name) {
		// #. 유효성 검증
		// 이름에 값을 입력안하고 삭제 버튼을 누르면 전부다 삭제되네? 아래 for문 안돌아야될텐데..
		// 비어있으면 Early Return 맥여버리자..
		if (ew.getJtfName().getText().isEmpty()) {
			return;
		} // end if

		// 리스트에 모든 데이터를 확인해보자.
		for (int i = 0; i < ew.getDlm().size(); i++) {
			if (ew.getDlm().getElementAt(i).startsWith(name) == true) {
				ew.getDlm().removeElementAt(i);
				i--; // 삭제하고 나면 인덱스가 바뀌는거 맞출려고 i-- 했습니다.
			} // end if
		} // end for

		// Total JLabel 값 바꾸기
		ew.getJlblCount2().setText(String.valueOf(ew.getDlm().size()));
	}// deleteList

	public void changeList(String name, String age, String phoneNumber, String gender) {
		// #. 유효성 검증(?)
		// #-1. 리스트에 아무 값도 없으면 에러나버리네 if 문으로 Early Return 해버리자고
		if (ew.getDlm().size() == 0) {
			return;
		} // end if

		// #-2. DLM에 이름과 같은 데이터가 없으면 Early Return
		for (int i = 0; i < ew.getDlm().size(); i++) {
			if (!(name.equals(ew.getDlm().getElementAt(i).substring(0, 3)))) {
				return;
			} // end if
		} // end for

		// 선택된거 인데스값 얻기
		int selectData = ew.getJlData().getSelectedIndex();

		// 받은 인덱스로 다시 채워넣기
		ew.getDlm().setElementAt(name + "," + age + "," + gender + "," + phoneNumber, selectData);
	}// changeList

	@Override
	public void windowClosing(WindowEvent e) {
		windowClosing();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		// 자주 쓰는 것들 변수에 담아보자
		String name = ew.getJtfName().getText();
		String age = ew.getJtfAge().getText();
		String phoneNumber = ew.getJtfPhoneNumber().getText();
		String gender = "";

		// 라디오버튼 선택값 String 변수 만들기
		if (ew.getJrbMan().isSelected() == true) {
			gender = ew.getJrbMan().getText();
		} // end if
		if (ew.getJrbWoman().isSelected() == true) {
			gender = ew.getJrbWoman().getText();
		} // end if

		// 버튼 별로 다중 이벤트 처리
		if (e.getSource() == jbtnClose) {
			windowClosing();
		} // 종료버튼
		if (e.getSource() == jbtnAdd) {
			addList(name, age, phoneNumber, gender);
		} // 추가버튼
		if (e.getSource() == jbtnChange) {
			changeList(name, age, phoneNumber, gender);
		} // 변경버튼
		if (e.getSource() == jbtnDelete) {
			deleteList(name);
		} // 삭제버튼
		if (e.getSource() == jbtnAllRemove) {
			ew.getDlm().removeAllElements();
			
			// Total JLabel 값 바꾸기
			ew.getJlblCount2().setText(String.valueOf(ew.getDlm().size()));
		} // 전부 삭제 버튼

	}// actionPerformed

}// class
