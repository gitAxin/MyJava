package cn.giteasy.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 使用多线程实现:发送和接收在同一进程内进行
 */
public class Demo03SendAndReceive {


	public static void main(String[] args) {
		//接收端线程
		Receive receive = new Receive(8888);
		//发送端线程
		Send send = new Send("localhost", 8888);

		receive.start();
		send.start();

	}

}

class Receive extends Thread {

	private int port;

	Receive(int port){
		this.port = port;
	}
	@Override
	public void run() {
		try {

			DatagramSocket socket = new DatagramSocket(port);
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			while(true){
				socket.receive(packet);
				byte[] arr = packet.getData();
				int len = packet.getLength();
				String hostAddress = packet.getAddress().getHostAddress();
				int sendPort = packet.getPort();
				System.out.println(hostAddress+":" + sendPort + " => " +new String(arr,0,len));
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class Send extends Thread {

	private String host;
	private int port;

	Send(String host,int port){
		this.host = host;
		this.port = port;
	}



	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket();
			Scanner scanner = new Scanner(System.in);
			while (true){
				System.out.print(host + ":" + port + " <= 请输入要发送的消息：");
				String str = scanner.nextLine();
				if("exit".equals(str)){
					break;
				}

				DatagramPacket packet =
						new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(host), port);
				socket.send(packet);

				try {
					//等待接收端打印完成，最好的办法是使用线程间通信实现，wait 和 notify
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			socket.close();
		}  catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
}