package cn.giteasy.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo06Chinese {

	/**
	 * 字节流读取中文的问题
	 * 字节流在读中文的时候有可能会读到半个中文,造成乱码
	 *
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("chinese.txt");
		byte[] arr = new byte[3];
		int len;
		while((len = fis.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		fis.close();
	}




	/**
	 * 字节流写出中文的问题
	 * 	字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组
	 * 	写出回车换行 write("\r\n".getBytes());
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		FileOutputStream fos = new FileOutputStream("chinese_out.txt");
		fos.write("泉眼无声惜细流，树阴照水爱晴柔。".getBytes());
		fos.write("\r\n".getBytes());
		fos.close();
	}


}
