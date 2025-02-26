package logproject;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class logAnalyzeEvt {

	MainView mv;
	
	public logAnalyzeEvt(MainView mv) throws IOException {
		this.mv = mv;
		
		JFileChooser jfc = new JFileChooser("c:/dev/temp");
		jfc.showOpenDialog(mv);
		File file = jfc.getSelectedFile();
		
	}
}
