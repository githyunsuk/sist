package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.pstmt.dao.PreparedDAO;

class PstmtSelectTest {

	@DisplayName("검색")
	@Test
	void test() {
		PreparedDAO pDAO = PreparedDAO.getInstance();
//		assertDoesNotThrow(()->pDAO.selectAllMember());
		try {
			assertEquals(pDAO.selectAllMember().size(), 4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
