package day0225;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 문자열을 파일에 기록 
 */
public class UseBufferedWriter {

	/**
	 * 8bit + 16bit stream 결합
	 */
	public void useFileOutputStream() {
		
		String msg = "오늘은 25일 화요일 입니다.";
		
		File file = new File("c:/dev/temp/text.txt");
		//try~with~resources 사용: close()가 자동으로 처리된다.
		//2. 스트림 연결
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
			//3.데이터를 스트림에 기록
			bw.write(msg);
			//4.스트림의 내용을 목적지로 분출
			bw.flush();
			System.out.println("파일에 기록 되었습니다.");
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	/**
	 * 16bit stream만 사용.
	 */
	public void useBufferedWriter() throws IOException {
		String data = "내일은 수요일 입니다.";
		
		File file = new File("c:/dev/temp/test.txt");
		
		BufferedWriter bw = null;
		try {
			//스트림 연결
			bw = new BufferedWriter(new FileWriter(file));
			//스트림에 데이터를 기록
			bw.write(data);
			//스트림에 내용을 목적지로 분출
			System.out.println("스트림에 데이터를 기록");
//			bw.fluh 
			System.out.println("스트림에 기록된 데이터를 목적지 파일로 분출");
			
		} finally {
			if(bw != null) bw.close();
		}
	}
	
	public static void main(String[] args) {
		UseBufferedWriter ubw = new UseBufferedWriter();
//		ubw.useFileOutputStream();
		try {
			ubw.useBufferedWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
