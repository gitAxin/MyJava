package cn.giteasy.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 每次可以读取一行
 * 每次可以直接写出字符串
 */
public class Demo02Server {


	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);

		//接受客户端的请求
		Socket socket = server.accept();

		//将字节流包装成了字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//PrintStream中有写出换行的方法
		PrintStream ps = new PrintStream(socket.getOutputStream());

		ps.println("你要听什么歌曲？");
		//readLine是以\r\n为结束标记，如果读不到\r\n会一直读，卡在这里
		System.out.println(br.readLine());
		ps.println("谁唱的？");
		System.out.println(br.readLine());
		socket.close();
	}
}
