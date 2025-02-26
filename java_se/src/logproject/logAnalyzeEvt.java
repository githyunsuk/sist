package logproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.JFileChooser;

public class logAnalyzeEvt {

	MainView mv;
	HashMap<String, Integer> serviceMap = new HashMap<>();
	HashMap<String, Integer> browserMap = new HashMap<>();
	HashMap<String, Integer> keyMap = new HashMap<>();
	HashMap<String, Integer> timeMap = new HashMap<>();
	
	private String serviceKey;
	private String browserKey;
	private String keyKey;
	private String timeKey;
	
	
	public logAnalyzeEvt(MainView mv) throws IOException {
		this.mv = mv;
		
		JFileChooser jfc = new JFileChooser("c:/dev/temp");
		jfc.showOpenDialog(mv);
		File file = jfc.getSelectedFile();
		
		if(file == null) return;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = "";
		try {
			while((str = br.readLine()) != null) {
				mv.getJta().append(str+"\n");
				LogVO lvo = new LogVO(str);
			
				serviceKey = lvo.getService();
				browserKey = lvo.getBrowserName();
				keyKey = lvo.getKeyName();
				timeKey = lvo.getTime();
				
				serviceMap.put(serviceKey, serviceMap.getOrDefault(serviceKey, 0) + 1);
				browserMap.put(browserKey, browserMap.getOrDefault(browserKey, 0) + 1);
				keyMap.put(keyKey, keyMap.getOrDefault(keyKey, 0) + 1);
				timeMap.put(timeKey, timeMap.getOrDefault(timeKey, 0) + 1);
				
			}
		} finally {
			if(br != null) br.close();
		}
	}
}
