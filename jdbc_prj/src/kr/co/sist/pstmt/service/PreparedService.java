package kr.co.sist.pstmt.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.pstmt.dao.PreparedDAO;
import kr.co.sist.vo.PstmtMemberVO;
import kr.co.sist.vo.StatementMemberVO;

/**
 * BL(Business Logic)을 구현하기 위한 클래스.
 */
public class PreparedService {


	public PreparedService() {
	}

	/**
	 * 업무로직: 나이는 20~30대만 입력. 만약 해당 나이가 아니면 20으로 설정
	 * 
	 * @param smVO
	 */
	public boolean addPstmtMember(PstmtMemberVO pmVO) {
		boolean flag = false;
		PreparedDAO pDAO = PreparedDAO.getInstance();
		try {
			pDAO.insertPstmtMember(pmVO);
			flag = true;
		} catch(SQLException e) {
			e.addSuppressed(e);
		}
		
		return flag;
		
	}// addStmtMember

	public boolean modifyPstmtMember(PstmtMemberVO pmVO) {
		boolean flag = false;
		
		PreparedDAO pDAO = PreparedDAO.getInstance();
		try {
			flag = pDAO.updatePstmtMember(pmVO) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}// modifyStmtMember

	public boolean removePstmtMember(int num) {
		boolean flag = false;
		
		PreparedDAO pdao = PreparedDAO.getInstance();
		
		try {
			flag = pdao.deletePstmtMember(num)==1;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}//removeStmtMember
	
	public int searchAllCnt() {
		int cnt = 0;
		
		PreparedDAO pDAO = PreparedDAO.getInstance();
		try {
			cnt = pDAO.selectPstmtCntMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}//searchAllCnt
	
	public List<PstmtMemberVO> searchAllMember(){
		List<PstmtMemberVO> list = null;
		
		PreparedDAO pDAO = PreparedDAO.getInstance();
		try {
			list = pDAO.selectAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}//searchAllMember
	
	/**
	 * 한 행 조회
	 * @param num
	 * @return
	 */
	public PstmtMemberVO searchOneMember(int num) {
		PstmtMemberVO pmVO = null;
		PreparedDAO pDAO = PreparedDAO.getInstance();
		
		try {
			pmVO = pDAO.selectOneMember(num);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return pmVO;
	}//searchOneMember

}
