package day0221;

public class TestCompileException {

	public static void main(String[] args) throws ClassNotFoundException {

		try {
			Class c = Class.forName("day0221.TestRuntimeException");
			System.out.println("로딩된 클래스 " + c);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
