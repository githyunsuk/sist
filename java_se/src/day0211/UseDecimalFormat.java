package day0211;

import java.text.DecimalFormat;

/**
 * 숫자 형식의 사용 
 */
public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		
		int temp = 2_500_000; //코딩 시 숫자에 대한 가독성을 향상 시키기 위해 _를 사용.
		
		System.out.println(temp); //구분자로 사용된 _는 출력되지 않는다.
		
		DecimalFormat df = new DecimalFormat("0,000,000,000");
		System.out.println(df.format(temp)); //데이터가 없으면 0이 채워져서 출력
	
		DecimalFormat df2 = new DecimalFormat("#,###,###,###");
		System.out.println(df2.format(temp)); //데이터가 있는 부문만 출력
		
		long l = 12341987239412934L;
		DecimalFormat df3 = new DecimalFormat("#,###");
		System.out.println(df3.format(l)); //데이터가 있는 부문만 출력
		
		double d = 2025.0211;
		DecimalFormat df4 = new DecimalFormat("#,###.####");
		System.out.println(df4.format(d)); //데이터가 있는 부문만 출력
	}

	public static void main(String[] args) {

		new UseDecimalFormat();
	}

}
