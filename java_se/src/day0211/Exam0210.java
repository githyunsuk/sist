package day0211;

import java.util.*;
import java.text.*;

/**
 * 문제 <br>
 * 1번 문제 <br>
 * String data = "서울시 강남구 역삼동,서울시 서초구 서초동.서울시 동대문구 동대문동[경기도 수원시 망포동,제주도 일도 이동,서울특별시 중구"; <br>
 * 위 데이터를 일차원 배열에 각 방에 넣어 반환하는 일을 하는 method를 만든다.<br>
 * 배열을 받아서 모두 출력하고, '서울'인 도시의 개수를 출력하세요.<br>
 * 서울시는 4개입니다.<br>
 * 2번 문제<br>
 * 0,1,2,3을 입력받는 method를 작성하고, 문자열로 날짜를 반환하는 method를 작성<br>
 * 반환되는 날짜 형식은 "월-일-년 오전|오후 시:분:초 요일"<br>
 * 조건 : 입력되는 0,1,2,3은 숫자에 따라 0-한국, 1-미국, 2-일본, 3-캐나다의 날짜형식이 반환되어져야한다.<br>
 * 조건 : 입력되는 값이 0,1,2,3이 아니라면 0으로 설정하여 처리하세요.<br>
 * 3번 문제<br>
 * 파일명을 매개변수로 받는 method를 만들고, 입력된 파일명에 백업 파일명(_bak)을 반환하는 일을 하는 method를 작성하세요.<br>
 * 예시 : "Test.java"를 입력 => "Test_bak.java"를 반환<br>
 * 만약 입력되는 파일명에 .이 없다면 파일명의 가장 뒤에 _bak를 붙혀서 반환.<br>
 */
public class Exam0210 {
	public static int seoulCount;
	
	/**
	 * 문제1
	 * @return
	 */
	public String[] makeArray() {
		String data = "서울시 강남구 역삼동,서울시 서초구 서초동.서울시 동대문구 동대문동[경기도 수원시 망포동,제주도 일도이동,서울특별시 중구";
		StringTokenizer stk = new StringTokenizer(data,",.[");
		String[] result = new String[stk.countTokens()];
		int index = 0;
		
		while (stk.hasMoreTokens()) {
			result[index] = stk.nextToken();
			if (result[index].contains("서울")) {
				seoulCount++;
			}
			index++;
		}// end while
		return result;
	}// makeArray
	
	
	/**
	 * 문제2
	 * @return
	 */
	public String makeDate(int num) {
		String result;
		switch (num) {
		case 0:
			SimpleDateFormat sdf0 = new SimpleDateFormat("MM-dd-YY a hh:mm:ss EEEE",Locale.KOREA);
			result = sdf0.format(new Date());
			break;
		case 1:
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-YY a hh:mm:ss EEEE",Locale.US);
			result = sdf1.format(new Date());
			break;
		case 2:
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-YY a hh:mm:ss EEEE",Locale.JAPAN);
			result = sdf2.format(new Date());
			break;
			
		case 3:
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-YY a hh:mm:ss EEEE",Locale.CANADA);
			result = sdf3.format(new Date());
			break;
		default :
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YY a hh:mm:ss EEEE",Locale.KOREA);
			result = sdf.format(new Date());
			break;
		}// end switch case
		
		return result;
	}// makeDate
	
	/**
	 * 문제3
	 * @param str
	 * @return
	 */
	public StringBuilder makeBackupFile(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		if(str.contains(".")) {
			sb.insert(sb.indexOf("."),"_bak");
		} else {
			sb.append("_bak");
		}// end if
		return sb;
	}// end makeBackupFile
	
	
	
	public static void main(String[] args) {
		Exam0210 exam = new Exam0210();
		String[] data = exam.makeArray();
		
		// 문제1-1
		for(String str : data) {
			System.out.println(str);
		}
		
		// 문제1-2
		System.out.println("서울시는 " + seoulCount + "개 입니다.");
		
		// 문제2
		System.out.println(exam.makeDate(1));
		
		// 문제3
		System.out.println(exam.makeBackupFile("TEST.java"));
		System.out.println(exam.makeBackupFile("TEST"));

	}// main
}// class
