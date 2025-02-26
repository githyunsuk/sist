package day0123;  

/**
 * 마카펜 클래스를 객체 생성하여, 객체가 제공하는 기능을 사용하는 클래스. 
 */
public class UseMarkerPen {

	public static void main(String[] args) {
 
		System.out.println(args);
		MarkerPen black = new MarkerPen();
		
		black.setCap(1);
		black.setBody(1);
		black.setColor("검은");
		
		System.out.println("마카펜 객체가 가진 값");
		System.out.printf("뚜껑 %d, 몸체 %d, %s색\n",black.getCap(),black.getBody(),black.getColor());
		System.out.println(black.write("집에 가고 싶다"));
		
		//파란색 마카펜 생성
		MarkerPen blue = new MarkerPen(2,2,"파란");
//		blue.setCap(1);
//		blue.setBody(1);
//		blue.setColor("파란");
		
		System.out.println(blue.write("오늘도 수고 많으셨습니다.}"));
		
	}

}
