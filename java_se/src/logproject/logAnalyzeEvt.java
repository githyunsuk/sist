package logproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;


public class logAnalyzeEvt {

	private MainView mv;

	private ArrayList<LogVO> lvoList = new ArrayList<LogVO>();
	private Map<String, Integer> serviceMap = new HashMap<>();
	private Map<String, Integer> browserMap = new HashMap<>();
	private Map<String, Integer> keyMap = new HashMap<>();
	private Map<String, Integer> timeMap = new HashMap<>();

	private int books500Cnt;
	private int startLine, endLine;

	public logAnalyzeEvt(MainView mv) throws IOException {
		this.mv = mv;

		JFileChooser jfc = new JFileChooser("c:/dev");
		jfc.showOpenDialog(mv);
		File file = jfc.getSelectedFile();

		if (file == null)
			return;

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = "";
		// 파일을 읽어들여 각 줄을 객체로 저장하고, 처리
		try {
			while ((str = br.readLine()) != null) {
				LogVO lvo = new LogVO(str);
				lvoList.add(lvo);

			}
		} finally {
			if (br != null) br.close();
		}
		
		readLogFile(file); //
		processLogs();
		printResults();

	}// 생성자 end

	//파일 읽기
	public void readLogFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		while ((line = br.readLine()) != null) {
			lvoList.add(new LogVO(line));
		}
	}// readLogFile

	
	//로그 파일 처리
	public void processLogs() {
		startLine = mv.getInputLineFieldA().getText().isBlank() ? 1
				: Integer.parseInt(mv.getInputLineFieldA().getText());
		endLine = mv.getInputLineFieldB().getText().isBlank() ? lvoList.size()
				: Integer.parseInt(mv.getInputLineFieldB().getText());
		for (int i = startLine - 1; i < endLine; i++) {
			LogVO log = lvoList.get(i);

			putMapValue(serviceMap, log.getService());
			putMapValue(browserMap, log.getBrowserName());
			putMapValue(keyMap, log.getKeyName());
			putMapValue(timeMap, log.getTime());

			if (log.isBooks() && "500".equals(log.getService())) {
				books500Cnt++;
			}
		}

	}// processLogs

	
	//해시맵에 값 넣기
	public void putMapValue(Map<String, Integer> map, String key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
	}// putMapValue


	//결과 출력
	public void printResults() {
		StringBuilder msg = new StringBuilder();

		// 1. 최다 사용 키의 이름과 횟수
		int countMostUsedKey = Collections.max(keyMap.values());
		String mostUsedKey = "";
		// keySet을 for 문으로 돌면서 최대횟수인 value 를 가지는 key 값 찾기
		for (String key : keyMap.keySet()) {
			if (keyMap.get(key).equals(countMostUsedKey)) {
				mostUsedKey = key;
				break;
			}
		}
		msg.append("1. 최대사용 키: ").append(mostUsedKey).append(", ").append(countMostUsedKey).append("회\n");

		// 2. 브라우저별 접속
		msg.append("2. 브라우저별 접속\n");
		for (var e : browserMap.entrySet()) {
			msg.append(e.getKey()).append(" - ").append(e.getValue()).append("[")
					.append(String.format("%.2f", (double) e.getValue() / endLine * 100)).append("%]\n");
		}

		// 3. 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수
		int serviceSucceed = serviceMap.getOrDefault("200", 0);
		int serviceFailed = serviceMap.getOrDefault("404", 0);

		msg.append("3. 서비스를 성공적으로 수행한 횟수: ").append(serviceSucceed).append("회, ").append("실패 횟수: ")
				.append(serviceFailed).append("회\n");

		// 4. 요청이 가장 많은 시간 [10시]
		int numTime = Collections.max(timeMap.values());
		String mostUsedTime = "";
		// keySet을 for 문으로 돌면서 최대횟수인 value 를 가지는 key 값 찾기
		for (String key : timeMap.keySet()) {
			if (timeMap.get(key).equals(numTime)) {
				mostUsedTime = key + "시";
			}
		}

		msg.append("4. 요청이 가장 많은 시간: [").append(mostUsedTime).append("]\n");

		// 5. 비정상적인 요청(403)이 발생한 횟수,비율구하기
		int cnt403 = serviceMap.getOrDefault("403", 0);

		msg.append("5. 비정상적인 요청(403)이 발생한 횟수: ").append(cnt403).append("[")
				.append(String.format("%.2f", (double) cnt403 / endLine * 100)).append("%]\n");

		// 6. books 에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기 ( 전체 레코드를 비율의 대상으로 구하세요 )
		msg.append("6. books에 대한 요천 URL 중 에러(500)가 발생한 횟수: ").append(books500Cnt).append("[")
				.append(String.format("%.2f", (double) books500Cnt / endLine * 100)).append("%]\n");

		mv.getJta().append(msg.toString());
	} // end printResults()

}// end class
