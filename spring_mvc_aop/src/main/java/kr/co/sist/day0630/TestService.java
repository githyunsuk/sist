package kr.co.sist.day0630;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired(required = false)
	private TestDAO tDAO;
	
	public String searchName(String id) {
		String name = "";
		
		System.out.println("[ service ] : searchName");
		name = tDAO.selectName(id);
		
		return name;
	}
}
