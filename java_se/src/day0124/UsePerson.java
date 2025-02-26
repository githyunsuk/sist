package day0124;



public class UsePerson {

	public static void main(String[] args) {

		Person ogong = new Person();
		
		//ogong.setEye(2);
		//ogong.setNose(1);
		//ogong.setMouth(1);
		ogong.setName("손오공");
		System.out.printf("%s의 눈 %d, 코 %d, 입 %d\n",ogong.getName(),ogong.getEye(),ogong.getNose(),ogong.getMouth());
		
		System.out.println(ogong.eat());
		System.out.println(ogong.eat("김밥", 5000));
		
		Person krillin = new Person(2,0,1);
		
		//krillin.setEye(2);
		//krillin.setNose(0);
		//krillin.setMouth(1);
		//krillin.setName("크리링");
		
		System.out.println(krillin.eat());
		System.out.println(krillin.eat("돈까스", 10000));
		
		//자신의 객체 생성
		
		Person jhs = new Person();
		
		jhs.setEye(2);
		jhs.setNose(1);
		jhs.setMouth(1);;
		jhs.setName("주현석");
		
		System.out.println(jhs.eat());
		System.out.println(jhs.eat("떡볶이", 14000));
		
	}

}
