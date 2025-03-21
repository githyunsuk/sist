package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.stmt.dao.StatementDAO;

class StmtSelectTest {

	@DisplayName("select 테스트")
	@Test
	void test() {
		StatementDAO sd = new StatementDAO();
//		assertNotEquals(sd.selectCntStmtMember(), 0);
		try {
//			assertEquals(sd.selectAllStmtMember(), 10);
			//오차범위: 조회된 레코드 수, 예상조회레코드 수, 오차 범위
			assertEquals(sd.selectAllStmtMember().size(),10,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
