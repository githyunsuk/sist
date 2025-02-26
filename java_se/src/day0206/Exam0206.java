package day0206;

public class Exam0206 {

	public abstract class Keyboard {
		
		private int price;
		private String layout;
		
		public Keyboard(int price, String layout) {
			this.price = price;
			this.layout = layout;
		}
		
		public abstract void pressKey(char key);

		public abstract void printMsg(String msg);

		public int getPrice() {
			return price;
		}
	    public String getLayout() {
	        return layout;
	    }
		
	}
	
	public class MechanicalKeyboard extends Keyboard {

		public MechanicalKeyboard(int price, String layout) {
			super(price, layout);
		}
		
		@Override
		public void pressKey(char key) {
			System.out.printf("%d원인 %s 기계식 키보드로 %c키를 누릅니다.\n",getPrice(),getLayout(),key);
		}
		
		@Override
		public void printMsg(String msg) {
			System.out.println("기계식 키보드로 \"" + msg + "\" 라는 문장을 입력합니다." );
		}
		
		
	}
	
	public class PentagraphKeyboard extends Keyboard {
		
		public PentagraphKeyboard(int price, String layout) {
			super(price, layout);
		}
		
		@Override
		public void pressKey(char key) {
			System.out.printf("%d원인 %s 펜타그래프 키보드로 %c키를 누릅니다.\n",getPrice(),getLayout(),key);
		}
		@Override
		public void printMsg(String msg) {
			System.out.println("펜타그래프 키보드로 \"" + msg + "\" 라는 문장을 입력합니다." );
		}
		
	}
	
	public static void main(String[] args) {

		Exam0206 ex = new Exam0206();
		PentagraphKeyboard pk = ex.new PentagraphKeyboard(100000, "풀키보드");
		MechanicalKeyboard mk = ex.new MechanicalKeyboard(50000, "텐키리스");
		
		pk.pressKey('f');
		pk.printMsg("집에 가고 싶다");
		mk.pressKey('ㅗ');
		mk.printMsg("배고프다");
	
	}

}
