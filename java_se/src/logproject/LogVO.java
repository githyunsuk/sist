package logproject;

public class LogVO {

	private String logMsg;
	private String service;
	private String browserName;
	private String keyName;
	private String time;
	private boolean isBooks = false;
	
	public LogVO(String line) {
		
		//기존 문자열을 쪼개기 전 원본 상태로 저장
		logMsg = line;
		
		//받아들인 라인을 ']' 기준으로 쪼개 배열에 저장
		String[] lineArr = line.split("]");
		
		service = lineArr[0].substring(1);
		
		int startIdx = lineArr[1].indexOf("key=") + 4;
		int endIdx = lineArr[1].indexOf("&");
		if(startIdx != -1 && endIdx != -1) {
			keyName = lineArr[1].substring(startIdx, endIdx); //오류			
		}
		
		browserName = lineArr[2].substring(1);
		
		startIdx = lineArr[3].indexOf(" ") + 1;
		endIdx = lineArr[3].indexOf(":");
		time = lineArr[3].substring(startIdx, endIdx);
		
		startIdx = lineArr[1].indexOf("find/") + 5;
		endIdx = lineArr[1].indexOf("?");
		if(endIdx != -1 && lineArr[1].substring(startIdx, endIdx).equals("books")) {
			isBooks = true;
		}
		
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public boolean isBooks() {
		return isBooks;
	}

	public void setBooks(boolean isBooks) {
		this.isBooks = isBooks;
	}

	public String getLogMsg() {
		return logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	
	
	
}
