package day0206;

/**
 * AbstractSuper를 상속 받는 자식 클래스 
 */
public class AbstractSub extends AbstractSuper {

	@Override
	public int getI() {
		return 2025;
	}
	
	@Override
	public void printMsg(String msg) {
		System.out.println(msg);
		
	}
	
	@Override
	public String toString(){
		return "안녕" + super.toString(); //일반 method는 super로 호출할 수 있다.
	}
	
	public static void main(String[] args) {
		
		//추상클래스는 상속관계의 자식클래스가 생성될 때에만 생성된다
		AbstractSub as = new AbstractSub();
		System.out.println(as.getI());
		as.printMsg("맞히셨습니까?");
		
		//is a 관계의 객체화를 하여 method 호출
		AbstractSuper as2 = new AbstractSub();
		System.out.println(as2.getI());
		as2.printMsg("안녕");
		
		//println에 as 객체를 넣었을 때 "안녕" 메시지 뒤에 객체의 주소를 출력
		System.out.println(as);
	
	}

}
