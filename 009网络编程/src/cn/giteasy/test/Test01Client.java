package cn.giteasy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端：
 *
 *
 * 客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写回,客户端再次读取到是反转后的字符串
 *
 * 服务端：cn/giteasy/test/Test02Server.java
 */
public class Test01Client {


	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		//创建客户端,指定ip地址和端口号
		Socket socket = new Socket("localhost", 8888);

		//获取输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//获取输入流
		//获取输出流
		PrintStream ps = new PrintStream(socket.getOutputStream());

		System.out.println("请录入一个字符串：");
		//将字符串写到服务器去
		ps.println(sc.nextLine());
		//将反转后的结果读出来
		System.out.println(br.readLine());
		
		socket.close();
	}

}
