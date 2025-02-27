package logproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JFileChooser;

public class tempClass {

	MainView mv;
	
	ArrayList<LogVO> lvoList = new ArrayList<LogVO>();
	HashMap<String, Integer> serviceMap = new HashMap<>();
	HashMap<String, Integer> browserMap = new HashMap<>();
	HashMap<String, Integer> keyMap = new HashMap<>();
	HashMap<String, Integer> timeMap = new HashMap<>();
	
	private String serviceKey;
	private String browserKey;
	private String keyKey;
	private String timeKey;
	
	private int books500Cnt;
	
	
	public tempClass(MainView mv) throws IOException {
		this.mv = mv;
		
		JFileChooser jfc = new JFileChooser("c:/dev");
		jfc.showOpenDialog(mv);
		File file = jfc.getSelectedFile();
		
		if(file == null) return;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = "";
		//파일을 읽어들여 각 줄을 객체로 저장하고, 처리
		try {
			while((str = br.readLine()) != null) {
				mv.getJta().append(str+"\n");
				LogVO lvo = new LogVO(str);
				lvoList.add(lvo);
			
				serviceKey = lvo.getService();
				browserKey = lvo.getBrowserName();
				keyKey = lvo.getKeyName();
				timeKey = lvo.getTime();
				
				serviceMap.put(serviceKey, serviceMap.getOrDefault(serviceKey, 0) + 1);
				browserMap.put(browserKey, browserMap.getOrDefault(browserKey, 0) + 1);
				keyMap.put(keyKey, keyMap.getOrDefault(keyKey, 0) + 1);
				timeMap.put(timeKey, timeMap.getOrDefault(timeKey, 0) + 1);
				
				if(lvo.isBooks()) {
					if(lvo.getService().equals("500")) {
						books500Cnt++;
					}
				}
				
			}
		} finally {
			if(br != null) br.close();
		}
		
		
		
		//1. 최다 사용 키의 이름과 횟수
		int numMostUsedKey = Collections.max(keyMap.values());
		String mostUsedKey = "";
		//keySet을 for문으로 돌면서 최대횟수인 value를 가지는 key 값 찾기
		for(String key : keyMap.keySet()) {
			if(keyMap.get(key).equals(numMostUsedKey)) {
				mostUsedKey = key;
				break;
			}
		}
		System.out.println("최다사용 키" + mostUsedKey + "," + numMostUsedKey + "회");
		
		//2. 브라우저별 접속
		for(String key: browserMap.keySet()) {
			System.out.println(key + "횟수" + browserMap.get(key));
		}
		
		//3. 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수
		int serviceSucceed = serviceMap.get("200");
		int serviceFailed = serviceMap.get("404");
		System.out.println("서비스 성공:" + serviceSucceed + "서비스 실패" + serviceFailed);
		
		//4. 요청이 가장 많은 시간 [10시]
		int numTime = Collections.max(timeMap.values());
		String mostUsedTime = "";
		//keySet을 for문으로 돌면서 최대횟수인 value를 가지는 key값 찾기
		for(String key: timeMap.keySet()) {
			if(timeMap.get(key).equals(numTime)) {
				mostUsedTime = key + "시";
			}
		}
		System.out.println("요청이 가장 많은 시간" + mostUsedTime);

		//5. 비정상적인 요청(403)이 발생한 횟수,비율구하기
		int cnt403 = serviceMap.get("403");
		System.out.println("비정상적인 요청" + cnt403);

		//6. books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기 ( 전체 레코드를 비율의 대상으로 구하세요)
		System.out.println("book 예제" + books500Cnt);
		
	}
}
