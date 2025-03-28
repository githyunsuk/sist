package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day0328.LoginDAO;
import day0328.LoginVO;

class TestLogin {

	@DisplayName("로그인 테스트")
	@Test
	void test() {
		LoginVO lvo = new LoginVO("kang","1234");
		LoginDAO lDAO = LoginDAO.getInstance();
		
//		assertDoesNotThrow(()->lDAO.selectLogin(lvo));
		try {
			assertNotEquals(lDAO.selectLogin(lvo), "");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
