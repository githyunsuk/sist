package day0121;

public class Test0121 {

	public static void main(String[] args) {

		int month = Integer.parseInt(args[0]);
		String day = args[1];
		int lastDay = Integer.parseInt(args[2]);
		int StartDay = 0;
		
		switch(day) {
		case "일": StartDay =0; break;
		case "월": StartDay =1; break;
		case "화": StartDay =2; break;
		case "수": StartDay =3; break;
		case "목": StartDay =4; break;
		case "금": StartDay =5; break;
		case "토": StartDay =6; break;
		}
		
		System.out.printf("\t\t\t%d월\n",month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i=1; i<=lastDay; i++) {
			if(i == 1) {
				for(int j=0; j<StartDay; j++) {
					System.out.print("\t");
				}
			}
			System.out.print(i + "\t");
			if (++StartDay % 7 == 0 ) {
				System.out.println();
			}
		}
	}
}
