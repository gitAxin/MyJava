package cn.giteasy.otherio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 *序列输入流
 *
 */
public class Demo01SequenceInputStream {


	/**
	 * 读取2个字节流，将内容输出到1个字节流中
	 * @throws IOException
	 */
	@Test
	public void demo1() throws  IOException {
		FileInputStream fis1 = new FileInputStream("other\\input1.txt");		//创建字节输入流关联a.txt
		FileOutputStream fos = new FileOutputStream("other\\output.txt");		//创建字节输出流关联c.txt

		int b1;
		while((b1 = fis1.read()) != -1) {							//不断的在a.txt上读取字节
			fos.write(b1);											//将读到的字节写到c.txt上
		}
		fis1.close();												//关闭字节输入流

		FileInputStream fis2 = new FileInputStream("other\\input2.txt");
		int b2;
		while((b2 = fis2.read()) != -1) {
			fos.write(b2);
		}

		fis2.close();
		fos.close();
	}


	/**
	 * 使用序列流SequenceInputStream，读取2个字节流，输出到1个字节流中
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		FileInputStream fis1 = new FileInputStream("other\\input1.txt");
		FileInputStream fis2 = new FileInputStream("other\\input2.txt");
		/**
		 * 整合两个输入流
		 * SequenceInputStream(InputStream s1, InputStream s2)
		 */
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		FileOutputStream fos = new FileOutputStream("other\\output2.txt");
		
		int b;
		while((b = sis.read()) != -1) {
			fos.write(b);
		}
		
		sis.close();					//sis在关闭的时候,会将构造方法中传入的流对象也都关闭
		fos.close();
	}


	/**
	 * 整合多个输入流
	 * SequenceInputStream(Enumeration<? extends InputStream> e)
	 */
	@Test
	public void demo3() throws IOException {

		FileInputStream fis1 = new FileInputStream("other\\input1.txt");
		FileInputStream fis2 = new FileInputStream("other\\input2.txt");
		FileInputStream fis3 = new FileInputStream("other\\input3.txt");

		Vector<FileInputStream> v = new Vector<>();					//创建集合对象
		v.add(fis1);												//将流对象存储进来
		v.add(fis2);
		v.add(fis3);

		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);		//将枚举中的输入流整合成一个
		FileOutputStream fos = new FileOutputStream("other\\output3.txt");

		int b;
		while((b = sis.read()) != -1) {
			fos.write(b);
		}

		sis.close();
		fos.close();
	}


}
