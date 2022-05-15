package cn.giteasy.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  客户端
 *
 *  将字节流包装成了字符流
 *  每次可以读取一行数据，并且可以直接写出字符串
 *
 */
public class Demo02Client {


	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8888);
		//将字节流包装成了字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//PrintStream中有写出换行的方法
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		System.out.println(br.readLine());
		//写出时，println（）自带\r\n
		ps.println("青花瓷");
		System.out.println(br.readLine());
		ps.println("周杰伦");
		
		socket.close();
	}

}
