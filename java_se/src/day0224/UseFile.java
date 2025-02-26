package day0224;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 파일에 대한 정보 얻기, 디렉토리 생성작업, 파일관리( 파일명 변경, 파일 삭제) 
 */
public class UseFile {

	public void fileInfo() {
		File file = new File("c:/dev/temp/java_read.txt");
		System.out.println(file);
		
		if(!file.exists()) { //파일이 존재하는지
			return;
		}
		
		System.out.println("파일의 길이 :" + file.length() + " byte");
		
		System.out.println(file.isDirectory()?"디렉토리":"파일");
		System.out.println(file.isFile()?"파일":"디렉토리");
		
		System.out.println(file.canRead()?"읽기 가능":"읽기 불가능");
		System.out.println(file.canWrite()?"쓰기 가능":"쓰기 불가능");
		System.out.println(file.canExecute()?"실행 가능":"실행 불가능");
		System.out.println("절대경로:" + file.getAbsolutePath());
		System.out.println("경로:" + file.getPath());
		try {
			//OS에서 파일에 접근하기 위한 단 하나의 경로.
			System.out.println("규범경로:" + file.getCanonicalPath());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("디렉토리명:" + file.getParent());
		System.out.println("파일명:" + file.getName());
		
//		JFileChooser jfc = new JFileChooser();
//		jfc.showOpenDialog(null);
//		
//		File selectedFile = jfc.getSelectedFile();
//		System.out.println("디렉토리명:" + selectedFile.getParent());
//		System.out.println("파일명:" + selectedFile.getName());
		
		System.out.println(file.isHidden()?"숨김파일":"일반파일");
		
		long fileMs = file.lastModified();
		System.out.println("마지막 수정:" + fileMs);
		
		Date date = new Date(fileMs);
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM EEEE HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	
	public void dirWork() {
		//1. 생성할 디렉토리 명을 가진 File 생성)
		File createDir = new File("c:/dev/java/kws");
		//2. 디렉토리 생성
		if(createDir.exists()) {
			JOptionPane.showMessageDialog(null, "디렉토리가 이미 존재합니다");                                                         
			return;
		}
		
		String result = "디렉토리 생성 실패";
		if(createDir.mkdir()) {
			result = "디렉토리 생성 성공";
		}
		System.out.println(result);
	
	}
	
	public void fileRename() {
		//1.이전 파일명
		File originalFile = new File("c:/dev/temp/java_read.txt");
		//2.변경할 파일명
		File renameFile = new File("c:/dev/temp/java_read2.txt");
		//3.변경
		originalFile.renameTo(renameFile);
	}
	
	public void fileRemove() {
		//1. 삭제할 파일을 선택
		File renameFile = new File("c:/dev/temp/java_read.txt");		
		//2. 삭제
		renameFile.delete();
	}
	
	public static void main(String[] args) {
		UseFile uf = new UseFile();
		System.out.println("파일 정보 얻기");
		uf.fileInfo();
		
		System.out.println("-------------------------------");
		System.out.println("디렉터리 관리");
		uf.dirWork();
		
		System.out.println("-------------------------------");
		System.out.println("파일명 변경");
		uf.fileRename();
		
		System.out.println("파일 제거");
		uf.fileRemove();
	}

}
