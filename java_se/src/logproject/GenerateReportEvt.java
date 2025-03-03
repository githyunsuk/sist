package logproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GenerateReportEvt {

	private StringBuilder[] reportData;
	
	public GenerateReportEvt(MainView mv, LogAnalyzeEvt lae, File logFile) throws IOException {

		//LogAnalyzeEvt에서 데이터 가져오기
		
		reportData = lae.getSb();
		//레포트 저장 디렉토리 생성
		File reportdir = new File("c:/dev/report");
		if( !reportdir.exists() ) {
			reportdir.mkdirs();
		}
		
		//타임스탬프를 파일명으로 사용하여 레포트 파일 생성
		File reportfile = new File(reportdir.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".dat");
		
		//try ~ with ~ resources를 이용
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportfile))){
			
			bw.write("-----------------------------------------------------------------------------------\n");
			bw.write("파일명 (" + logFile.getAbsolutePath() + ") log\n");
			bw.write("-----------------------------------------------------------------------------------\n");
			bw.write("최다 사용키와 횟수: " + reportData[0] + "\n\n");
			bw.write("브라우저별 접속 횟수, 비율: " + reportData[1] + "\n\n");
			bw.write("200응답 횟수, 400응답 횟수: " + reportData[2] + "\n\n");
			bw.write("요청이 가장 많은 시간: " + reportData[3] + "\n\n");
			bw.write("403응답 횟수, 비율: " + reportData[4] + "\n\n");
			bw.write("books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율: " + reportData[5] + "\n");
			
		}
		JOptionPane.showMessageDialog(mv, "레포트 생성 완료");
	}
}
