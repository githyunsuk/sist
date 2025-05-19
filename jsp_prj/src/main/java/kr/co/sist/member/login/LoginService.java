package kr.co.sist.member.login;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import kr.co.sist.cipher.DataDecryption;
import kr.co.sist.cipher.DataEncryption;

public class LoginService {

	public boolean loginProcess(LoginDTO lDTO, HttpSession session) {
		boolean flag = false;
		
		LoginDAO lDAO = LoginDAO.getInstance();
		try {
			//비밀번호를 일방향 Hash
			lDTO.setPass(DataEncryption.messageDigest("SHA-256", lDTO.getPass()));
			LoginResultDTO lrDTO = lDAO.selectId(lDTO);
			flag = lrDTO != null;
			
			if(flag) {
				
				//이름은 암호화 상태
				//이메일 복호화
				String key = "abcdef0123456789";
				DataDecryption dd = new DataDecryption(key);
				try {
					lrDTO.setEmail(dd.decrypt(lrDTO.getEmail()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//세션에 로그인한 결과를 할당.
				session.setAttribute("userData", lrDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return flag;
	}//loginProcess
}
