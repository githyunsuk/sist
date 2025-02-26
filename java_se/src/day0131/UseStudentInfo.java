package day0131;

/**
 * 사용자 정의 자료형을 사용하는 클래스 
 */
public class UseStudentInfo {

	public void printStudentInfo(StudentInfo si) {
		System.out.println("------------------------");
		System.out.println("학생정보:" + si.getName());
		System.out.printf("학번:%d 이메일:%s\n나이:%d\t키:%.1f\t 몸무게:%.1f\n",si.getNum(),si.getEmail(),si.getAge(),si.getHeight(),si.getWeight());
		System.out.println("------------------------");
	}
	
	public static void main(String[] args) {

		//기본생성자 이용
		StudentInfo hunInfo = new StudentInfo();
		hunInfo.setNum(1);
		hunInfo.setName("이장훈");
		hunInfo.setEmail("lee@test.com");
		hunInfo.setAge(25);
		hunInfo.setHeight(175.2);
		hunInfo.setWeight(65.1);
//		StudentInfo si1 = new StudentInfo(1,"이장훈","lee@test.com",25,175.2,65.1);
		
		//매개변수 있는 생성자 이용
		StudentInfo gyunInfo = new StudentInfo(2,"정제균","jung@sist.co.kr",26,182.9,68.4);
		UseStudentInfo usi = new UseStudentInfo();
		usi.printStudentInfo(hunInfo);
		usi.printStudentInfo(gyunInfo);
	}

}
