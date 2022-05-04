package cn.giteasy.otherio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 数据输入输出流/随机访问
 *
 * A:随机访问流概述
 *   RandomAccessFile概述
 *   RandomAccessFile类不属于流，是Object类的子类。但它融合了InputStream和OutputStream的功能。
 *   支持对随机访问文件的读取和写入。
 *
 * B:read(),write(),seek()
 */
public class Demo08RandomAccessFile {


	/**
	 * 应用场景之一：多线程下载
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		/**
		 * 原始文件内容
		 * abcdefg1234567890
		 */
		RandomAccessFile raf = new RandomAccessFile("other\\access_file.txt", "rw");
		raf.write(48);	//每读一次指针往后移一个字节
		int x = raf.read();//每读一次指针往后移一个字节
		System.out.println(x);//98
		raf.write(49);
		x = raf.read();
		System.out.println(x);//100
		/**
		 * 程序执行到此处：文件内容
		 * 0b1defg1234567890
		 */

		raf.seek(0);					//设置指针偏移量
		raf.write(98);
		raf.close();
		/**
		 * 程序执行到此处：文件内容
		 * bb1defg1234567890
		 */
	}

}
