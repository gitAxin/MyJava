package cn.giteasy.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 使用标准 输入/输出 流拷贝文件
 * 了解，开发中不用
 * 若要COPY请使用BufferedInputStream/BufferedOutputStream  或 FileInputStream/FileOutputStream
 */
public class Test02SystemInOutForCopy {


	public static void main(String[] args) throws IOException {
		//改变标准输入流
		System.setIn(new FileInputStream(".\\005IO流\\test.jpg"));
		//改变标准输出流
		System.setOut(new PrintStream(".\\005IO流\\test_system.jpg"));
		
		InputStream is = System.in;
		PrintStream ps = System.out;
		
		byte[] arr = new byte[1024];
		int len;
		
		while((len = is.read(arr)) != -1) {
			ps.write(arr, 0, len);
		}
		
		is.close();
		ps.close();
	}

}
