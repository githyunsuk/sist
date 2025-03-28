package day0328;

import java.sql.SQLException;

public class LoginService {

	public String login(LoginVO lVO) {
		String name = "";
		
		try {
			//Statement: SQLInjection 발생 > 대비코드 작성
//			name = LoginDAO.getInstance().selectLogin(lVO);
			
			//PreparedStatement: SQLInjection 발생
			name = LoginDAO.getInstance().selectPstmtLogin(lVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
}
