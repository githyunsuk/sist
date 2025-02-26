package day0205;


/**
 * 사람의 공통특징은 부모클래스로 부터 사용하고, 자신만의 특별한 기능을 구현한 자식클래스를 사용 
 */
public class UsePerson {

	public static void main(String[] args) {
		//자식 클래스를 생성하면 자식 클래스의 객체명으로 부모클래스의 변수나 method를 사용할 수 있다.
		HongGilDong gildong = new HongGilDong();
		Clark superman = new Clark();
		
		gildong.setName("홍길동"); //부모클래스가 가진 method
		superman.setName("클락");
		
		System.out.printf("%s의 눈 %d, 코 %d, 입 %d\n",gildong.getName(),
				gildong.getEye(),gildong.getNose(),gildong.getMouth());
		System.out.printf("%s의 눈 %d, 코 %d, 입 %d\n",superman.getName(),
				superman.getEye(),superman.getNose(),superman.getMouth());

		//부모가 제공하는 일
		System.out.println(gildong.eat());
		System.out.println(superman.eat());
		System.out.println(gildong.eat("김치찌개",15000));
		System.out.println(superman.eat("스테이크",120000));
		
		//자식만이 할 수 있는 기능.
		System.out.println(gildong.fight(5));
		System.out.println(gildong.fight(6));
		System.out.println(gildong.fight(8));
		System.out.println(gildong.fight(9));
		System.out.println(gildong.fight(7));
		System.out.println(gildong.getLevel());
		
		System.out.println(superman.power("짱돌"));
		System.out.println(superman.power("다이아몬드"));
		System.out.println(superman.power("크립토나이트"));
		System.out.println(superman.power);
		
		//객체다형성. 같은 이름의 객체를 다르게 사용하는 것
		Person p = gildong.getPerson();
		Person p2 = superman.getPerson();
		System.out.println("객체다형성");
		System.out.println(p.eat("뜨끈한 국밥", 5));
		System.out.println(p2.eat("샌드위치",5));
		
		System.out.println("-------------인터페이스에서 구현한 method 호출-------------");
		System.out.println(superman.getName()+"은 날기 위해서 추진력을 " + superman.thrust() + " 얻는다");
		System.out.println(superman.getName()+"은 양력을 " + superman.thrust() + "로 얻는다");

	}

}
