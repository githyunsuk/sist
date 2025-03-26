package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.dao.DbConnection;

class ConnTest {

	@DisplayName("DB연동 테스트")
	@Test
	void test() {
		DbConnection dbCon = DbConnection.getInstance();
		
		assertDoesNotThrow(()-> dbCon.getConn());
	}

}
