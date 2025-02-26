package day0207;
import java.util.Arrays;

//import day0120.ZodiacStr;

public class UseString {

	public static void main(String[] args) {
		
		String result = "";
		int birth = 2025;
//		String[] zodiacArr = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
//		String data = "원숭이,닭,개,돼지,쥐,소,호랑이,토끼,용,뱀,말,양";
//		String [] zodiacArr = data.split(",");
//		result = zodiacArr[birth % 12];
		result = "원숭이,닭,개,돼지,쥐,소,호랑이,토끼,용,뱀,말,양".split(",")[birth%12];
		System.out.println(birth + "년생은 " + result + "띠 입니다.");
		
		String data = "자바~오라클~HTML~CSS";
		System.out.println(Arrays.toString(data.split("~")));


	}

}
