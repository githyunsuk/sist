package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.stmt.dao.StatementDAO;
import kr.co.sist.stmt.service.StatementService;

class StmtDeleteTest {

	@DisplayName("삭제 테스트")
	@Test
	void test() {
//		StatementDAO sd = new StatementDAO();
//		try {
//			assertEquals(sd.deleteStmtMember(1), 1);
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
		int num=2;
		StatementService ss = new StatementService(null);
		assertTrue(ss.removeStmtMember(num));
	}

}
