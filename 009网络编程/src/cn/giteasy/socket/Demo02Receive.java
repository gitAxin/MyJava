package cn.giteasy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 可持续接收发送端的消息
 */
public class Demo02Receive {

	public static void main(String[] args) throws Exception {
			int port = 8888;
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
	}

}
