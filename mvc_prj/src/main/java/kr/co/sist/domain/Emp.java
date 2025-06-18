package kr.co.sist.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Emp {
	private int empno, sal;
	private String ename, job;
	private Date hiredate;
}
