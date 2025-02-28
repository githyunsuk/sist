package smk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
/**
 * 	문제풀이 메서드 3개 팁 :
 *	Collections의 메서드 max    최대값 구해주는 거 
 *	Map의 getOrDefault        메서드 구현 알아보기 
 *	Iterator<String> ?? 
 */
public class LogAnalysisEVT extends WindowAdapter implements ActionListener {

	private LogAnalysis logAnalysis; //버튼과 텍스트필드가 담겨있는 클래스 
	
	private List<LogVO> logVOList; //로그들을 객체로 만들어 저장하고, 메서드에서 불러오기 위해 인스턴스 변수화
	
	
	//------------------ 
	private String reportq1;
	private String reportq2;
	private String reportq3;
	private String reportq4;
	private String reportq5;
	private String reportq6;
	private String reportq7;
	
	
	//------------------ 
	public LogAnalysisEVT(LogAnalysis logAnalysis) {
		this.logAnalysis = logAnalysis;
		this.logVOList = new ArrayList<LogVO>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//가져오기 버튼 액션
		if(e.getSource() == logAnalysis.getOpenFileBtn()) {
			try {
				openFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		//로그파일 분석 액션 
		if(e.getSource() == logAnalysis.getLogAnalysisBtn()) {
			logAnalysis();
		}
		
		//레포트생성 버튼 액션
		if(e.getSource() == logAnalysis.getReportBtn()) {
			try {
				getReport();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
	
//버튼에 따른 메서드 구현
	//파일 가져오기 : JFileChooser
	public void openFile() throws IOException {
		JFileChooser jfc = new JFileChooser("c:/dev");
		jfc.showOpenDialog(null);
		
		File file = jfc.getSelectedFile();
		System.out.println("선택한 파일: " + file);
		
		if(!file.exists()) {
			JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다.");
			return;
		}
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int lineMaxim = 1; //index
		System.out.println("존재하던 행의 갯수: " + logAnalysis.getJt().getRowCount());
		if(logAnalysis.getJt().getRowCount() != 0 ) { //추가 불러오기 시에 index 개수 더해서 계산 
			lineMaxim += logAnalysis.getJt().getRowCount();
		}
	    if (logAnalysis.getDtm().getColumnCount() == 0) {
	        String[] columnNames = { "Index", "응답코드", "URL", "Browser", "Time" };
	        logAnalysis.getDtm().setColumnIdentifiers(columnNames);
	    }
		String logRecord = "";
		try {
			while ((logRecord = br.readLine()) != null) {
				
				//LogVO생성, StringTokenizer로 잘라서 자료형 변환후 생성자 호출
				StringTokenizer stk = new StringTokenizer(logRecord, "[]");
				String[] arr = new String[stk.countTokens()];
				int i = 0;
				while(stk.hasMoreTokens()) {
					arr[i++] = stk.nextToken();
				}
				
				//로그를 VO로 저장, DB나오면 유용. 다른 메서드에서도 쓰임  
				//String은 DateTimeFormatter와 LocalDateTime을 화룡 
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        /**
		         * 	ss가 잘못된 문자열일 때 예외처리? if문?, (4번문제, 시간 계산에 대상 포함안시킴) 
		         */
//		        if(arr[3].contains("ora")) {
//		        	//초단위 오류난거는 넘어가라 -> LogVO에 들억가야돼, 200,403에 모두 섞여있고, 다른 문제의 count에 포함시켜야돼 
//		        	arr[3] = "2024-02-06 00:00:00"; //이걸로 할까, 4번 시간문제에서 00시는 제외시켜야함 
//		        }
		        LocalDateTime ldt;
		        String voStrTime;
		        String checkTime = String.valueOf(arr[3]).replaceAll("[0-9:\\-T]", "").trim(); // - 는 이스케이프 처리해야 정상적용됨.
		        if(!"".equals(checkTime)) { //0-9,:,-,T 외에 뭔가 있다.
		        	arr[3] = "표기 오류 발생";
		        	ldt = null; //null해도 될까? 돼, continue로 건너뛸거야 
		        } else {
		        	ldt = LocalDateTime.parse(arr[3], dtf);
		        }
		        
		        LogVO vo = new LogVO(lineMaxim, Integer.parseInt(arr[0]),  arr[1], arr[2], ldt);
		        logVOList.add(vo);
		        String[] newData = {String.valueOf(lineMaxim), arr[0], arr[1], arr[2], arr[3]};
		        logAnalysis.getDtm().addRow(newData);
		        
		        lineMaxim++;
		        
			}
		} finally {
			logAnalysis.getJt().setModel(logAnalysis.getDtm());
			logAnalysis.repaint();
			
			logAnalysis.getOpendFileLabel().setText(file.getPath());
			logAnalysis.getLineFrom().setText("1");
			logAnalysis.getLineTo().setText(String.valueOf(lineMaxim -1));
			if(br != null) {
				br.close();
			}
		}
		
		
	}

//로그파일 분석 메서드 
	public void logAnalysis() {
		
		int startNum = Integer.parseInt(logAnalysis.getLineFrom().getText());
		int endNum = Integer.parseInt(logAnalysis.getLineTo().getText());
		
		
		
//--------------------- 로그파일 분석 버튼을 누르면, startNum과 endNum에 따라 DefaultTableModel() 재생성, repaint -----------------------------//
		//출력 범위 수정후 출력시, Dtm 초기화
		logAnalysis.getDtm().setNumRows(0);
		
		String[] strLogVO;
		
		for(int i = startNum-1; i < endNum; i++) {
			LogVO vo = logVOList.get(i);
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String strTime = String.valueOf(vo.getTime());
	        
	        //String.valueOf(vo.getTime()); //2024-02-06T09:11:53
	        
	        String voStrTime;
	        String checkTime = String.valueOf(vo.getTime()).replaceAll("[0-9:\\-T]", ""); // - 는 이스케이프 처리해야 정상적용됨.
	        if(!"".equals(checkTime) || vo.getTime() == null) { //0-9,:,-,T 외에 뭔가 있다. 아님 null이다.
	        	voStrTime = "표기 오류 발생";
	        } else {
	        	voStrTime = vo.getTime().format(dtf);
	        }
	        
			strLogVO = new String[]{String.valueOf(vo.getIndex()), String.valueOf(vo.getResponse()), vo.getUrl(), vo.getBrowser(), voStrTime};
			logAnalysis.getDtm().addRow(strLogVO);
			//addRow하면 DefaultTableModel이 자동으로 업데이트되므로 repaint() 피룡없음 
		}
		
//--------------------------------------------------
		
// 입력되는 라인에 해당되는 정보중에서: startNum ~ endNum
		/**
		 * public Map<String, Integer> getMostUsedKey(){
		      Map<String, Integer> tempMap = new HashMap<String, Integer>();
		      for(int i = 0; i < filteredLines.length; i++) {
		         String key = lsKey.get(i);
		         
		         //맵에 키가 존재하면 해당키를 반환
		         if(tempMap.get(key) != null) {
		         tempMap.put(key, (tempMap.get(key) + 1));
		         }
		         else {//맵에 키가 처음들어갔을때
		         tempMap.put(key, 1);
		         }
		      
		      }
		      
		      System.out.println("키 각각의 개수 : " + tempMap);
		      
		      Set<String> keySet = tempMap.keySet();
		      String currentKey = null;
		      int currentValue = 0;
		      String maxKey = null;
		      int maxValue = 0;
		      Iterator<String> keyIt = keySet.iterator();
		      for(int i = 0; i < tempMap.size(); i++) {
		         currentKey = keyIt.next();
		         currentValue = tempMap.get(currentKey);
		         
		         if(currentValue > maxValue) {
		            maxKey = currentKey;
		            maxValue = currentValue;
		            
		         }
		      }
		      tempMap.clear();
		      tempMap.put(maxKey, maxValue);
		      System.out.println(tempMap);
		      return tempMap;
		   }
		 * 
		 */
	// 1. 최다사용 키의 이름과 횟수
		
		//키와 횟수를 담을 set과 map 
		Set<String> keySet = new HashSet<>();
		Map<String, Integer> countKey = new HashMap<String, Integer>();
		
		//keySet에 key대입 
		for(int i = startNum -1; i < endNum; i++) { //밑에 logList는 index로 가져오니까, startNum()에 -1해줘야함
			LogVO vo = logVOList.get(i);  
			Map<String, String> orin = vo.getKeyValue();
		
			keySet.addAll(orin.keySet());
		}
		
		//키별 횟수 
		for(String key : keySet) {
			int keyCount = 0;
			
			for(int i = startNum -1; i < endNum; i++) {
				LogVO vo = logVOList.get(i);
				Map<String, String> orin = vo.getKeyValue();
				
				if(orin.containsKey(key)) {
					keyCount ++;
				}
			}
			countKey.put(key, keyCount); //키별로 갯수가 value로 들어감 
		}
		
		String mostQueryKey = null;
		int maxQueryCount = 0;
		
		for(String key : keySet) { //키마다 갯수를 불러와서 if문으로 최댓값 구하고, 해당 키 반환 
			int count = countKey.get(key);
			if(count > maxQueryCount) {
				maxQueryCount = count;
				mostQueryKey = key;
			}
		}
		
		//Label에 붙일 문자열 생성 
		StringBuilder sb = new StringBuilder();
		sb.append(mostQueryKey).append(" / ").append(maxQueryCount + "회 ");
		logAnalysis.getA1Label().setText(sb.toString());
		
		reportq1 = logAnalysis.getQ1Label().getText() + sb.toString();
		
	// 2. 브라우저별 접속횟수, 비율 -> 문제 잘못 읽음. 다시풀기
		Set<String> browserKey = new HashSet<String>();
		Map<String, Integer> countBrowser = new HashMap<>();

		for(int i = startNum -1; i < endNum; i++) {
			LogVO vo = logVOList.get(i);
			browserKey.add(vo.getBrowser()) ;
			
		}
		
		sb.setLength(0); //StringBuilder 초기화 
		//키별횟수
		for(String key : browserKey) {
			
			int keyCount = 0;
			for(int i = startNum -1; i < endNum; i++) {
				LogVO vo2 = logVOList.get(i);
				if(vo2.getBrowser().equals(key)) { //왜 ==는 안되던 걸까?
					keyCount++;
				}
			}
			
			countBrowser.put(key, keyCount);
			
			int total = endNum - startNum + 1;
			double per = (double)keyCount / (double)total * 100.0;
			String percent = String.format("%.2f", per);
			sb.append(key).append(" - ").append(keyCount).append("[" + percent+ "%] ");
		}
		logAnalysis.getA2Label().setText(sb.toString());
		
		reportq2 = logAnalysis.getQ2Label().getText() + sb.toString();

		
/**		
		//키 횟수 비교
		String mostBrowserKey = null;
		int maxBrowserCount = 0;
		
		for(String key : browserKey) {
			int count = countBrowser.get(key);
			if(count > maxBrowserCount) {
				maxBrowserCount = count;
				mostBrowserKey = key;
			}
		}
		System.out.println("젤 많이 쓰는 브라우저: " + mostBrowserKey + " 횟수: " + maxBrowserCount);
		//비율
		int browserTotal = endNum - startNum + 1;
		double pc = (double)maxBrowserCount / (double)browserTotal * 100.0;
		String percent = String.format("%.2f", pc);
		
		sb.setLength(0);
		//문제 잘못 품
		System.out.println(mostBrowserKey + "의 점유율은 " + percent + "% 입니다.");
*/		
		
	// 3. 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수
		int resp200 = 0;
		int resp404 = 0;
		for(int i = startNum-1; i < endNum; i++) {
			
			LogVO vo = logVOList.get(i);
			//if("200".equals( vo.getResponse())) { //String 으로 바꿔줘야한다. 비록 오류는 안나도.
			if("200".equals( String.valueOf(vo.getResponse()))) { 
				resp200++;
			}
			if("404".equals( String.valueOf(vo.getResponse()))) {
				resp404++;
			}
		}
		
		sb.setLength(0);
		sb.append("200응답 횟수: ").append(resp200).append("회, ")
			.append("404응답 횟수: ").append(resp404).append("회");
		
		logAnalysis.getA3Label().setText(sb.toString());
		
		reportq3 = logAnalysis.getQ3Label().getText() + sb.toString();

		
	//4. 요청이 가장 많은 시간(ora가 적힌 예외시간은 00시로 바꿨으므로, 00시는 제외한다)
		Set<Integer> hourSet = new HashSet<Integer>();
		Map<Integer, Integer> hourMap = new HashMap<Integer, Integer>();
		
		for(int i = startNum -1; i < endNum; i++) {
			LogVO vo = logVOList.get(i);
			int hour;
			try {
				hour = vo.getTime().getHour();
			} catch (Exception e) {
				continue; //hour이 null값이면 걍 건너뛰어 
			}
			
			hourSet.add(hour); //객체의 시간(HH)를 중복되지 않게 저장
			
		}
		
		// 시간대별로 이벤트 횟수 계산 (00시는 제외시키기, 나중에...)
		for(int hour : hourSet) {
			if(hour == 0) {
				continue;
			}
			
			int hourCount = 0;
			
			for(int i = startNum-1; i < endNum; i++) {
				LogVO vo = logVOList.get(i);
				if(vo.getTime() != null) {
					String strLogTime = String.valueOf( vo.getTime().getHour()) ;
					String strHour = String.valueOf(hour);
					if(strLogTime.equals(strHour)) {
						hourCount++;
					}
				} else {
					continue;
				}
			}
			hourMap.put(hour, hourCount);
		}
		
		//키와 맥스값 찾기
		int mostHourKey = 0;
		int maxHourCount = 0;
		
		for(int hour : hourSet) {
			int count = hourMap.get(hour); //-> 위에 hourMap.put(hour, hourCount); 해놨으니까 가져오면됨
			if(count > maxHourCount) {
				maxHourCount = count;
				mostHourKey = hour;
			}
		}
		
		sb.setLength(0);
		sb.append(mostHourKey).append("시 ").append(maxHourCount).append("회");
		logAnalysis.getA4Label().setText(sb.toString());
		reportq4 = logAnalysis.getQ4Label().getText() + sb.toString();

		
	//5. 비정상적인 요청(403)이 발생한 횟수,비율구하기
		int resp403 = 0;
		for(int i = startNum-1; i < endNum; i++) {
			LogVO vo = logVOList.get(i);
			String respNum = String.valueOf(vo.getResponse());
			if("403".equals(respNum)) {
				resp403++;
			}
		}
		int respTotal = endNum - startNum +1;
		double percent1 = (double)resp403 / (double)respTotal * 100.0;
		String percent2 = String.format("%.2f", percent1);
		
		sb.setLength(0);
		sb.append(resp403).append("회, ").append(percent2).append("%");
		logAnalysis.getA5Label().setText(sb.toString());
		
		reportq5 = logAnalysis.getQ5Label().getText() + sb.toString();

	
	//6. books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기(	
		int resp500 = 0;
		for(int i = startNum-1; i < endNum; i++) {
			LogVO vo = logVOList.get(i);
			String resp = String.valueOf( vo.getResponse());
			if(vo.getUrl().split("\\?")[0].contains("books") && "500".equals(resp)) {
				resp500++;
			}
		}
		System.out.println("books에 대한 요청중 에러(500)이 발생한 횟수: " + resp500);
		int bookRespTotal = endNum - startNum + 1;
		double bookP = (double)resp500/(double)bookRespTotal * 100.0;
		String bPercent = String.format("%.2f", bookP);
		
		sb.setLength(0);
		sb.append(resp500).append("회, ").append(bPercent).append("%");
		logAnalysis.getA6Label().setText(sb.toString());
		
		reportq6 = logAnalysis.getQ6Label().getText() + sb.toString();

	}
	
	//레포트 작성 
	public void getReport() throws FileNotFoundException, IOException {
		
		//디렉토리 생성
		String strTime = String.valueOf(System.currentTimeMillis());
		
		File dir = new File("c:/dev/report");
		if(!dir.exists()) {
			dir.mkdirs(); //없으면 만들어 
		}
		
		//파일생성
		File file = new File(dir.getAbsolutePath() + File.separator + strTime + ".dat");

		// 파일 덮어쓰기 검사 
		boolean writeFlag = true; //값에 따라 덮어쓸지, 취소할지 결정 
		
		if (file.exists()) {
			int choice = JOptionPane.showConfirmDialog(null, file + "이 존재합니다. \n덮어쓰시겠습니까?");
			switch (choice) {
			case JOptionPane.YES_OPTION: writeFlag = true; break; //네
			case JOptionPane.NO_OPTION:  writeFlag = false; break; //아니오 

			}
		}
		
		if(!writeFlag) {
			System.out.println("덮어쓰지 않고 종료.");
			return;
		}
		
		//스트림 연결
		try (FileOutputStream fos = new FileOutputStream(file)){ //이렇게하면 .close()가 필요없어, 자동으로 닫혀 
			//DataOutputStream 이걸쓸까??
			
			String report = createReport();
			
		//스트림에 데이터 기록
			byte[] reportByte = report.getBytes();
			fos.write(reportByte);//byte[]로.. 
			//fos.writeUTF(report);
			
			//명시적으로 flush
			fos.flush();
			System.out.println("파일에 기록이 완료되었다.");
		} 
		
	}
	
	public String createReport() {
		System.out.println("출력할 자료를 뽑아봅니다.");
		
	//로그데이터 뽑기
		Vector<Vector> data = new Vector<Vector>();
		data = logAnalysis.getDtm().getDataVector();
		Iterator iter = data.iterator(); //Vector도 Iterator가 되네!!
		
		StringBuilder sb = new StringBuilder();
		
		while(iter.hasNext()) {
			//System.out.println(iter.next());
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb.toString());
		sb.append("\n-----------------------------------------\n");
		
	//메서드 결과 호출
		sb.append(reportq1).append("\n\n");
		sb.append(reportq2).append("\n\n");
		sb.append(reportq3).append("\n\n");
		sb.append(reportq4).append("\n\n");
		sb.append(reportq5).append("\n\n");
		sb.append(reportq6).append("\n\n");
		
		
		return sb.toString();
	}
	
	
	
}
