package cn.giteasy.otherio;

import cn.giteasy.common.Person;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * PrintStream和PrintWriter分别是打印的字节流和字符流
 * 只操作数据目的，不操作数据源
 */

public class Demo05PrintStream {


	/**
	 * 打印字节流
	 * PrintStream
	 */
	@Test
	public void demo1() {

		System.out.println("hello world！");

		//获取标准输出流
		PrintStream ps = System.out;
		//底层通过Integer.toString()将97转换成字符串并打印
		ps.println(97);//97
		//查找码表,找到对应的a并打印
		ps.write(97);//a

		ps.println("");
		Person p1 = new Person("张三", 23);
		//默认调用p1的toString方法
		ps.println(p1);//Person [name=张三, age=23]

		//打印引用数据类型,如果是null,就打印null,如果不是null就打印对象的toString方法
		Person p2 = null;
		ps.println(p2);//null
		ps.close();
	}


	/**
	 * 打印字符流
	 * PrintWriter
	 */
	@Test
	public void demo2() throws IOException {
		//打印到控制台
		//PrintWriter pw1 = new PrintWriter(System.out);
		//修改打印目标：打印到文件中
		PrintWriter pw1 = new PrintWriter("other\\print.txt");
		pw1.print(97);
		pw1.println(97);
		pw1.close();

		/**
		 * autoFlash：true
		 * 自动刷出，不关闭流也可以写出
		 */
		PrintWriter pw = new PrintWriter(new FileOutputStream("other\\print2.txt"));
		//true:自动刷出功能只针对的是println方法
		//PrintWriter pw = new PrintWriter(new FileOutputStream("other\\print2.txt"),true);
		pw.println(97);
		pw.write(97);
		pw.close();

	}



}
