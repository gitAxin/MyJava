package cn.giteasy.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *  多线程服务端
 */
public class Demo02ServerThread {


	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		
		while(true) {
			final Socket socket = server.accept();
			//可使用线程池
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());

						ps.println("你要听什么歌曲？");
						System.out.println(br.readLine());
						ps.println("谁唱的？");
						System.out.println(br.readLine());
						socket.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

}
