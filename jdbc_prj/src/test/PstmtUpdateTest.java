package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.pstmt.dao.PreparedDAO;
import kr.co.sist.vo.PstmtMemberVO;

class PstmtUpdateTest {

	@DisplayName("변경 테스트")
	@Test
	void test() {
		PstmtMemberVO pmVO = new PstmtMemberVO(1,"이장훈2",30,"남자","010-1234-4321",null,null);
		
		PreparedDAO pDAO = PreparedDAO.getInstance();
//		assertDoesNotThrow(()->pDAO.updatePstmtMember(pmVO));
		try {
			assertEquals(pDAO.updatePstmtMember(pmVO), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
