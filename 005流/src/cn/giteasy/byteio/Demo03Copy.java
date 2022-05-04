package cn.giteasy.byteio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03Copy {


	/**
	 * 将test.jpg 复制为 test_copy.jpg
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {
		//创建输入流对象,关联test.jpg
		FileInputStream fis = new FileInputStream("test.jpg");
		//创建输出流对象,关联test_copy.jpg
		FileOutputStream fos = new FileOutputStream("test_copy.jpg");

		//不断的读取一个字节,再写入到输出流
		int b;
		while((b = fis.read()) != -1) {
			fos.write(b);
		}

		//释放资源
		fis.close();
		fos.close();
	}


	@Test
	public void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("孤勇者.mp3");
		FileOutputStream fos = new FileOutputStream("孤勇者copy.mp3");

		long start = System.currentTimeMillis();
		int b;
		while((b = fis.read()) != -1) {
			fos.write(b);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start));//耗时:13036
		
		fis.close();
		fos.close();
	}

	/**
	 * 不推荐使用,因为有可能会导致内存溢出
	 * 假如copy一个非常大的文件，比如10g大小的高清电影，很可能会内存溢出
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void demo3() throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream("孤勇者.mp3");
		FileOutputStream fos = new FileOutputStream("孤勇者copy2.mp3");
		//int len = fis.available();
		//System.out.println(len);

		long start = System.currentTimeMillis();
		//创建与文件一样大小的字节数组
		byte[] arr = new byte[fis.available()];
		//将文件上的字节读取到内存中
		fis.read(arr);
		//将字节数组中的字节数据写到文件上
		fos.write(arr);
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start));//耗时:323

		fis.close();
		fos.close();
	}


}
