package cn.giteasy.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 需求
 * 客户端向服务器上传文件
 *
 * 分析
 * 1. 客户端：提示输入要上传的文件路径, 验证路径是否存在以及是否是文件夹
 * 2. 客户端：发送文件名到服务端
 * 3. 服务端：建立一个多线程的服务端
 * 4. 服务端：读取客户端发送的文件名
 * 5. 服务端：判断文件是否存在, 将结果发回客户端
 * 6. 客户端：接收结果, 如果存在给予提示, 程序直接退出
 * 7. 客户端：如果不存在, 定义FileInputStream读取文件, 写出到服务端
 * 8. 服务端：定义FileOutputStream, 从网络读取客户端发送的数据, 存储到本地
 *
 * 客户端：
 *  上传文件
 *  服务端：cn/giteasy/test/Test02UploaderServer.java
 */
public class Test02UploadClient {


	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1.提示输入要上传的文件路径, 验证路径是否存在以及是否是文件夹
		File file = getFile();
		// 2.发送文件名到服务端
		Socket socket = new Socket("localhost", 8888);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println(file.getName());
		// 6.接收结果, 如果存在给予提示, 程序直接退出
		String result = br.readLine();						//读取存在后不存在的结果
		if("exists".equals(result)) {							//和服务端约定好，exists：表示文件已存在
			System.out.println("您上传的文件已经存在,请不要重复上传");
			socket.close();
			return;
		}
		// 7.如果不存在, 定义FileInputStream读取文件, 写出到网络
		FileInputStream fis = new FileInputStream(file);
		byte[] arr = new byte[8192];
		int len;
		
		while((len = fis.read(arr)) != -1) {
			ps.write(arr, 0, len);
		}
		
		fis.close();
		socket.close();
	}

	private static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件路径:");
		
		while(true) {
			String line = sc.nextLine();
			File file = new File(line);
			
			if(!file.exists()) {
				System.out.println("您录入的文件路径不存在,请重新录入:");
			}else if(file.isDirectory()) {
				System.out.println("您录入的是文件夹路径,请输入一个文件路径:");
			}else {
				return file;
			}
		}
	}
}
