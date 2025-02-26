package day0226;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/**
 * 객체를 JVM 외부로 내보내고, 읽어들이는 일. 
 */
public class UseObjectStream {

	public void writeObject(File file, UserDataVO udVO) throws IOException {
		ObjectOutputStream oos = null;
		try {
			//1.객체를 내보낼 수 있는 스트림 생성
			oos = new ObjectOutputStream(new FileOutputStream(file));
			//2.객체를 잘라서 내보내기 (객체 직렬화)
			oos.writeObject(udVO);
			//3. 스트림 안의 내용을 목적지로 분출
		} finally {
			if(oos != null) oos.close();
		}
	}
	
	public UserDataVO readObject(File file) throws IOException, ClassNotFoundException {
		UserDataVO udVO = null;
		ObjectInputStream ois = null;
		
		try {
			//스트림 연결
			ois = new ObjectInputStream(new FileInputStream(file));
			//객체 읽기
			udVO = (UserDataVO)ois.readObject();
		}finally {
			if(ois != null) ois.close();
		}
		return udVO;
	}
	public static void main(String[] args) {

		UseObjectStream uos = new UseObjectStream();
		String inputMenu = JOptionPane.showInputDialog("아래의 번호를 입력\n 1-객체쓰기, 2-객체읽기");
		
		if(inputMenu != null) {
			File file = new File("c:/dev/temp/obj.txt");
			if("1".equals(inputMenu)) {
				UserDataVO udVO = new UserDataVO("강태일", 185.7, 74.2);
				try {
					uos.writeObject(file, udVO);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("객체 쓰기 완료:" + udVO );
			}
			if("2".equals(inputMenu)) {
				try {
					UserDataVO udVO = uos.readObject(file);
					System.out.println("객체의 값 읽기:" + udVO);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException ce) {
					ce.printStackTrace();
				}
			}
		}
	}

}
