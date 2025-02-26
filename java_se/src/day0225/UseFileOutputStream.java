package day0225;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UseFileOutputStream extends JFrame{

	public UseFileOutputStream() throws IOException {
		//1. 디렉토리를 생성
		File dir = new File("c:/dev/temp");
		if(!dir.exists()) { //디렉토리가 없으면 생성
			dir.mkdirs();
		}
		
		//window 경로 구분 \, linux 경로 구분 /
		//2. 파일 생성
		File file = new File(dir.getAbsolutePath() + File.separator + "text.txt");
		
		//파일이 존재하면 덮어쓸 것인지를 confirmDialog() 사용하여 물어보고
		//예가 눌리면 덮어쓰고, 아니오나 취솩 눌리면 덮어쓰지 않는 코드를 작성.
		boolean writeFlag = file.exists();
		if(writeFlag) { //파일이 존재하면
			switch(JOptionPane.showConfirmDialog(null, file+"이 존재합니다.\n덮어쓰시겠습니까")) {
			case JOptionPane.OK_OPTION:
				writeFlag = false;
				break;
			}
			
		}
		if( writeFlag) {
			System.out.println("덮어쓰지 않음");
			return;
		}
		
		//3. 스트림 연결
		FileOutputStream fos = null;
		try {
			fos =new FileOutputStream(file);
			int data = 65;
			//4. 스트림에 데이터를 기록
			fos.write(data);
			//5. 스트림에 기록된 데이터를 목적지로 분출!
			fos.flush(); //참조형인 경우에만
			System.out.println("파일에 기록이 완료되었습니다.");
		} finally {
			//6. 스트림을 사용했다면 연결을 끊어준다.
			if(fos != null) fos.close();
			
		}
	}
	public static void main(String[] args) {
		try {
			new UseFileOutputStream();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
