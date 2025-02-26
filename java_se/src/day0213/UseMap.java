package day0213;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseMap {

	public void useHashtable() {
		
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("java", "완벽한 oop 언어");
		map.put("oracle", "대용량 dbms");
		map.put("jdbc", "저수준 API");
		
		//동일키
		map.put("java", "wora");
		
		String key = "java";
		System.out.println(map.containsKey(key));
		
		if( map.containsKey(key) ) {
			String value = map.get(key);
			System.out.println(key + ":" + value );
		}
		//모든 키 얻기
		Set<String> set = map.keySet();
		for(String tempKey : set) {
			System.out.println(tempKey);
		}
		
		//맵의 모든 행의 값 출력
		Iterator<String> ita = set.iterator();
		
		while(ita.hasNext()) {
			key = ita.next();
			System.out.println(key+"의 값은 "+map.get(key));
		}
		
		//map의 값 삭제
		map.remove("java");
		
		
		System.out.println(map + " / " + map.size());
	}
	
	public void useHashMap() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("java", "완벽한 oop 언어");
		map.put("oracle", "대용량 dbms");
		map.put("jdbc", "저수준 API");
		
		//동일키
		map.put("java", "wora");
		
		String key = "java";
		System.out.println(map.containsKey(key));
		
		if( map.containsKey(key) ) {
			String value = map.get(key);
			System.out.println(key + ":" + value );
		}
		//모든 키 얻기
		Set<String> set = map.keySet();
		for(String tempKey : set) {
			System.out.println(tempKey);
		}
		
		//맵의 모든 행의 값 출력
		Iterator<String> ita = set.iterator();
		
		while(ita.hasNext()) {
			key = ita.next();
			System.out.println(key+"의 값은 "+map.get(key));
		}
		
		//map의 값 삭제
		map.remove("java");
		
		
		System.out.println(map + " / " + map.size());
		
	}
	public static void main(String[] args) {

		UseMap um = new UseMap();
		System.out.println("-------------HashTable사용----------------");
		um.useHashtable();
		System.out.println("-------------HashMap사용------------------");
		um.useHashMap();
	}

}
