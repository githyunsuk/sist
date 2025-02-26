package day0120;

public class Test0120 {

	public static final int BUS = 1200;
	public static final int SUBWAY = 1400;
	public static final int LOCALBUS = 1500;

	public static void main(String[] args) {

		String tp = args[0];
		int distance = Integer.parseInt(args[1]);
		int charge = 0;
		int pay = 0;

		if (tp.equals("마을버스")) {
			charge = LOCALBUS;
		} else if (tp.equals("지하철")) {
			charge = SUBWAY;
		} else if (tp.equals("버스")) {
			charge = BUS;
		}

		if (charge > 0) {
			if (distance <= 10) {
				pay = charge;
			} else {
				pay = charge + ((distance - 10) / 5 * 100);
			}

			System.out.printf("입력하신 교통수단은 %s이고, 이동거리는 %dkm입니다. \n", tp, distance);
			System.out.printf("교통수단의 기본 요금 %d원 \n", charge);
			System.out.printf("편도 요금 %d원 \n", pay);
			System.out.printf("왕복 요금 %d원 \n", pay * 2);
			System.out.printf("한달 20일 기준 총 교통요금은 %d원 입니다. \n", pay * 2 * 20);
		}

		else {
			System.out.println("대중교통이 아닙니다.");
		}

	}

}
