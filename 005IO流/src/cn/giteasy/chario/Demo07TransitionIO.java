package cn.giteasy.chario;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流的演示
 */
public class Demo07TransitionIO {

	/**
	 * 当前JDK8， 默认字符集是在 Java 虚拟机运行时才确定的，取决于不同的操作系统、区域设置等因素。
	 * 当前windows 10,虚拟机默认字符集是UTF-8。
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		//用默认编码表读写,出现乱码，默认以UTF-8读取
		FileReader fr = new FileReader("gbk.txt");//文件内容为gbk格式编码
		FileWriter fw = new FileWriter("utf-8.txt");//写入后乱码

		int c;
		while((c = fr.read()) != -1) {
			fw.write(c);
		}

		fr.close();
		fw.close();
	}


	/**
	 * InputStreamReader是从字节流到字符流的桥梁：它读取字节，并使用指定的charset将其解码为字符 。
	 * 它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。
	 * 每个调用InputStreamReader的read（）方法之一可能会导致从底层字节输入流读取一个或多个字节。
	 *
	 *  OutputStreamWriter是从字符流到字节流的桥梁：向其写入的字符编码使用指定的字节charset 。
	 *  它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。
	 *
	 *  --- 来自JDK1.8文档
	 *
	 *
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");	//指定码表读字符
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf-8.txt"), "utf-8");	//指定码表写字符

		int c;
		while((c = isr.read()) != -1) {
			osw.write(c);
		}

		isr.close();
		osw.close();
	}


	/**
	 * 更高效的写
	 * 为了最大的效率，可以考虑在BufferedReader中包装一个InputStreamReader。
	 * 或在BufferedWriter中包装一个OutputStreamWriter。
	 * @throws IOException
	 */
	@Test
	public void demo3() throws IOException {
		BufferedReader br = 								//更高效的读
				new BufferedReader(new InputStreamReader(new FileInputStream("gbk.txt"), "gbk"));
		BufferedWriter bw = 								//更高效的写
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("utf-8.txt"), "utf-8"));
		int c;
		while((c = br.read()) != -1) {
			bw.write(c);
		}
		
		br.close();
		bw.close();
	}






}
