package kr.co.sist.stmt.service;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.stmt.dao.StatementDAO;
import kr.co.sist.stmt.design.StatementWindow;
import kr.co.sist.vo.StatementMemberVO;

/**
 * BL(Business Logic)을 구현하기 위한 클래스. 
 */
public class StatementService {
	
	private StatementWindow sw;
	
	public StatementService(StatementWindow sw) {
		this.sw = sw;
	}
	
	/**
	 * 업무로직: 나이는 20~30대만 입력. 만약 해당 나이가 아니면 20으로 설정
	 * @param smVO
	 */
	public void addStmtMember(StatementMemberVO smVO) {
		StatementDAO sDAO = new StatementDAO();
		
		//업무로직 처리
//		if(!(smVO.getAge() > 19 && smVO.getAge() < 40)) {
//			smVO.setAge(20);
//		}
		StringBuilder resultMsg = new StringBuilder();
		try {
			sDAO.insertStmtMember(smVO);
			resultMsg.append(smVO.getName()).append("님의 회원 정보 추가 성공");
		} catch (SQLException e) {
			switch(e.getErrorCode()) {
			case 1400: resultMsg.append("이름은 필수 입력"); break;
			case 1438: resultMsg.append("나이는 0~999까지만 입력 가능."); break;
			case 12899: resultMsg.append("이름은 한글 10자, 영어 30자, 전화번호는 '-'포함 13글자 입니다."); break;
			}
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(sw, resultMsg.toString());
		}
	}//addStmtMember
	
}
