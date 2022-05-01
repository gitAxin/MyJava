package cn.giteasy.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02FileOutputStream {


	/**
	 * 字节输出流追加
	 * 如果想追加数据，可传入第二个参数：true
	 */
	@Test
	public void demo2() throws IOException {

		FileOutputStream fos = new FileOutputStream("output.txt",true);	//如果想续写就在第二个参数传true
		fos.write(97);
		fos.write(98);
		
		fos.close();
	}

	/**
	 * FileOutputStream在创建对象的时候，如果没有这个文件会自动创建
	 * 如果有，则先将文件清空，再写入。而不是将文件删除，再创建，再写入，这是两个不同的概念。
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {
		//创建字节输出流对象,如果没有就自动创建一个
		FileOutputStream fos = new FileOutputStream("output.txt");
		//虽然写出的是一个int数,但是写到文件上的是一个字节,会自动去除前三个8位
		fos.write(97);
		fos.write(98);
		fos.write(99);
		fos.write(100);
		fos.close();
	}

}
