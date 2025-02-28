package smk;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LogVO {

	private int index;
	private int response;
	private String url;
	private String browser;
	private LocalDateTime time;
	
	private Map<String, String> keyValue;
	
	public LogVO(int index, int response, String url, String browser, LocalDateTime time) {
		this.index = index;
		this.response = response;
		this.url = url;
		this.browser = browser;
		this.time = time;
		
		this.keyValue = new HashMap<String, String>();
	}
	
	// url에서 키와 값 map 구하기 --> URL이 너무 거지같아서 나누질 못하겄네 
	// time쪽 에러떠도, KEY값이 있다면 KEY에 포함해야 한다. -> 예외처리 하라는 과제 
	public Map<String, String> getKeyValue() {
		if( (url.contains("key=")) && (url.contains("&query="))) { //키와 벨류가 정상적으로 있을 때.
			String keyval = url.split("key=")[1];
			String key = keyval.split("&")[0];
			String value = keyval.split("&")[1].split("=")[1];
			
			keyValue.put(key, value);
			
		//403error -> ?query=sist 형식의 쿼리(key가 없음)을위한 대응  
		} else {
			String key = null; //null로 해도 문제없나 모름 -> 예외처리에서 continue로 처리  
			String value = null;
			
			keyValue.put(key, value);
		}
		return keyValue;
		
	}
	
	public void setKeyValue(Map<String, String> keyValue) {
		this.keyValue = keyValue;
	}
	public int getIndex() {
		return index;
	}
	public int getResponse() {
		return response;
	}
	public String getUrl() {
		return url;
	}
	public String getBrowser() {
		return browser;
	}
	public LocalDateTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "LogVO [index=" + index + ", response=" + response + ", url=" + url + ", browser=" + browser + ", time="
				+ time + ", keyValue=" + keyValue + "]";
	}
	
	
}
