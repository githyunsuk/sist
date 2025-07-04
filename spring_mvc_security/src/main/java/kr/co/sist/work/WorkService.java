package kr.co.sist.work;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WorkService {

	public String bcrypt( String pass ) {
		
		String sha = "";
		//1.PasswordEncoder 생성
		PasswordEncoder pe = new BCryptPasswordEncoder();
		//2.일방향 해시생성
		sha = pe.encode(pass);
		System.out.println("비교");
		//
		String temp = "$2a$10$5huFxxBQtASlQmtU4OZ4ROQCKglM4SFbNKBvN.kPxiWB2q9gzTbTW";
		System.out.println(pe.matches(pass, temp));
		return sha;
	}
	
	public String cipher(String email) {
		String key = "sist123456789";
		String salt = "f1f1f1f1f1f1f1f1"; //16진수로 변환가능( 8byte의 문자열
		
		String chiperText="";
		
		//1.암호화 객체 얻기
		TextEncryptor te = Encryptors.text(key, salt);
		
		//2.평문 -> 암호문
		chiperText = te.encrypt(email);
		
		return chiperText;
	}
	
	public String plain(String cipherEmail) {
		String key = "sist123456789";
		String salt = "f1f1f1f1f1f1f1f1"; //16진수로 변환가능( 8byte의 문자열
		
		String plainText="";
		
		//1.암호화 객체 얻기
		TextEncryptor te = Encryptors.text(key, salt);
		
		//2.암호문 -> 평문
		plainText = te.decrypt(cipherEmail);
		
		return plainText;
	}
}
