package cn.giteasy.byteio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo07TryFinally {


	/**
	 * try finally嵌套
	 */

	@Test
	public void demo1() throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("input.txt");
			fos = new FileOutputStream("output.txt");
			
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
		}finally {
			try{
				if(fis != null){
					fis.close();
				}

			}finally {					//try fianlly的嵌套目的是能关一个尽量关一个
				if(fos != null){
					fos.close();
				}

			}
		}
	}


	/**
	 * JDK1.7 新特性，自动关闭流
	 * 开发中一般不用
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {

		//在try()中书写的对象，都需要实现AutoCloseable接口
		try(
				FileInputStream fis = new FileInputStream("input.txt");
				FileOutputStream fos = new FileOutputStream("output.txt");
				MyClose mc = new MyClose();
		){
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
		}
	}


}

class MyClose implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("我关了");
	}
}
