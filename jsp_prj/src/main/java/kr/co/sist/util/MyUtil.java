package kr.co.sist.util;

public class MyUtil {

	/**
	 * 이건 &lt;input type="radio"를 사용자 원하는 개수로 만드는 method
	 * 사용법)<br>
	 * MyUtil.createRadio
	 * @param name 라디오버튼의 이름
	 * @param radioInd 라디오버튼의 인덱스
	 * @param cnt 라디오버튼의 개수
	 * @param flagNum checked할 라디오의 순서
	 * @return HTML Form Control;
	 */
	public static String createRadio(String name, int radioInd, int cnt, int flagNum){
		if(cnt > 100){
			cnt = 100;
		}
		
		if(flagNum < 0 || cnt < flagNum){
			flagNum = 0;
		}
	
		StringBuilder sbTemp = new StringBuilder();
		
		for(int i=0; i<cnt+1; i++){
			sbTemp.append("<input type='radio' name='").append(name)
			.append("_").append(radioInd).append("'")
			.append( i == flagNum ? " checked='checked'" : "")
			.append(">").append(i).append(" ");
		}
		
		return sbTemp.toString();
	}
}
