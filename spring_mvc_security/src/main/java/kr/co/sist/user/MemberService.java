package kr.co.sist.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import kr.co.sist.util.CipherUtil;

@Service
public class MemberService {

	@Autowired
	private CipherUtil cu;
	
	@Autowired(required = false)
	private MemberMapper mm;
	
	@Transactional
	public boolean addMember(MemberDTO mDTO) {
		boolean flag = false;
		//이메일 = 이메일1 + 도메인
		mDTO.setEmail(mDTO.getEmail() + "@" + mDTO.getDomain());
		
		//일방향 hash : 비밀번호
		mDTO.setPass(cu.sha(mDTO.getPass()));
		
		//암호문 : 이름, 전화번호, 이메일
		mDTO.setName(cu.cipherText(mDTO.getName()));
		mDTO.setTel(cu.cipherText(mDTO.getTel()));
		mDTO.setEmail(cu.cipherText(mDTO.getEmail()));
		
		flag = mm.insertMember(mDTO) == 1 ;
		
		return flag;
	}
	
	/**
	 * 로그인 결과를 JSONObject로 반환
	 * @param lDTO
	 * @return
	 */
	public String searchLogin(LoginDTO lDTO) {
		MemberDomain md = null;
		String jsonObj = "";
		
		md = mm.selectLogin(lDTO.getId());
		if( md != null ) {
			//비밀번호 비교
			if(cu.shaMatches(lDTO.getPass(), md.getPass())){
				//복호화
				md.setName(cu.plainText(md.getName()));
				md.setTel(cu.plainText(md.getTel()));
				md.setEmail(cu.plainText(md.getEmail()));
			} else {
				md = null; //비번이 틀리면 null 설정
			}
		}
		
		ObjectMapper objMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultFlag", md != null);
		
		if(md != null) {
			map.put("name", md.getName());
			map.put("tel", md.getTel());
			map.put("email", md.getEmail());
		}
		
		try {
			jsonObj = objMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonObj;
	}
}
