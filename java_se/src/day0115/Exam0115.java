package day0115;
class Exam0115
{
	public static final int MONEY = 20000, DAY = 20;
	
	public static void main(String[] args) 
	{
		//#1
		int tmoney = 1500, lunch = 10000;
		System.out.printf("한달 용돈 %d원 하루 용돈은 %d일 기준 %d원 입니다. \n", MONEY, DAY, MONEY*DAY);
		System.out.printf("하루 지출은 편도 교통비 %d원, 왕복 교통비 %d원, 점심 식대 %d원으로 총 %d원이 지출됩니다. \n", tmoney, tmoney*2, lunch, (tmoney*2+lunch)*DAY);
		System.out.printf("한달이 지났을 때의 잔액은 %d원 입니다. \n\n", MONEY*DAY - (tmoney*2+lunch)*DAY);
		
		//#2
		System.out.printf("byte의 최소값 %s ~ 최대값 %s \n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("short의 최소값 %s ~ 최대값 %s \n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("integer의 최소값 %s ~ 최대값 %s \n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("long의 최소값 %s ~ 최대값 %s \n", Long.MIN_VALUE, Long.MAX_VALUE);
		//System.out.printf("character의 최소값 %c ~ 최대값 %c \n", Character.MIN_VALUE, Character.MAX_VALUE);
		System.out.printf("float의 최소값 %s ~ 최대값 %s \n", Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("Double의 최소값 %s ~ 최대값 %s \n\n", Double.MIN_VALUE, Double.MAX_VALUE);
		
		//#3
		int i = 15;
		System.out.printf("1의 보수 연산자 사용:%d \n", ~i); //1의 보수
		System.out.printf("값은 그대로이게, 부호만 변경:%d \n", ~i+1); //2의 보수
		
		
	}
}
