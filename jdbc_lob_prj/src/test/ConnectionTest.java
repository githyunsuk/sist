package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.dao.DbConnection;

class ConnectionTest {
	@DisplayName("디비 연결")
	@Test
	void test() {
		DbConnection db=DbConnection.getInstance();
//		assertDoesNotThrow( ()->db.getConn() );
		try {
			assertNotNull(db.getConn() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}

}
