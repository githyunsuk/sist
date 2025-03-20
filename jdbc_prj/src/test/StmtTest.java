package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.stmt.service.StatementService;
import kr.co.sist.vo.StatementMemberVO;

class StmtTest {

//	@DisplayName("insert 테스트")
	@DisplayName("update 테스트")
	@Test
	void test() {
//		StatementMemberVO smVO = new StatementMemberVO(0,20,"테스트2","남자","010-1111-1111", null);
//		
//		StatementDAO sd = new StatementDAO();
//		
//		assertDoesNotThrow(()->sd.insertStmtMember(smVO));
		StatementMemberVO smVO = new StatementMemberVO(1,27,null,null,"010-9999-9999", null);
		
//		StatementDAO sd = new StatementDAO();
		
//		assertDoesNotThrow(()->sd.insertStmtMember(smVO));
//		try {
////			assertEquals(sd.updateStmtMember(smVO), 1); //반환된 값이 해당 값과 같다면
//			assertNotEquals(sd.updateStmtMember(smVO), 0); //반환된 값이 해당값과 같지 않다면
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		assertDoesNotThrow(()->sd.updateStmtMember(smVO));
//		assertThrows(SQLException.class, ()->sd.updateStmtMember(smVO));
		StatementService ss = new StatementService(null);
		assertTrue(ss.modifyStmtMember(smVO));
	}//test

}
