package kr.co.sist.stmt.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import kr.co.sist.stmt.design.StatementWindow;
import kr.co.sist.stmt.service.StatementService;
import kr.co.sist.vo.StatementMemberVO;

@SuppressWarnings("all")
public class StatementWindowEvent extends WindowAdapter implements ActionListener, MouseListener {

	private StatementWindow ew;
	private JButton jbtnAdd;
	private JButton jbtnChange;
	private JButton jbtnDelete;
	private JButton jbtnClose;

	public StatementWindowEvent(StatementWindow ew) {
		this.ew = ew;
		jbtnAdd = ew.getJbtnAdd();
		jbtnChange = ew.getJbtnChange();
		jbtnDelete = ew.getJbtnDelete();
		jbtnClose = ew.getJbtnClose();
	} // ExamWindowEvent

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

	public void windowClosing() {
		ew.dispose();
	} // windowClosing

	public void addMember(StatementMemberVO sVO) {
		// 성별 선택 안되어있으면 Early Return
		if (sVO.getGender().isEmpty()) {
			JOptionPane.showMessageDialog(ew, "성별 선택해");
			return;
		} // end if
		
		//업무로직을 처리
		StatementService ss = new StatementService(ew);
		ss.addStmtMember(sVO);

		//레코드 추가 후 입력 필드를 초기화
		ew.getJtfName().setText("");
		ew.getJtfAge().setText("");
		ew.getJtfPhoneNumber().setText("");
		ew.getJtfName().requestFocus();
		// Total JLabel 값 바꾸기
		ew.getJlblCount2().setText(String.valueOf(ew.getDlm().size()));
	}// addList
	
	public void modifyMember(StatementMemberVO smVO) {
		//업무로직을 처리
		StatementService ss = new StatementService(ew);
		smVO.setNum(1);
		String alertMsg="회원 정보 변경 실패";
		if(ss.modifyStmtMember(smVO)) {
			alertMsg = "회원정보가 성공적으로 변경되었습니다.";
		} //변경을 수행
		
		JOptionPane.showMessageDialog(ew, alertMsg);

		//레코드 추가 후 입력 필드를 초기화
		ew.getJtfName().setText("");
		ew.getJtfAge().setText("");
		ew.getJtfPhoneNumber().setText("");
		ew.getJtfName().requestFocus();
	}

	public void removeMember(int num) {
		
		StatementService ss = new StatementService(ew);
		String alterMsg = "회원 정보를 삭제하지 못하였습니다.";
		if(ss.removeStmtMember(num)) {
			alterMsg = "회원 정보를 삭제하였습니다.";
		}
		JOptionPane.showMessageDialog(ew, alterMsg);
		
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

		// 버튼 별로 다중 이벤트 처리
		if (e.getSource() == jbtnClose) {
			windowClosing();
		} // 종료버튼
		if (e.getSource() == jbtnAdd) {
			// 라디오버튼 선택값 String 변수 만들기
			if (ew.getJrbMan().isSelected()) {
				gender = ew.getJrbMan().getText();
			} // end if
			if (ew.getJrbWoman().isSelected()) {
				gender = ew.getJrbWoman().getText();
			} // end if

			try {
				//입력된 값을 VO객체에 할당
				StatementMemberVO smVO = new StatementMemberVO(0, Integer.parseInt(age), name, gender, phoneNumber, null);
				addMember(smVO); //업무로직을 처리
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(ew, "나이에 숫자를 입력해");
			}
		} // 추가버튼
		if (e.getSource() == jbtnChange) {
			try {
				//입력된 값을 VO객체에 할당
				StatementMemberVO smVO = new StatementMemberVO(0, Integer.parseInt(age), name, gender, phoneNumber, null);
				modifyMember(smVO); //업무로직을 처리
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(ew, "나이에 숫자를 입력해");
			}
		} // 변경버튼
		if (e.getSource() == jbtnDelete) {
			int num = 3;
			removeMember(num);
		} // 삭제버튼

	}// actionPerformed

}// class
