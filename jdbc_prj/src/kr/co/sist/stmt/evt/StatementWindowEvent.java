package kr.co.sist.stmt.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
	private StatementService ss;
	
	private int selectedNum;

	public StatementWindowEvent(StatementWindow ew) {
		this.ew = ew;
		selectedNum = -1; //선택되지 않음
		jbtnAdd = ew.getJbtnAdd();
		jbtnChange = ew.getJbtnChange();
		jbtnDelete = ew.getJbtnDelete();
		jbtnClose = ew.getJbtnClose();
		
		ss = new StatementService(ew);
		changeList();
		ew.getJlblCount2().setText(String.valueOf(ss.searchAllCnt()));
	} // ExamWindowEvent

	@Override
	public void mouseClicked(MouseEvent e) {
		// 클릭한 아이템의 값을 DLM에서 얻어와서 배열로 저장
		String[] clickDataArr = ew.getJlData().getSelectedValue().split(",");
		
		//선택한 번호를 인스턴스 변수에 설정한다.
		selectedNum = Integer.parseInt(clickDataArr[0]);

		// '입력' 패널창에 차근차근 데이터 담자.
		ew.getJtfName().setText(clickDataArr[1]);
		ew.getJtfAge().setText(clickDataArr[2]);
		ew.getJtfPhoneNumber().setText(clickDataArr[4]);

		//선택한 값과 라디오버튼의 라벨을 비교
		JRadioButton jrbTemp = ew.getJrbWoman();
		if (clickDataArr[3].equals(ew.getJrbMan().getText())) {
			jrbTemp=ew.getJrbMan();
		}
		jrbTemp.setSelected(true);
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
		ss.addStmtMember(sVO);
		
		inputFieldReset();

		// Total JLabel 값 바꾸기
		ew.getJlblCount2().setText(String.valueOf(ss.searchAllCnt()));
	}// addList
	
	private void inputFieldReset() {
		//레코드 추가 후 입력 필드를 초기화
		ew.getJtfName().setText("");
		ew.getJtfAge().setText("");
		ew.getJtfPhoneNumber().setText("");
		ew.getJtfName().requestFocus();
		
		changeList();
	}
	private boolean numValidate() {
		boolean flag = false;
		if(flag = (selectedNum == -1)) {
			JOptionPane.showMessageDialog(ew, "리스트에서 아이템을 클릭해주세요..");
		}
		return flag;
		
	}
	public void modifyMember(StatementMemberVO smVO) {
		
		if(numValidate()) return;
		
		//업무로직을 처리
		smVO.setNum(selectedNum);
		String alertMsg="회원 정보 변경 실패";
		if(ss.modifyStmtMember(smVO)) {
			alertMsg = "회원정보가 성공적으로 변경되었습니다.";
		} //변경을 수행
		
		JOptionPane.showMessageDialog(ew, alertMsg);
		inputFieldReset();
		selectedNum = -1;
	}
	
	public void removeMember() {
		
		if(numValidate()) {
			return;
		}
		
		String alterMsg = "회원 정보를 삭제하지 못하였습니다.";
		if(ss.removeStmtMember(selectedNum)) {
			alterMsg = "회원 정보를 삭제하였습니다.";
		}
		JOptionPane.showMessageDialog(ew, alterMsg);
		
		inputFieldReset();
		// Total JLabel 값 바꾸기
		ew.getJlblCount2().setText(String.valueOf(ss.searchAllCnt()));
		
		selectedNum = -1;
	}// deleteList

	public void changeList() {
		//DBMS에서 모든 회원정보를 검색하여
		List<StatementMemberVO> list = ss.searchAllMember();
		//JList에 추가
		StringBuilder modelData = new StringBuilder();
		//모델에 값을 추가하기 전에 모든 데이터를 초기화
		ew.getDlm().removeAllElements();
		for(StatementMemberVO smVO : list) {
			modelData.delete(0, modelData.length());
			modelData
			.append(smVO.getNum()).append(",")
			.append(smVO.getName()).append(",")
			.append(smVO.getAge()).append(",")
			.append(smVO.getGender()).append(",")
			.append(smVO.getTel()).append(",")
			.append(smVO.getInputDate());
			ew.getDlm().addElement(modelData.toString());
		}
		
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
			removeMember();
		} // 삭제버튼

	}// actionPerformed

}// class
