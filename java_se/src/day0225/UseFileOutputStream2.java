package day0225;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseFileOutputStream2 {

	/**
	 * try~with~resources 사용
	 * 연결을 제공하는 객체에서 try~with~resources를 지원하면 자동으로 연결을 끊어준다.
	 */
	public UseFileOutputStream2()  {
		//1. 디렉토리를 생성
		File dir = new File("c:/dev/temp");
		if(!dir.exists()) { //디렉토리가 없으면 생성
			dir.mkdirs();
		}
		
		//window 경로 구분 \, linux 경로 구분 /
		//2. 파일 생성
		File file = new File(dir.getAbsolutePath() + File.separator + "text.txt");
		
		//3. 스트림 연결
		//try~with~resources를 사용하면 해당 스트림의 관련된 연결을 모두 자동으로 끊어준다.
		try(FileOutputStream fos = new FileOutputStream(file) ) {
			int data = 66;
			//4. 스트림에 데이터를 기록
			fos.write(data);
			//5. 스트림에 기록된 데이터를 목적지로 분출!
			fos.flush(); //참조형인 경우에만
			System.out.println("파일에 기록이 완료되었습니다.");
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UseFileOutputStream2();
	}

}
