package day0121;

/**
 * 0120 숙제 풀이
 */
public class Exam0120 {

	public static void main(String[] args) {

		int distance = Integer.parseInt(args[1]);
		int fare = 0;

		boolean printFlag = false;
		switch (args[0]) {
		case "마을버스": fare = Transport.VILLAGE_BUS; break;
		case "지하철": fare = Transport.SUBWAY; break;
		case "버스": fare = Transport.BUS; break;
		}
		
		printFlag = fare!=0;
		if(printFlag) {
			System.out.printf("입력하신 교통수단은 %s이고, 이동거리는 %dkm입니다. \n", args[0], distance);
			System.out.printf("교통수단의 기본 요금 %d원 \n", fare);
			
			if(distance > 10) {
				fare += ((distance-10)) / 5 * 100;
			}
			
			System.out.printf("편도 요금 %d원 \n", fare);
			System.out.printf("왕복 요금 %d원 \n", fare * 2);
			System.out.printf("한달 20일 기준 총 교통요금은 %d원 입니다. \n", fare * 2 * Transport.FLAG_DAY);
		} else {
			System.out.println("대중교통이 아닙니다.");
		}

	}

}
