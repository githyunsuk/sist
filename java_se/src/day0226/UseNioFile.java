package day0226;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseNioFile {

	public UseNioFile() throws IOException {
		
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		
		File selectedFile = jfc.getSelectedFile();
		
		if(selectedFile == null) return;
		
		//N I/O를 상요한 파일 내용 읽기
		//1. Path 얻기
		Path path = Paths.get(selectedFile.getAbsolutePath());
		//2. 파일의 모든 내용을 읽어들임.
		List<String> allLines = Files.readAllLines(path);
		StringBuilder output = new StringBuilder();
		//읽어들인 파일의 내용을 출력하기 위해 StringBuilder에 저장
		for(String line : allLines) {
			output.append(line).append("\n");
		}
		
		JTextArea jta = new JTextArea(output.toString(), 40, 80);
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
	}
	
	public static void main(String[] args) {
		try {
			new UseNioFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
