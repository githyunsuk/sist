package day0207;
import java.util.Arrays;
public class Exam0207 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			int temp = (int)(Math.random() * 45) + 1;
			
			boolean flag = false;
			for (int j = 0; j < i; j++) {
		        if (lotto[j] == temp) {
		            flag = true;
		            break;
		        }
			}
			if(flag) {
				i--;
			}else {
				lotto[i] = temp;
			}
		}
		Arrays.sort(lotto);
		for(int l : lotto) {
			System.out.printf("%d ",l);
		}
	}

}
