package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 소켓을 통해 메시지를 보내는 역할만 담당하는 스레드
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner scanner;

	public Sender(Socket socket) {
		super();
		this.socket = socket;
		scanner = new Scanner(System.in);

		System.out.println("이름 입력 >> ");
		name = scanner.nextLine();

		try {
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 메시지를 Scanner로 입력받아서 상대방에게 보낸다
		while (dout != null) {
			try {
				dout.writeUTF(name + " : " + scanner.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
