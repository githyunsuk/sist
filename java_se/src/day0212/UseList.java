package day0212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * List 사용 -가변 길이형 -값은 순차적으로 입력되고, 순차적으로 출력된다. -검색의 기능이 있으며, 값은 중복될 수 있다.
 */
public class UseList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void notUsingGeneric() {
		//1.Generic을 사용하지 않은 객체화
		List list = new ArrayList();
		//2.값 할당: 모든 객체를 할당 할 수 있다.(편의성)
		list.add(2025);
		list.add(2);
		list.add(12);
		//3.값 사용: 입력되는 객체에 따라 값을 얻을 때 에러가 발생할 수 있다.
		System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2));
	}

	public void useArrayList() {
		//1.생성)
		List<String> list = new ArrayList<String>();
		//2.값 할당) -> 값을 추가할 때 마다 방의 개수가 증가한다.(가변 길이형)
		list.add("안녕하세요?");
		list.add("오늘은");
		list.add("수요일");
		list.add("입니다.");
		//Generic에 해당하지 않는 데이터형을 추가하면 에러 발생
		//list.add(2025);
		list.add("수요일");
		list.add("눈 그쳤음.");
		
		//배열에 복사
		String [] strArr = new String[list.size()];
		list.toArray(strArr);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2025); //원래는 안들어가는게 정상
		list2.add(2);
		list2.add(3000);
		
		Integer[] intArr = new Integer[list2.size()];
		list2.toArray(intArr); //배열로 복사

		String temp = list.get(0);
		Integer i = list2.get(0);
		int iv = list2.get(0); //unboxing : wrapper가 반환되면 wrapper class의 method를
		//호출하여 (int value()) 기본형 데이터형에 할당을 해준다.
		
		System.out.println(temp);
		System.out.println(i);
		System.out.println(iv);
		
		System.out.println(list + " / 방의 개수:" + list.size());
		System.out.println(list2 + " / 방의 개수:" + list2.size());
		
		temp="";
		for(i=0; i<list.size(); i++) {
			temp = list.get(i); //리스트에서 인덱스에 해당하는 값을 얻어서
			System.out.println(temp);
		}
		
		for(Integer j: list2) {
			System.out.println(j);
		}
		
		//삭제.
		//인덱스
		list.remove(1);
		//방의 내용과 일치하는 방 삭제
		list.remove("오늘은");
		//모든 방의 값 삭제:
		list.clear();
		System.out.println(list + " / 방의 개수:" + list.size());
		
		System.out.println("배열의 방의 값 출력");
		System.out.println(Arrays.toString(strArr));
		System.out.println(Arrays.toString(intArr));
		//배열을 정렬
		System.out.println();
		//Arrays.sort(intArr);
		Arrays.sort(intArr, Collections.reverseOrder());
		System.out.println(Arrays.toString(intArr));
		
		System.out.println("리스트가 비었는지?");
		System.out.println("String:" + list.isEmpty());
		System.out.println("Integer:" + list2 .isEmpty());

	}

	public void useVector() {

		List<String> list = new Vector<String>();
		list.add("안녕하세요?");
		list.add("오늘은");
		list.add("수요일");
		list.add("입니다.");
		//Generic에 해당하지 않는 데이터형을 추가하면 에러 발생
		//list.add(2025);
		list.add("수요일");
		list.add("눈 그쳤음.");
		
		//배열에 복사
		String [] strArr = new String[list.size()];
		list.toArray(strArr);
		
		List<Integer> list2 = new Vector<Integer>();
		list2.add(2025); //원래는 안들어가는게 정상
		list2.add(2);
		list2.add(3000);
		
		Integer[] intArr = new Integer[list2.size()];
		list2.toArray(intArr); //배열로 복사
		
		String temp = list.get(0);
		Integer i = list2.get(0);
		int iv = list2.get(0); //unboxing : wrapper가 반환되면 wrapper class의 method를
		//호출하여 (int value()) 기본형 데이터형에 할당을 해준다.
		
		System.out.println(temp);
		System.out.println(i);
		System.out.println(iv);
		
		System.out.println(list + " / 방의 개수:" + list.size());
		System.out.println(list2 + " / 방의 개수:" + list2.size());
		
		temp="";
		for(i=0; i<list.size(); i++) {
			temp = list.get(i); //리스트에서 인덱스에 해당하는 값을 얻어서
			System.out.println(temp);
		}
		
		for(Integer j: list2) {
			System.out.println(j);
		}
		
		//삭제.
		//인덱스
		list.remove(1);
		//방의 내용과 일치하는 방 삭제
		list.remove("오늘은");
		//모든 방의 값 삭제:
		list.clear();
		System.out.println(list + " / 방의 개수:" + list.size());
		
		System.out.println("배열의 방의 값 출력");
		System.out.println(Arrays.toString(strArr));
		System.out.println(Arrays.toString(intArr));
		//배열을 정렬
		System.out.println();
		//Arrays.sort(intArr);
		Arrays.sort(intArr, Collections.reverseOrder());
		System.out.println(Arrays.toString(intArr));
		
		System.out.println("리스트가 비었는지?");
		System.out.println("String:" + list.isEmpty());
		System.out.println("Integer:" + list2 .isEmpty());
		System.out.println(list + " / 방의 개수:" + list.size());
	}

	public static void main(String[] args) {

		UseList ul = new UseList();
		System.out.println("제네릭을 사용하지 않음.");
		ul.notUsingGeneric();
		System.out.println("ArrayList");
		ul.useArrayList();
		System.out.println("Vector");
		ul.useVector();
	}

}
