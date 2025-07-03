package kr.co.sist.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmpService {
	
	@Autowired(required = false)
	private EmpMapper em;
	
	public List<Integer> searchAllDept(){
		return em.selectAllDept();
	}
	
	public List<EmpDomain> searchDeptEmp(int deptno){
		return em.selectDeptEmp(deptno);
	}
	
	@Transactional
	public int addEmp(EmpDTO eDTO) throws Exception {
		int cnt = 0;
		cnt = em.insertEmp(eDTO);
		int cnt2 = 0;
		cnt2 = em.insertEmp2(eDTO);
		return cnt + cnt2;
	}
}
