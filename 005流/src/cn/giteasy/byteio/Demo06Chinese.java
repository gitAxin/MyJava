package cn.giteasy.byteio;

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
		//在此处一个中文是三个字节，所以定义3个字节的数组，具体是几个字节，要根据编码字会集而定
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
		fos.write("小河才露尖尖角，早有蜻蜓立上头。".getBytes());
		fos.write("\r\n".getBytes());
		fos.close();
	}


}
