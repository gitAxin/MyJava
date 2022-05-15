package cn.giteasy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 *	UDP传输之Receive（接收）
 * 		创建DatagramSocket, 指定端口号
 * 		创建DatagramPacket, 指定数组, 长度
 * 		使用DatagramSocket接收DatagramPacket
 * 		关闭DatagramSocket
 * 		从DatagramPacket中获取数据
 */
public class Demo01Receive {
	public static void main(String[] args) throws Exception {

		//当前接收端程序监听的端口
		int port = 8888;

		//创建Socket相当于创建码头,需指定端口号用于接收数据
		DatagramSocket socket = new DatagramSocket(port);
		//创建Packet，存放接收到的数据
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

		//阻塞:接收数据
		socket.receive(packet);

		//从Packet中获取数据
		byte[] arr = packet.getData();
		//获取有效的字节个数
		int len = packet.getLength();
		System.out.println(new String(arr,0,len));
		socket.close();
	}

}
