package kr.co.sist.emp;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("empDTO")
@Getter
@Setter
@ToString
public class EmpDTO {
	private int empno, mgr, sal, comm, deptno;
	private String ename, job;
	private Date hiredate;
	
}
