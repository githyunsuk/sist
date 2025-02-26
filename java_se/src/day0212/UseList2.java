package day0212;

import java.util.LinkedList;
import java.util.List;

public class UseList2 {

	public UseList2() {
		//1.리스트 생성)
		List<String> nameList = new LinkedList<String>();
		//2.값 할당)
		nameList.add("java");
		nameList.add("jdbc");
		nameList.add("html");
		nameList.add("css");
		
		nameList.add(1, "oracle");
		System.out.println(nameList);
		
		for(String subject : nameList) {
			System.out.println(subject);
		}
	}
	public static void main(String[] args) {
		
		new UseList2();
	}
}
