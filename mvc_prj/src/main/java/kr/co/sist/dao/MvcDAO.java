package kr.co.sist.dao;

import java.util.HashMap;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisDAO;

public class MvcDAO {

	private static MvcDAO sDAO;

	private MvcDAO() {
	}

	public static MvcDAO getInstance() {
		if (sDAO == null) {
			sDAO = new MvcDAO();
		} // end if
		return sDAO;
	}// getInstance

	
	public void selectProc(HashMap<String, Object> hashmap) throws PersistenceException {
		// 1.MyBatis Handler 얻기
		SqlSession ss = MyBatisDAO.getInstance("kr/co/sist/dao/mybatis-config.xml").getMyBatisHandler();
		// 2.쿼리를 실행 <파라메터 속성이 사용되지 않으므로
		ss.selectOne("kr.co.sist.day0616.procedureSelect", hashmap);
		
		// 검색 결과
		// 4.MyBatis Handler 끊기
		ss.close();
	}

	public static void main(String[] args) {
		try {
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

	}

}// class
