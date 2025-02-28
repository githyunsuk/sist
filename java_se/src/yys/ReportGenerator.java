package yys;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportGenerator {
	
	public static void generateReport(String reportContent) {
		
		String reportPath="c:/dev/report/report_" + System.currentTimeMillis()+".dat";
		new File("c:/dev/report");
		
	  try {
		PrintWriter writer = new PrintWriter(new FileWriter(reportPath));
//		
//		writer.write(reportContent);
//
//        // 파일 작성 후 반드시 닫아야 함
//        writer.close();
        
	} catch (IOException e) {
		e.printStackTrace();
	}//end catch
	  
	 
	  
	  }//end try
}//class