package day0225;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileCopy {

	public FileCopy() throws IOException {
		JFileChooser jfcOpen = new JFileChooser();
		jfcOpen.showOpenDialog(null);
		
		File file = jfcOpen.getSelectedFile();
		if(file == null) {
			return;
		}
		
		//복사할 파일명 생성: 원본 파일_copy.확장
		StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
		copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");

		File copyFile = new File(copyFileName.toString());
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//파일에서 데이터를 읽기 위한 스트림 연결
			fis = new FileInputStream(file); //원본 파일과 연결
			//파일에서 데이터를 쓰기 위한 스트림 연결
			fos = new FileOutputStream(copyFile);
			
//			int fileData = 0;
			//데이터를 1byte씩 읽어들여 EOF 아니면 : HHD의 특성을 무시한 코드 => 속도 오짐
//			while ((fileData = fis.read()) != -1) {
//				fos.write(fileData); //스트림에 읽어들인 1byte만 기록
//			}
//			fos.flush();
			
			//HDD의 head는 한번에 제조사마다 다르긴 하지만 일반적으로 512byte씩 읽어 들임.
			
			byte[] readData = new byte[512];
			int readSize = 0;
			int cnt = 0;
			while((readSize = fis.read(readData)) != -1) {
				cnt++;
			}
			System.out.println("총 " + cnt + "번 읽어들임");
		} finally {
			if(fis != null) fis.close();
			if( fos!= null) fos.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new FileCopy();
			System.out.println("파일 복사 성공");
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "파일 복사 도중 문제 발생");
			e.printStackTrace();
		}
			
	}

}
