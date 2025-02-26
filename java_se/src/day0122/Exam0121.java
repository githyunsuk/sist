package day0122;

public class Exam0121 {
	
	/**
	 * 줄 변경을 저장하고 있는 Constant 
	 */
	public static final int NEWLINE = 0;

	public static void main(String[] args) {

		System.out.println("\t\t\t"+args[0]+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int dayOfMonth = 0;
		switch(args[1]) {
		case "일": dayOfMonth = 0; break;
		case "월": dayOfMonth = 1; break;
		case "화": dayOfMonth = 2; break;
		case "수": dayOfMonth = 3; break;
		case "목": dayOfMonth = 4; break;
		case "금": dayOfMonth = 5; break;
		case "토": dayOfMonth = 6; break;
		}
		int lastDayOfMonth = Integer.parseInt(args[2]);
		//1월은 1일 부터 31일까지 존재
		// 달력 출력 시작
		for(int i=0; i<dayOfMonth; i++) {
			System.out.print("\t");
		}
		for(int day=1; day<=lastDayOfMonth; day++) {
			System.out.print(day+"\t");
			switch(++dayOfMonth%7) {
			case NEWLINE: System.out.print(System.lineSeparator());
			}
	
		}
		//달력 출력 끝
	}

}
