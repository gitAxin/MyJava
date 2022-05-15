package cn.giteasy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 可持续发送，用户输入的数据
 */
public class Demo02Send {


	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 8888;
		DatagramSocket socket = new DatagramSocket();

		Scanner scanner = new Scanner(System.in);

		while (true){
			String str = scanner.nextLine();
			if("exit".equals(str)){
				break;
			}

			DatagramPacket packet =
					new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(host), port);
			socket.send(packet);
		}

		socket.close();
	}

}
