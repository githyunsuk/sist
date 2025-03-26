package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.pstmt.dao.PreparedDAO;

class PstmtDeleteTest {

	@DisplayName("삭제")
	@Test
	void test() {
		PreparedDAO pdao = PreparedDAO.getInstance();
//		assertDoesNotThrow(()->pdao.deletePstmtMember(1));
		try {
			assertEquals(pdao.deletePstmtMember(2), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
