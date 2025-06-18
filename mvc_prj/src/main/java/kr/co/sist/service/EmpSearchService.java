package kr.co.sist.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.MvcDAO;
import kr.co.sist.domain.Emp;
import kr.co.sist.dto.SearchDTO;

public class EmpSearchService {

	public List<Emp> searchEmp(SearchDTO sDTO){
		List<Emp> list = null;
		
		MvcDAO mDAO = MvcDAO.getInstance();
		try {
		list = mDAO.selecEmp(sDTO);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
}
