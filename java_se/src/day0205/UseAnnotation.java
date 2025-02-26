package day0205;
import java.util.*;

/**
 * annotation 사용. 
 */
public class UseAnnotation {

	@Deprecated
	public void test() {
		System.out.println("제대로 일을 할 줄 알았는데......");
	}
	
	@Override
	public String toString() {
		return "heap 주소 대신 메시지!";
	}
	
	@SuppressWarnings("unused")
	public void temp() {
		int i;
		int j;
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
	}
	
	public static void main(String[] args) {

		UseAnnotation ua = new UseAnnotation();
		ua.test();
		System.out.println(ua);
	}

}
