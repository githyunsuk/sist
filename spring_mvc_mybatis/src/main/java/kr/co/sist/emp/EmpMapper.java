package kr.co.sist.emp;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {

	public List<Integer> selectAllDept();
	
	public List<EmpDomain> selectDeptEmp(int deptno);
	
	public int insertEmp(EmpDTO eDTO);
	
	public int insertEmp2(EmpDTO eDTO);

}
