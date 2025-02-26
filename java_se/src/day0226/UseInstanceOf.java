package day0226;

import java.io.NotSerializableException;
import java.io.Serializable;

public class UseInstanceOf {

	public void useInstanceOf(Test t) throws NotSerializableException {
		if(t instanceof Serializable) {
			System.out.println("직렬화 가능");
		} else {
//			System.out.println("직렬화 불가능");
			throw new NotSerializableException("직렬화 불가능");
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		UseInstanceOf uio = new UseInstanceOf();
		try{
			uio.useInstanceOf(t);
		} catch(NotSerializableException e) {
			e.printStackTrace();
		}
		
		
	}

}
