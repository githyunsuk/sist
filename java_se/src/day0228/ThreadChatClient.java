package day0228;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 1.소켓을 열어서 서버에 접속 시도 (PORT) 2.메세지를 읽어들이는 일(Socket)이 무한루프 동작 3.J.T.F에서 이벤트가
 * 발생하면 메시지를 보내는 일(socket)
 * 
 */
@SuppressWarnings("serial")
public class ThreadChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkDisplay;
	private JTextField jtfTalk;

	private Socket client; // 서버에 연결을 하기 위해서 사용.
	private DataInputStream disReadStream; // 대화를 읽어들이기 위한 스트림
	private DataOutputStream dosWriteStream; // 대화를 쓰기 위한 스트림

	private String nick; // 대화명

	public ThreadChatClient() {
		super("::::::::::채팅 클라이언트:::::::::::::::");

		jtaTalkDisplay = new JTextArea();
		jspJtaTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jtfTalk = new JTextField();
		jspJtaTalkDisplay.setBorder(new TitledBorder("대화내용"));
		jtaTalkDisplay.setEditable(false);
		jtaTalkDisplay.setBackground(Color.WHITE);

		jtfTalk.setBorder(new TitledBorder("대화"));

		add("Center", jspJtaTalkDisplay);
		add("South", jtfTalk);

		setBounds(100, 100, 400, 600);
		setVisible(true);

		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jtfTalk.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing

			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					System.exit(ABORT);
				}
			}
		});

		jtfTalk.requestFocus();
	}// SmpleChatClient

	private void connectToServer() throws UnknownHostException, IOException {
		String connectIp = JOptionPane.showInputDialog("접속할 서버의 주소\n68~98번", "192.168.10.");

		nick = JOptionPane.showInputDialog("대화명을 입력해주세요");

		client = new Socket(connectIp, 55000); // 서버에 연결화여 회선 확립
		jtaTalkDisplay.setText(connectIp + "서버에 접속하셨습니다.\n");
		// 대화를 보내고 얻기 위해 스트림 연결
		disReadStream = new DataInputStream(client.getInputStream());
		dosWriteStream = new DataOutputStream(client.getOutputStream());

		jtaTalkDisplay.append(nick + "님 즐거움 대화를 나누세요.\n");

//		readMsg(); // 상대방이 보내오는 메시지를 무한으로 읽어들인다.
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
//	private void readMsg() throws IOException {
		if (disReadStream != null) {
			try {
				while (true) {
					jtaTalkDisplay.append(disReadStream.readUTF());
					jtaTalkDisplay.append("\n");
					scrollMove();
				}
			} catch (IOException ie) {
				jtaTalkDisplay.append("접속자가 퇴장하였습니다");
				scrollMove();
				ie.printStackTrace();
			}
		}
	}
	
	/**
	 * 스크롤바를 가장 아랫줄 이동
	 */
	private void scrollMove() {
		//vertical scroll의 값을 변경
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(
				jspJtaTalkDisplay.getVerticalScrollBar().getMaximum()
				);
	}

	private void sendMsg() throws IOException {
		String inputMsg = jtfTalk.getText();
		StringBuilder sendMsg = new StringBuilder();
		sendMsg.append("[").append(nick).append("]").append(inputMsg);

		// 내가 작성한 메시지를 내 대화창에 올리고
		jtaTalkDisplay.append(sendMsg.toString());
		jtaTalkDisplay.append("\n");
		scrollMove();
		// 대화 상대에게 메시지를 보내준다.
		dosWriteStream.writeUTF(sendMsg.toString());
		dosWriteStream.flush();
		
		jtfTalk.setText("");
	}

	private void close() throws IOException {
		if (disReadStream != null)
			disReadStream.close();
		if (dosWriteStream != null)
			dosWriteStream.close();
		if (client != null)
			client.close();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}// actionPerformed

	public static void main(String[] args) {
		new ThreadChatClient();
	}// main

}// class
