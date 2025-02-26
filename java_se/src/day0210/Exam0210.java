package day0210;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 문제
 * 1. String data="서울시 강남구 역삼동,서울시 서초구 서초동,
 * 서울시 동대문구 동대문동,경기도 수원시 망포동,
 * 제주도 일도 이동,서울특별시 중구”;
 * 위의 데이터를 일차원 배열에 각 방에 넣어 반환하는 일을 하는 method 를 만든다.
 * 배열을 받아서 모두 출력하고, ‘서울’인 도시의 개수를 출력하세요.
 * 
 * 서울시 강남구 역삼동
 * 서울시 서초구 서초동
 * 서울시 동대문구 동대문동
 * 경기도 수원시 망포동
 * 제주도 일도 이동
 * 서울특별시 중구
 * 
 * 서울시는 4개입니다.
 * 
 * 2. 0,1,2,3 을 입력받는 method 를 작성하고, 문자열로 날짜를 반환하는 method 작성
 * 	  반환되는 날짜 형식 "월-일-년 오전|오후 시:분:초 요일"
 * 
 * 	 조건:입력되는 0,1,2,3은 숫자에 따라 0-한국, 1-미국, 2-일본, 3-캐나다의 날짜 형식이 반환되어야함,
 * 		 입력되는 값이 0,1,2,3이 아니라면 0으로 설정하여 처리하세요
 * 
 * 3. 파일명을 매개변수로 받는 method 를 만들고,
 * 	  입력된 파일명에 백업 파일명을 반환하는 일을 하는 method 작성
 * 	  만약 입력되는 파일명에 .이 없다면 파일명의 가장 뒤에 _bak 를 붙여서 반환
 * 
 * 	  예) "Test.java"입력 -> "Test_bak.java" 형식으로 리턴
 */
public class Exam0210 {
	
	/**
	 * 1. String data="서울시 강남구 역삼동,서울시 서초구 서초동,
	 * 서울시 동대문구 동대문동,경기도 수원시 망포동,
	 * 제주도 일도 이동,서울특별시 중구”;
	 * 위의 데이터를 일차원 배열에 각 방에 넣어 반환하는 일을 하는 method 를 만든다.
	 * 배열을 받아서 모두 출력하고, ‘서울’인 도시의 개수를 출력하세요.
	 * 
	 * 서울시 강남구 역삼동
	 * 서울시 서초구 서초동
	 * 서울시 동대문구 동대문동
	 * 경기도 수원시 망포동
	 * 제주도 일도 이동
	 * 서울특별시 중구
	 * 
	 * 서울시는 4개입니다
	 */
	public void printSeoul() {
		
		String[] countryArr= {"서울시 강남구 역삼동","서울시 서초구 서초동","서울시 동대문구 동대문동"
				,"경기도 수원시 망포동","제주도 일도 이동","서울특별시 중구" };
		System.out.println("아래의 배열 중 '서울'인 도시의 개수를 출력");
		int count=0;
		
		for(String str : countryArr) {
			System.out.printf("[%s] ",str);
			if(str.contains("서울")) {
				count++;
			} //end if
		} //end for	
		
		System.out.println("\n'서울'인 도시의 개수 : "+ count);
		
	} //printSeoul
	
	/**
	 * 2. 0,1,2,3 을 입력받는 method 를 작성하고, 문자열로 날짜를 반환하는 method 작성
	 * 반환되는 날짜 형식 "월-일-년 오전|오후 시:분:초 요일"
	 * 조건:입력되는 0,1,2,3은 숫자에 따라
	 * 0-한국, 1-미국, 2-일본, 3-캐나다의 날짜 형식이 반환되어야함,
	 * 입력되는 값이 0,1,2,3이 아니라면 0으로 설정하여 처리하세요
	 * @param numCountry 입력받는 나라 번호
	 * @return formatDate 반환되는 날짜
	 */
	public String localeCountry(String numCountry) {
		
		SimpleDateFormat sdf=new SimpleDateFormat();
		
		switch (numCountry) {
		case "0": {
			sdf=new SimpleDateFormat("MM-dd-yyyy a hh:mm:ss EEEE",
					Locale.KOREA); break;
		}
		case "1": {
			sdf=new SimpleDateFormat("MM-dd-yyyy a hh:mm:ss EEEE",
					Locale.US); break;
		}
		case "2": {
			sdf=new SimpleDateFormat("MM-dd-yyyy a hh:mm:ss EEEE",
					Locale.JAPAN); break;
		}
		case "3": {
			sdf=new SimpleDateFormat("MM-dd-yyyy a hh:mm:ss EEEE",
					Locale.CANADA); break;
		}
		default:
			sdf=new SimpleDateFormat("MM-dd-yyyy a hh:mm:ss EEEE",
					Locale.KOREA); break;
		} //end switch
		
		String formatDate=sdf.format(new Date());
		
		return formatDate;
	} //localeCountry
	
	/**
	 * 3. 파일명을 매개변수로 받는 method 를 만들고,
	 * 	  입력된 파일명에 백업 파일명을 반환하는 일을 하는 method 작성
	 * 	  만약 입력되는 파일명에 .이 없다면 파일명의 가장 뒤에 _bak 를 붙여서 반환
	 * 
	 * 	  예) "Test.java"입력 -> "Test_bak.java" 형식으로 리턴
	 * @param fileName
	 * @return
	 */
	public String fileNameBackUp(String fileName) {
		String backUp=fileName;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<backUp.length(); i++) {
			sb.append(backUp.charAt(i));
		} //end for
		int index=sb.indexOf(".");
		
		if(index!=-1) {
			sb.insert(index, "_bak");
		} else {
			sb.append("_bak");
		} //end if
		
		backUp=sb.toString();
		return backUp;
	} //fileNameBackUp

	public static void main(String[] args) {
		Exam0210 ex=new Exam0210();
		
		ex.printSeoul();
		
		System.out.println("원하는 나라의 번호를 입력해주세요. 0-한국, 1-미국, 2-일본, 3-캐나다");
		String numCountry = args[0];
		System.out.printf("입력받는 번호 : %s\n", numCountry);
		
		System.out.println(ex.localeCountry(numCountry));
		
		System.out.println("파일명을 입력해주세요. 예) Test.java");
		String fileName = args[1];
		System.out.printf("입력받은 파일명 : %s\n", fileName);
		System.out.println(ex.fileNameBackUp(fileName));
	} //main

} //class
