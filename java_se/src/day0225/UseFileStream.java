package day0225;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File과 연결하는 작업 
 */
public class UseFileStream {

	/**
	 * 8bit stream + 16bit stream 연결 사용
	 */
	public void useFileInputStream() throws IOException {
		//1. Filed 생성
		File file = new File("c:/dev/temp/java_read2.txt");
		if(!file.exists()) {
			System.out.println(file + "이 존재하지 않습니다.");
			return;
		}
		
		//2. Stream 연결하여 생성
//		FileInputStream fis = new FileInputStream(file);
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		//3. 파일 안의 내용을 읽어 들임( 반복 )
		String str = "";
		try {
			while((str = br.readLine()) != null) {
			System.out.println(str);
			}
		} finally {
			if(br != null) br.close();
		}
	}
	
	/**
	 * 16bit stream 구성
	 */
	public void useFileReader() throws IOException {
		File file = new File("c:/dev/temp/java_read.txt");
		if(!file.exists()) {
			System.out.println(file + "이 존재하지 않습니다.");
			return;
		}
		
		//2. Stream 연결하여 생성
//		FileReaderStream fr = new FileReaderStream(file);
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);
		
		//3. 파일 안의 내용을 읽어 들임( 반복 )
		BufferedReader br = null;
		String str = "";
		try {
			br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
			System.out.println(str);
			}
		} finally {
			if(br != null) br.close();
		}
	}
	
	public static void main(String[] args) {

		UseFileStream ufs = new UseFileStream();
		System.out.println("---------8bit + 16bit-----------------");
		try {
			ufs.useFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("------------16 bit--------------------");
		try {
			ufs.useFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
