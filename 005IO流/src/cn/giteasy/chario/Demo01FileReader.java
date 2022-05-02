package cn.giteasy.chario;

import org.junit.Test;


import java.io.FileReader;
import java.io.IOException;

public class Demo01FileReader {

	/**
	 * 读取1个字符
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		FileReader fr = new FileReader("chinese2.txt");
		int x = fr.read();
		System.out.println(x); //24202
		char c = (char)x;
		System.out.println(c); //床
		fr.close();
	}

	/**
	 * 读取文件中所有字符
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {

		FileReader fr = new FileReader("chinese2.txt");
		int c;
		
		while((c = fr.read()) != -1) {	//通过项目默认的码表一次读取一个字符
			System.out.print((char)c);
		}
		
		fr.close();
	}



}
