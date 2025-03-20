package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day0320.Work;

class NumTest {

	@DisplayName("난수로 발생한 수를 테스트")
	@Test
	void test() {
		//테스트를 하기 위한 코드 작성,
		Work w = new Work();
		//단정 method 사용.
//		int num = w.randomNumber();
//		System.out.println(num);
//		assertNotEquals(w.randomNumber(), 0); //0이 아닌 경우 성공
//		assertEquals(num, 0); //0인 경우 성공
		
		//예외 관련된 단정 method.
		String msg = "Java 프로그래밍의 기본서";
//		assertThrows(Exception.class, ()->w.sub(msg)); //예외가 발생하면 성공
		assertDoesNotThrow(()->w.sub(msg)); //예외가 발생하지 않으면 성공
		
		
//		System.out.println(w.randomNumber());
		//코딩해도 되지만 >> assert method 사용한다.
//		if(w.randomNumber() == 0) {
//			System.out.println("테스트 실패");
//		}else {
//			System.out.println("테스트 성공");
//		}
	}

}
