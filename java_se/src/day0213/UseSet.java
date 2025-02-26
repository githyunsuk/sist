package day0213;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set: 검색의 기능이 없으며, 중복 값을 저장하지 않는 자료구조.
 * 입력값은 순차적으로 입력되지 않는다. 
 */
public class UseSet {

	public UseSet() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("Java 1");
		set.add("Oracle 2");
		set.add("JDBC 3");
		set.add("HTML 4");
		set.add("CSS 5");
		set.add("JavaScript 6");
		set.add("강태일");
		set.add("강태일");
		
		//요소를 배열로 복사
		//set 크기로 배열을 생성
		String[] arr = new String[set.size()];
		//set의 내용을 배열로 복사
		set.toArray(arr);
		
		//요소 삭제.
		set.remove("CSS 5");
		set.clear();
		
		//검색의 기능이 없음. => java.util.Iterator를 사용.
		Iterator<String> ita = set.iterator();
		
		System.out.println(ita);
		System.out.println(set + " / " + set.size());
		
		for(String data: arr) {
			System.out.println(data);
		}
	}

	public static void main(String[] args) {

		new UseSet();
	}

}
