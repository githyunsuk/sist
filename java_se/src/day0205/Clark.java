package day0205;

/**
 * 클락은 사람(Person에서 제공되는 자원을 사용)이고, 다른 사람과의 차발졈은 힘이 쎄다.
 * 일반 사람은 힘이 3정도 이고, 슈퍼맨은 태어나면서 10의 힘
 * 최대 가질 수 있는 힘은 10
 */
public final class Clark extends Person implements Fly {

	public int power;
	
	public Clark() {
		power = 10;
	}
	
	/**
	 * 돌에 종류에 따라 슈퍼맨의 힘이 달라져요
	 * @param stone 돌의 종류
	 * @return 입력되는 돌에 대한 결과
	 */
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("다이아몬드")) {
			result = "감사합니다";
			power = 10;
		}else if(stone.equals("크립토나이트")) {
			result = "대응할 힘이 없어요";
			power = 0;
		}else {
			result = "";
			power = 12;
		}
		return result;
	}

	@Override
	public String eat(String food, int cost) {
		return getName() + "이 집에서 " + food + "인 음식을 " + cost + "달러 내고 사먹는다";
	}
	
	public Person getPerson() {
		return this;
	}

	@Override
	public String lift() {
		return "망토";
	}

	@Override
	public String thrust() {
		return "무릎을 꿇어서";
	}
	
	
}
