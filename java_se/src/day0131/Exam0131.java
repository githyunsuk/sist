package day0131;

public class Exam0131 {

	private String num;
	
	public Exam0131(String num) {
		this.num = num;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public boolean checkNum() {
		return num.length() == 14;
	}
	
	public boolean checkHypen() {
		return num.charAt(6) == '-';
	}
	
	private char getIdx() {
        return num.charAt(num.indexOf("-") + 1);
    }
	
	public String returnBirth() {
		char idx = getIdx();
		String birth = num.substring(0,2)+"년"+num.substring(2,4)+"월"+num.substring(4,6)+"일";
		
		if(idx=='1' || idx=='2' || idx=='3' || idx=='6' ) {
			return "19"+birth;
		} else if(idx=='0' || idx=='9') {
			return "18"+birth;
		} else {
			return "20"+birth;
		}
	}
	
	public int getAge() {
		char idx = getIdx();
		String temp = num.substring(0,2);
		if(idx=='1' || idx=='2' || idx=='5' || idx=='6' ) {
			String age = "19" + temp;
			return 2025 - Integer.parseInt(age) + 1;
		} else if(idx=='0' || idx=='9') {
			String age = "18" + temp;
			return 2025 - Integer.parseInt(age) + 1;
		} else {
			String age = "20" + temp;
			return 2025 - Integer.parseInt(age) + 1;
		}
	}
	
	public String getGender() {
		return (getIdx() % 2 == 0) ? "여자" : "남자";
	}
	
	public String getForeign() {
		return (getIdx() >= '5' && getIdx() <= '8') ? "외국인" : "내국인";
	}
	
	public String getYear() {
		String year = null;
		String age = returnBirth().substring(0,4);
		
		switch(Integer.parseInt(age)%12) {
		case 0: year = "원숭이"; break;
		case 1: year = "닭"; break;
		case 2: year = "개"; break;
		case 3: year = "돼지"; break;
		case 4: year = "쥐"; break;
		case 5: year = "소"; break;
		case 6: year = "호랑이"; break;
		case 7: year = "토끼"; break;
		case 8: year = "용"; break;
		case 9: year = "뱀"; break;
		case 10: year = "말"; break;
		case 11: year = "양"; break;
		}
		
		return year;
	}
	
	public static void main(String[] args) {
		
		String ssn = "990825-1010210";
		Exam0131 ex = new Exam0131(ssn);
		
		if(ex.checkNum()) {
			if(ex.checkHypen()) {
				System.out.println(ex.returnBirth());
				System.out.println(ex.getAge());
				System.out.println(ex.getGender());
				System.out.println(ex.getForeign());
				System.out.println(ex.getYear());
			} else {
				System.out.println("-가 올바른 위치에 없습니다");

			}
		} else {
			System.out.println("주민번호 길이가 다름");
		}
	}

}
