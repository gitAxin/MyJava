package cn.giteasy.otherio;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 内存输出流
 * ByteArrayOutputStream
 */
public class Demo02ByteArrayOutputStream {

	@Test
	public void demo1() throws  IOException {
		FileInputStream fis = new FileInputStream("other\\chinese_input.txt");
		byte[] arr = new byte[4];
		int len;
		while((len = fis.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		
		fis.close();
	}

	/**
	 * FileInputStream读取中文的时候出现了乱码
	 *
	 * 解决方案
	 * 1.字符流读取
	 * 2.ByteArrayOutputStream
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		FileInputStream fis = new FileInputStream("other\\chinese_input.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();			//在内存中创建了可以增长的内存数组

		int b;
		while((b = fis.read()) != -1) {
			baos.write(b);													//将读取到的数据逐个写到内存中
		}

		byte[] arr = baos.toByteArray();									//将缓冲区的数据全部获取出来,并赋值给arr数组
		System.out.println(new String(arr));								//与toString()方法的区别是，他可以使用指定字符集将字节转换为字符串
		System.out.println("==========================");

		System.out.println(baos.toString());								//将缓冲区的内容转换为了字符串,在输出语句中可以省略调用toString方法
		fis.close();

		/**
		 * ByteArrayOutputStream无需关闭流，
		 * 因为它并没有对接硬盘上的文件，而是在内存中开辟了一块区域，
		 * 就像使用集合一样，不使用了，它会被JVM垃圾回收释放。
		 */
	}


}
