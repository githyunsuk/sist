package day0227;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 서버의 주소와 서버포트를 사설정하여 서버의 연결하는 클라이언트 
 */
public class TestClient {

	public TestClient() throws UnknownHostException, IOException {
		//2. 서버의 ip address와 서버의 port 소켓을 생성
		//자신 컴퓨터의 임의의 포트를 열고 서버에 접속을 시도한다.
		Socket client = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			String connectIP =
			JOptionPane.showInputDialog("접속할 서버 ip\n68~98번까지 가능","192.168.10.");
			client=new Socket(connectIP, 65000);
			System.out.println("서버에 접속: " + client);
			//서버가 제공하는 메시지 받기 -> 입력 스트림 필요
			dis = new DataInputStream(client.getInputStream());
			//소켓에 연결된 스트림에서 데이터 읽기
			String revMsg = dis.readUTF();
			String sendMsg = JOptionPane.showInputDialog(revMsg);
			JOptionPane.showInputDialog(null, revMsg);
			//메시지를 서버로 전송하기 위한 출력 스트림을 소켓으로 부터 얻는다.
			dos = new DataOutputStream(client.getOutputStream());
			//메시지를 스트림에 기록
			dos.writeUTF(sendMsg);
		} finally {
			if(client != null) client.close();
		}
			
	}
	
	public static void main(String[] args) {
		try {
			new TestClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
