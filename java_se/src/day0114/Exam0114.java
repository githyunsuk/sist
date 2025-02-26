package day0114;
class Exam0114 
{
	public static void main(String[] args) 
	{
		char fInitials = 'J', sInitials = 'H', tInitials = 'S';
		int year = 1999;
		System.out.println("내 이름은 주현석이고 이니셜은 " + fInitials + sInitials + tInitials + " 입니다.");
		System.out.println("태어난 해는 " + year +"년이고,");
		System.out.println("나이는 " + (2025-year+1) + "살입니다.");
		
		double leftEye = 1.0, rightEye = 1.0;
		System.out.println("왼눈 시력 " + leftEye + " 오른 눈 시력" + rightEye + "이고, 양안 시력은 " + (leftEye+rightEye)/2 + "입니다.");
		
		int money = 1500;
		System.out.println("편도차비 " + money + "원 왕복차비 " + money*2 + ", 한달 20일 출근하면 월 교통비는 " + money*2*20 + "원 입니다.");
		
		char cv = 'A';
		System.out.println("대문자 '" + cv + "'의 Unicode 값은 " + (int)cv + "입니다. 'A'에 32를 더하면 소문자 " + "'"+(char)((int)'A' + 32) + "'를 만들 수 있다.");
	}
}
