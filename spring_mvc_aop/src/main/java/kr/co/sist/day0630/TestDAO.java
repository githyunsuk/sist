package kr.co.sist.day0630;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	private Map<String, String> map;
	public TestDAO() {
		map = new HashMap<String, String>();
		map.put("kim", "김민진");
		map.put("lee", "이장훈");
		map.put("ju", "주현석");
	}

	public String selectName(String id) {
		
		System.out.println("[ DAO ] : selectName");
		String name = "";
		
		if(map.containsKey(id)) {
			name = map.get(id);
		}
		
		return name;
	}
}
