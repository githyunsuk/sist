package logproject;

public class LogVO {

	private String logMsg, service, browserName, keyName, time;
	private boolean isBooks = false;

	public LogVO(String line) {

		// 기존 문자열을 쪼개기 전 원본 상태로 저장
		logMsg = line;

		// ']' 기분으로 라인 분리
		String[] lineArr = line.split("]");

		// 서비스 추출
		service = lineArr[0].substring(1);

		// 키 이름 추출
		keyName = extractKeyName(lineArr[1]);

		// 브라우저 추출
		browserName = lineArr[2].substring(1);

		// 시간 추출
		time = extractTime(lineArr[3]);

		// books 인지 체크
		isBooks = checkIsBooks(lineArr[1]);

	}

	//key 이름 추출 method
	private String extractKeyName(String str) {
		int startIdx = str.indexOf("key=") + 4;
		int endIdx = str.indexOf("&", startIdx);
		return (startIdx != -1 && endIdx != -1) ? str.substring(startIdx, endIdx) : "";
	}

	//시간 추출 method
	private String extractTime(String part) {
        int startIdx = part.indexOf(" ") + 1;
        int endIdx = part.indexOf(":");
        return (startIdx != -1 && endIdx != -1) ? part.substring(startIdx, endIdx) : "";
    }

	//books 여부 체크하는 method
    private boolean checkIsBooks(String part) {
        int startIdx = part.indexOf("find/") + 5;
        int endIdx = part.indexOf("?", startIdx);
        return (endIdx != -1 && part.substring(startIdx, endIdx).equals("books"));
    }
	public String getLogMsg() {
		return logMsg;
	}

	public String getService() {
		return service;
	}

	public String getBrowserName() {
		return browserName;
	}

	public String getKeyName() {
		return keyName;
	}

	public String getTime() {
		return time;
	}

	public boolean isBooks() {
		return isBooks;
	}

}
