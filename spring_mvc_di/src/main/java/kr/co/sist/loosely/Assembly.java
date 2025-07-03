package kr.co.sist.loosely;

import org.springframework.stereotype.Component;

/**
 * 1.의존성 주입할 객체를 생성, 
 * 2.의존성 주입을 받을 객체를 생성, 의존성 주입하고,
 * 3.의존성 주입 받은 객체를 반환 
 */
@Component
public class Assembly {
	
	public Service getBean() {
		//1.
		MySqlDAOImpl dao=new MySqlDAOImpl();
//		OracleDAOImpl dao=new OracleDAOImpl();
		//2.
		Service service=new ServiceImpl(dao);
		//3.
		return service;
		
	}
	
}
