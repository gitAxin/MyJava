package cn.giteasy.byteio;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo05BufferCopy {



	@Test
	public void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("孤勇者.mp3");				//创建输入流对象,关联致青春.mp3
		FileOutputStream fos = new FileOutputStream("孤勇者copy4.mp3");			//创建输出流对象,关联copy.mp3
		BufferedInputStream bis = new BufferedInputStream(fis);				//创建缓冲区对象,对输入流进行包装让其变得更加强大
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		/**
		 * 程序解释：
		 * 当循环第一次时，发现缓冲区是空的，会一次从文件中读取8192个字节（查看源码可知，默认），并且返回第一个字节数据，我们手动将其写入到缓冲输出流
		 * 当循环第二次时，发现缓冲区还存在未使用的字节，就把缓冲区的第2个字节，直接返回，我们再手动写入缓冲输出流中。
		 * 依此类推
		 * 当缓冲区所有字节都被返回后，它会再从文件中获取第二批数据(8192个字节)，循环往复，直到读取完所有输入流中的数据，返回-1时，结束。
		 *
		 * 缓冲输出流内部缓冲区8192个字节（查看源码可知，默认）被写满时，会将这一批一次性写入输出流中（文件）
		 *
		 * 虽然每次循环返回1个字节，再写入1个字节，但这都是在内存中完成的，效率还是非常快的。
		 * 而从硬盘读取数据和写入数据到硬盘的环节，相比非缓冲输入流和非缓冲输出流已经减少了读写次数。
		 */
		int b;
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		
		bis.close();
		bos.close();
	}


	/**
	 *
	 * close方法
	 * 具备刷新的功能,在关闭流之前,就会先刷新一次缓冲区,将缓冲区的字节全都刷新到文件上,再关闭,close方法刷完之后就不能再写出了
	 * flush方法?
	 * 具备刷新的功能,刷完之后还可以继续写
	 */
	@Test
	public void demo2() throws IOException {
		//flush和close方法的区别
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("孤勇者.mp3"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("孤勇者copy5.mp3"));

		int b;
		while((b = bis.read()) != -1) {
			bos.write(b);
			//bos.close();
			//bos.flush();
		}
		//bos.flush();
		bis.close();
		bos.close();

	}


	/**
	 *
	 * 小数组的读写和带Buffered的读取哪个更快?
	 *
	 * 定义小数组如果是8192个字节大小和Buffered比较的话，定义小数组会略胜一筹,因为读和写操作的是同一个数组，而Buffered操作的是两个数组
	 *
	 *
	 */

}
