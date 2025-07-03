package kr.co.sist.emp;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("empDomain")
@Getter
@Setter
@ToString
public class EmpDomain {
	private int empno, mgr, sal, comm, deptno;
	private String ename, job;
	private Date hiredate;
	
}
