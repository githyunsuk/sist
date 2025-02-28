package yys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
	
	public LogAnalyzer() {
		
	}

	String analyze(File logFile,int startLine, int endLine) {
		StringBuilder result= new StringBuilder();
		Map<String, Integer> keyCountMap= new HashMap<>();
		Map<String, Integer> browserCountMap=new HashMap<>();
		Map<String, Integer> timeCountMap= new HashMap<>();//시간을 위한 맵
				
		int totalCount=0; //전체 로그의 수//2번
		int successCount=0;//성공한 요청(200)//3번
		int failureCount=0;//실패한 요청(404)//3번
		int forbiddenCount=0;//비정상적인 요청(403)//5번
		int error500Count=0;// 500 에러 요청 횟수 //6번
		int books500Count=0;//500 에러에서 'books' 관련 요청 횟수
		 
		//try~with~resources를 사용하여 자동으로 파일 리더를 닫음
		try(BufferedReader reader = new BufferedReader(new FileReader(logFile))){
			String line;
			int lineNumber = 0;//7번
			while((line=reader.readLine()) !=null) {
				totalCount++; // 로그 하나를 읽을 때마다 전체 카운트 증가
				
				//7번.
				lineNumber++; // 라인 번호 증가

                // 지정된 범위에 해당하는 라인만 처리
                if (lineNumber < startLine || lineNumber > endLine) {
                    continue; // 범위 외의 라인은 무시
                }
				
				String[] parts=line.split("key=");
				if(parts.length>1) {
					//key 값 추출 후 불필요한 공백 제거
					String key=parts[1].trim().split("&")[0];
					//key가 이미 있으면 카운트 증가, 없으면 1로 설정
					keyCountMap.put(key, keyCountMap.getOrDefault(key, 0)+1);
				}// 1번 문제: key 값
				
				//2번.User-Agent에서 브라우저 정보 추출//ie firefox Chrome opera/
//				String userAgent= logParts[2].replace("]","").trim();
				String userAgent=line.toLowerCase(); 
				if(userAgent.contains("opera")) {
					
					browserCountMap.put("Opera", browserCountMap.getOrDefault("Opera", 0)+1);
				}else if(userAgent.contains("chrome")) {
					browserCountMap.put("Chrome", browserCountMap.getOrDefault("Chrome", 0)+1);
					
					
				}else if(userAgent.contains("firefox")) {
					browserCountMap.put("Firefox", browserCountMap.getOrDefault("Firefox", 0)+1);
					
				}else if(userAgent.contains("safari") && !userAgent.contains("chrome")) {
					browserCountMap.put("Safari", browserCountMap.getOrDefault("Safari", 0)+1);
					
				}else if(userAgent.contains("edge")) {
					browserCountMap.put("Edge", browserCountMap.getOrDefault("Edge", 0)+1);
				}
				
				//3번. HTTP 상태 코드 추출(200, 404 등)
				String[] logParts=line.split("\\]\\[");//대괄호를 기준으로 분리
				if(logParts.length>=4) {
					//상태 코드 추출(로그 첫번째 부분)
					String statusCode =logParts[0].replace("[", "").trim();//상태코드는 보통 2번째 마지막 위치에 있음
					if(statusCode.equals("200")) {
						successCount++;//성공한 요청 카운트
					}else if(statusCode.equals("404")) {
						failureCount++; //실패한 요청 카운트
					}else if(statusCode.equals("403")) {
						forbiddenCount++;//5번
					}
					//5번. 500 에러 처리
					if(statusCode.equals("500")) {
						error500Count++;//500 에러 요청 횟수 증가
						String url=logParts[1].trim();//URL 추출
						if(url.contains("book")) {
							books500Count++;
						}
					}
				}
				
				//4번. 시간 추출(로그 네번째 부분, 날짜와 시간에서 시간만 추출)
				String timestamp= logParts[3].replace("]", "").trim();//[2024-02-06 09:35:17]에서 시간을 추출
				String time=timestamp.split(" ")[1].split(":")[0]; //시간 부분만 추출(예: 09)
				
				timeCountMap.put(time, timeCountMap.getOrDefault(time, 0)+1);
				
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
			return "로그 파일을 읽는 중 오류가 발생했습니다.";
		}
		
		//가장 많이 사용된 키 찾기
		String mostCountKey= null;
		int maxCount=0;
		
		for(Map.Entry<String, Integer> entry: keyCountMap.entrySet()) {
			if(entry.getValue() > maxCount) {
				mostCountKey=entry.getKey();
				maxCount=entry.getValue();
				
			}
		}
		
		//1번.가장 많이 사용된 키와 빈도수 
		if(mostCountKey !=null) {
			result.append("가장 많이 사용된 키:").append(mostCountKey).append(": ").append(maxCount).append("\n");
			System.out.println(mostCountKey);
		}else {
			result.append("로그에 키가 없습니다.\n");
		}
		
		//2번.브라우저별 접속 횟수와 비율 계산
		if(totalCount > 0) {
			result.append("\n 브라우저별 접속 횟수 및 비율: \n ");
			for(Map.Entry<String, Integer> entry: browserCountMap.entrySet()) {
				String browser= entry.getKey();
				int count=entry.getValue();
				double percentage=(double) count/totalCount *100;
				result.append(browser).append("-").append(count).append("(").append(String.format("%.2f", percentage)).append("%)\n");
			}
		}else {
			result.append("\n 로그에 브라우저 정보가 없습니다.\n");
		}
		
		//3번.성공한 요청과 실패한 요청 횟수 추가
		result.append("\n 서비스 요청 상태: \n");
		result.append("성공(200) 횟수: ").append(successCount).append("\n");
		result.append("실패(404) 횟수: ").append(failureCount).append("\n");
		
		
		//4번. 가장 많이 요청된 시간대 계산
		if(!timeCountMap.isEmpty()) {
			String mostRequestedTime=null;
			int maxRequests=0;
			for(Map.Entry<String, Integer>entry: timeCountMap.entrySet()) {
				if(entry.getValue() > maxRequests) {
					mostRequestedTime=entry.getKey();
					maxRequests=entry.getValue();
				}
				
			}
				result.append("\n요청이 가장 많은 시간: ").append(mostRequestedTime).append("시(").append("건)\n");
				
			} else {
				result.append("\n로그에 시간이 없습니다.\n");
			
		}
		
		if(totalCount >0) {
			double forbiddenPercentage=(double)forbiddenCount/totalCount *100;
			result.append("비정상적인 요청(403) 횟수: ").append(forbiddenCount).append(" (")
			.append(String.format("%.2f", forbiddenPercentage)).append("%)\n");
			}
		
		if(totalCount >0) {
			double books500Percentage=(double)books500Count/totalCount*100;
			result.append("\n500에러 요청 중 'book'관련 요청 횟수: ").append(books500Count).append(" (")
				.append(String.format("%.2f", books500Percentage)).append("%)\n");
				
		}
		
		//결과 문자열 반환
		return result.toString();
	}
	
}//class
