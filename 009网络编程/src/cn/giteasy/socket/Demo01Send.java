package cn.giteasy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * UDP传输之Send（发送）
 *
 * 创建DatagramSocket, 随机端口号
 * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
 * 使用DatagramSocket发送DatagramPacket
 * 关闭DatagramSocket
 */
public class Demo01Send {


	public static void main(String[] args) throws Exception {
		//要发送的数据
		String str = "how are you?";
		//接收消息的主机
		String host = "localhost";
		//接收数据的程序端口号
		int port = 8888;

		//创建Socket，使用随机端口，也可以构造方法中传入端口
		DatagramSocket socket = new DatagramSocket();
		//创建Packet,用于存放数据
		DatagramPacket packet =
				new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(host), port);
		//发送
		socket.send(packet);
		//关闭socket
		socket.close();
	}

}
