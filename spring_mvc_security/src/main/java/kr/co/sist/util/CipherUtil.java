package kr.co.sist.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CipherUtil {

	public String sha(String plainText) {
		String sha = "";
		
		PasswordEncoder pe = new BCryptPasswordEncoder();
		sha = pe.encode(plainText);
		
		return sha;
		
	}
	
	public boolean shaMatches(String plainText, String bcrypText) {
		boolean flag = false;
		
		PasswordEncoder pe = new BCryptPasswordEncoder();
		flag= pe.matches(plainText, bcrypText);
		
		return flag;
		
	}
	
	@Value("${prj.key}")
	private String key;
	@Value("${prj.salt}")
	private String salt; //16진수로 변환 가능 8byte
	
	public String cipherText(String plainText) {
		String chiperText = "";
		TextEncryptor te = Encryptors.text(key, salt);
		chiperText = te.encrypt(plainText);
		return chiperText;
	}
	public String plainText(String cipherText) {
		String plainText = "";
		TextEncryptor te = Encryptors.text(key, salt);
		plainText = te.decrypt(cipherText);
		return plainText;
	}
}
