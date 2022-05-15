package cn.giteasy.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端：
 * 接收文件
 * 客户端：cn/giteasy/test/Test02UploaderClient.java
 */
public class Test02UploadServer {

	public static void main(String[] args) throws IOException {
		//3.建立多线程的服务器
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动,绑定8888端口号...");
		
		//4.读取文件名
		while(true) {
			final Socket socket = server.accept();
			new Thread() {
				@Override
				public void run() {
					try {
						InputStream is = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						String fileName = br.readLine();
						
						//5.判断文件是否存在, 将结果发回客户端
						File dir = new File("upload");
						dir.mkdir();								//创建文件夹
						File file = new File(dir,fileName);			//封装成File对象
						
						if(file.exists()) {							//如果服务器已经存在这个文件
							ps.println("exists");						//将 exists(存在)写给客户端
							socket.close();
							return;
						}else {
							ps.println("accept");						//否则，写回accept，表示可以接收文件
						}
						
						//8.定义FileOutputStream, 从网络读取数据, 存储到本地
						FileOutputStream fos = new FileOutputStream(file);
						byte[] arr = new byte[8192];
						int len;
						
						while((len = is.read(arr)) != -1) {
							fos.write(arr, 0, len);
						}
						
						fos.close();
						socket.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}.start();
		}
		
		
		
	}
}
