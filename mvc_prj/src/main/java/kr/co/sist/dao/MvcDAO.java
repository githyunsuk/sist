package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.Emp;
import kr.co.sist.dto.SearchDTO;

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

	
	public List<Emp> selecEmp(SearchDTO sDTO) throws PersistenceException {
		List<Emp> list = null;
		// 1.MyBatis Handler 얻기
		SqlSession ss = MyBatisDAO.getInstance("kr/co/sist/dao/mybatis-config.xml").getMyBatisHandler();
		// 2.쿼리를 실행 <파라메터 속성이 사용되지 않으므로
		list = ss.selectList("kr.co.sist.dao.selectEmp", sDTO);
		
		// 검색 결과
		// 4.MyBatis Handler 끊기
		ss.close();
		
		return list;
	}

	public static void main(String[] args) {
		try {
			SearchDTO sDTO = new SearchDTO();
			sDTO.setDeptno(10);
			sDTO.setSal(5000);
			MvcDAO.getInstance().selecEmp(sDTO);
			System.out.println(MvcDAO.getInstance().selecEmp(sDTO));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

	}

}// class
