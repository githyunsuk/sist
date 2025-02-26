package day0114;
class Constant 
{
	public static final int MAX_SCORE = 100;
		
	public static void main(String[] args) 
	{
		//System.out.println(100-85); 상수만 사용하면 가독성이 떨어진다.

		int myScore = 85;
		
		//System.out.println(MAX_SCORE - myScore);
		System.out.println("최고점수:" + MAX_SCORE + ", 획득한 점수:" + myScore);
		System.out.println("최고점수에서 획득한 점수 차:" + (MAX_SCORE - myScore));
	}
}
