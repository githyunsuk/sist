package logproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GenerateReportEvt {

	private MainView mv;
	private LogAnalyzeEvt lae;
	private StringBuilder[] sb;
	
	public GenerateReportEvt(MainView mv, LogAnalyzeEvt lae) throws IOException {
		this.mv = mv;
		this.lae = lae;
		sb = lae.getSb();
		
		File dir = new File("c:/dev/report");
		if( !dir.exists() ) {
			dir.mkdirs();
		}
		
		File file = new File(dir,"report_" + System.currentTimeMillis() + ".dat");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			
			bw.write("-------------------------------------------------------\n");
			bw.write("파일명 (" + lae.getFile().getAbsolutePath() + ") log\n");
			bw.write("-------------------------------------------------------\n");
			bw.write(sb[0].toString());
			bw.write(sb[1].toString());
			bw.write(sb[2].toString());
			bw.write(sb[3].toString());
			bw.write(sb[4].toString());
			bw.write(sb[5].toString());
			JOptionPane.showMessageDialog(mv, "레포트 생성 완료");
		} finally {
			if(bw != null) bw.close();
		}
		
	}
}
