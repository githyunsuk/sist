package day0224;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FileInputStream을 사용하여 파일의 내용읽기 
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		
		JFileChooser jfc = new JFileChooser("c:/dev");
		jfc.showOpenDialog(null);
		
		File file = jfc.getSelectedFile();
		
		if(!file.exists()) {
			JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다");
			return;
		}
		
		FileInputStream fis = new FileInputStream(file);
		int readData = 0;
		try {
			while((readData = fis.read()) != -1) {
				System.out.println((char)readData);
			}
		} finally {
			if(fis != null) {
				fis.close();
			}
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
