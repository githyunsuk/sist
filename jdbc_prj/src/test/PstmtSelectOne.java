package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.pstmt.dao.PreparedDAO;

class PstmtSelectOne {

	@DisplayName("한행 조회")
	@Test
	void test() {
		PreparedDAO pDAO = PreparedDAO.getInstance();
		int num = 1;
		assertDoesNotThrow(()->pDAO.selectOneMember(num));
	}

}
