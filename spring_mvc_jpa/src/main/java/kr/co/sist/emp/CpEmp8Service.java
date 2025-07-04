package kr.co.sist.emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpEmp8Service {

	@Autowired(required = false)
	private CpEmp8Repository cer;
	
	/**
	 * 모든 Entity를 조회
	 * @return
	 */
	public List<CpEmp8Entity> searchAllCpEmp8(){
		return cer.findAll();
	}
	
	/**
	 * 입력되는 Entity 객체 @Id값이 Target table에 존재하지 않으면 insert,
	 * 존재하면 update
	 * @param cee
	 * @return
	 */
	public CpEmp8Entity addModifyCpEmp8(CpEmp8Entity cee) throws IllegalArgumentException {
		if(cee.getEmpno() != null && !(cee.getEmpno() > 0 && cee.getEmpno() < 10000)) {
			throw new IllegalArgumentException("사원번호는 0~9999까지만 가능합니다.");
		}
		
		CpEmp8Entity ce8 = cer.save(cee);
		
		return ce8;
	}
	
	public CpEmp8Entity searchOneEmp(int empno) {
		CpEmp8Entity ceeResult = null;
		
		Optional<CpEmp8Entity> optional = cer.findById(empno);
		
		//사원번호가 입력 되었을 때 사원 번호로 검색된 객체가 있는지?
//		System.out.println(optional.isPresent());
		if(optional.isPresent()) { //객체가 존재하면
			ceeResult = optional.get(); //객체를 얻는다.
		}
		
		return ceeResult;
	}
	
	public boolean removeCpEmp(int empno) {
		boolean flag = cer.existsById(empno);
		System.out.println("레코드가 존재 : " + cer.existsById(empno));
		if(flag) {
			cer.deleteById(empno);
		}
		return flag;
	}
}
