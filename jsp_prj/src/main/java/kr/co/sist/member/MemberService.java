package kr.co.sist.member;

import java.sql.SQLException;

public class MemberService {

	public boolean searchId(String id) {
		boolean flag = false;
		MemberDAO mDao = MemberDAO.getInstance();
		try {
			flag = mDao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}//searchId
	
	public boolean addMember(MemberDTO mDTO) {
		boolean flag = false;
		//mDTO객체의 값 중 email과 domain을 합쳐서 useEmail할당
		mDTO.setUseEmail(mDTO.getEmail() + "@" + mDTO.getDomain());
		
		MemberDAO mDAO = MemberDAO.getInstance();
		try {
			mDAO.insertMember(mDTO);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}//addMember
}
