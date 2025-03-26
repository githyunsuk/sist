package kr.co.sist.service;

import java.io.IOException;
import java.sql.SQLException;

import kr.co.sist.dao.LobDAO;
import kr.co.sist.vo.LobVO;

public class LobService {
	public boolean addMember( LobVO lVO) {
		boolean flag=false;
		LobDAO lDAO=LobDAO.getInstance();
		
		try {
			lDAO.insertLob(lVO);
			 flag = true; 
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//addMember
	
	public LobVO searchMember(int num) {
		LobVO lVO=null;
		
		try {
			lVO=LobDAO.getInstance().selectLob(num);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return lVO;
	}//searchMember
	
}//class
