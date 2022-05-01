package cn.giteasy.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04ArrayCopy {


	@Test
	public void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("input2.txt");
		byte[] arr = new byte[2];
		int a = fis.read(arr);						//将文件上的字节读取到字节数组中
		System.out.println(a);						//读到的有效字节个数

		for (byte b : arr) {						//第一次获取到文件上的a和b
			System.out.println(b);
		}
		System.out.println("-----------------------");
		int c = fis.read(arr);
		System.out.println(c);
		for (byte b : arr) {
			System.out.println(b);
		}
		fis.close();
	}

	@Test
	public void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("input2.txt");
		FileOutputStream fos = new FileOutputStream("output2.txt");
		
		byte[] arr = new byte[2];
		int len;
		while((len = fis.read(arr)) != -1) {
			fos.write(arr,0,len);
		}

		
		fis.close();
		fos.close();
	}



	/**
	 * 自定义COPY大小
	 * @throws IOException
	 */
	@Test
	public void demo3() throws IOException {

		FileInputStream fis = new FileInputStream("孤勇者.mp3");
		FileOutputStream fos = new FileOutputStream("孤勇者copy3.mp3");

		byte[] arr = new byte[1024 * 8];
		int len;
		while((len = fis.read(arr)) != -1) {				//如果忘记加arr,返回的就不是读取的字节个数,而是每一次读取的字节数据
			fos.write(arr,0,len);
		}

		fis.close();
		fos.close();
	}

}
