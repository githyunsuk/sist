package day0226;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileCopyNio {

	public FileCopyNio() throws IOException {
		JFileChooser jfcOpen = new JFileChooser();
		jfcOpen.showOpenDialog(null);
		
		File originalFileName = jfcOpen.getSelectedFile();
		if(originalFileName == null) {
			return;
		}
		//복사할 파일명 생성: 원본 파일_copy.확장
		StringBuilder copyFileName = new StringBuilder(originalFileName.getAbsolutePath());
		copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");

		File copyFile = new File(copyFileName.toString());

		//1. 원본 파일 선택
//		Paths original = Paths.get(originalFileName.getAbsolutePath());
		//JDK11에서부터는 Path.of()로 작업 가능
		Path original = Path.of(originalFileName.getAbsolutePath());
		
		//2. 복사할 파일 설정
		Path copy = Path.of(copyFile.getAbsolutePath());
		
		//3. 복사 수행
		Files.copy(original,copy, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void main(String[] args) {
		try {
			new FileCopyNio();
			System.out.println("파일 복사 성공");
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "파일 복사 도중 문제 발생");
			e.printStackTrace();
		}
			
	}

}
