package cn.giteasy.chario;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *
 * BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
 * BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
 *
 *
 *
 * 带缓冲区的流中的特殊方法
 * readLine()
 */
public class Demo04Buffered {

	/**
	 * 一行一行读取
	 *
	 * 	readLine()
	 * 	newLine()
	 */
	@Test
	public void demo1() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("最美的遇见.txt"));
		String line;

		while((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
	}


	/**
	 *一行一行copy
	 * newLine()方法演示
	 *
	 * newLine()与\r\n的区别?
	 * 		newLine()是跨平台的方法
	 * 		\r\n只支持的是windows系统
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("最美的遇见.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("最美的遇见_copy.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();							//写出回车换行符
			//bw.write("\r\n");
		}
		
		br.close();
		bw.close();
	}



}
