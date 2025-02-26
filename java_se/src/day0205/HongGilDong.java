package day0205;

/**
 * 홍길동은 사람(Person에서 제공되는 자원을 사용)이고, 다른 사람과의 차별점은 싸움을 잘한다.
 * 사람의 평균 싸움 레벨은 2 정도, 최대 싸움 레벨 10까지만 가능.
 * 홍길동은 싸움 레벨을 6정도 가지고 있다. 
 */
public class HongGilDong extends Person {

	private int level;
	
	public HongGilDong() {
		level = 6;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String fight(int yourLevel) {
		String result = "";
		
		if(level < yourLevel) {
			level--;
			if(level<1) {
				level = 1;
			}
			result = "싸움에 졌음";
		}else if(level > yourLevel) {
			level++;
			if(level > 10) {
				level = 10;
			}
			result = "싸움 이김";
		}else {
			result = "비겼음";
		}
		return result;
	}
	@Override
	public String eat() {
		return getName() + "이 집에서 밥을 먹는다.";
	}

	@Override
	public String eat(String food, int cost) {
		return getName() + "이 주막에서 " + food + "인 음식을 " + cost + "전 내고 사먹는다";
	}
	
	public Person getPerson() {
		return this;
	}
}
