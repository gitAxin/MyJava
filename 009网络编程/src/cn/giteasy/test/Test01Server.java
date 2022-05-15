package cn.giteasy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * 客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,客户端再次读取到是反转后的字符串
 * 客户端：cn/giteasy/test/Test01Client.java
 */
public class Test01Server {


	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务端启动...");
		
		while(true) {
			//接受客户端的请求
			final Socket socket = server.accept();
			System.out.println("收到一个请求...");
			//开启一条线程
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());

						//将客户端写过来的数据读取出来
						String line = br.readLine();
						//链式编程反转这符串
						line = new StringBuilder(line).reverse().toString();
						//反转后写回去
						ps.println(line);
						
						socket.close();
					} catch (IOException e) {						
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

}
