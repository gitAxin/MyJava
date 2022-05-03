package cn.giteasy.otherio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 标准 输入\输出 流
 */
public class Demo06SystemInOut {


	/**
	 * 演示标准输入流
	 */
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		System.out.println("请输入：");
		int x = is.read();
		System.out.println(x);

		//标准输入流一个程序中只有一个（在System类中是一个静态成员变量）,关闭后，后面就不能再使用了。
		//is.close();

		InputStream is2 = System.in;
		//System.out.println("请输入：");
		int y = is2.read();
		System.out.println(y);
	}

	/**
	 * 更改标准输入\输出流默认指向
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {
		System.setIn(new FileInputStream("other\\system.in.txt"));			//改变标准输入流
		System.setOut(new PrintStream("other\\system.out.txt"));			//改变标注输出流
		
		InputStream is = System.in;							//获取标准的键盘输入流,默认指向键盘,改变后指向文件
		PrintStream ps = System.out;						//获取标准输出流,默认指向的是控制台,改变后就指向文件
		
		int b;
		while((b = is.read()) != -1) {
			ps.write(b);
		}
		//System.out.println();								//也是一个输出流,不用关,因为没有和硬盘上的文件产生关联的管道
		is.close();
		ps.close();
		
	}


}
