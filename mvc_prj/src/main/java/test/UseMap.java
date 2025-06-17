package test;

import java.util.HashMap;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) {
		
		//입력된 키로 객체를찾아서 실행시키기
//		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Person> map = new HashMap<String, Person>();
		//값 할당
		map.put("lee", new JangHoon());
		map.put("shin", new GyuMin());
		map.put("ju", new HyunSuk());
		
		//키를 사용한 객체 얻기
		String key = "ju";
		
		if(map.containsKey(key)) {
			Person person = map.get(key);
			System.out.println(person.execute());
		}
		
//		//현행 구조는 값을 얻을 때 에러가 발생하므로 비교하는 코드와 찾는 코드가 반복적으로 나와야한다.
//		if(key.equals("lee")) {
//			JangHoon jh = (JangHoon)map.get(key);
//			System.out.println(jh.execute());
//		}
//		if(key.equals("shim")) {
//			GyuMin gm = (GyuMin)map.get(key);
//			System.out.println(gm.execute());
//		}
//		if(key.equals("ju")) {
//			HyunSuk hs = (HyunSuk)map.get(key);
//			System.out.println(hs.execute());
//		}
			
	}
}
