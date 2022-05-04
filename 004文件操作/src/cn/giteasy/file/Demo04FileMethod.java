package cn.giteasy.file;

import org.junit.Test;

import java.io.File;

/**
 *判断功能
 * 	public boolean isDirectory():判断是否是目录
 * 	public boolean isFile():判断是否是文件
 * 	public boolean exists():判断是否存在
 * 	public boolean canRead():判断是否可读
 * 	public boolean canWrite():判断是否可写
 * 	public boolean isHidden():判断是否隐藏
 */
public class Demo04FileMethod {



	@Test
	public void demo1() {

		File dir1 = new File("folder_a");
		//判断是否是目录
		System.out.println(dir1.isDirectory());//true
		//判断是否是文件
		System.out.println(dir1.isFile());//false

		File dir2 = new File("new2");
		//判断是否是目录
		System.out.println(dir2.isDirectory());//false
		//判断是否是文件
		System.out.println(dir2.isFile());//true



	}

	@Test
	public void demo2() {

		File file = new File("b.txt");
		file.setReadable(false);
		//windows系统认为所有的文件都是可读的,设置为false和true不起作用，在Linux系统下，设为不可读，就是不可读了
		System.out.println(file.canRead());//true
		file.setWritable(false);
		//windows系统可以设置为不可写
		System.out.println(file.canWrite());//false

		//判断是否是隐藏文件
		System.out.println(file.isHidden());//false

		//判断是否是隐藏文件
		File file2 = new File("c.txt");//手动设置文件属性为隐藏后
		System.out.println(file2.isHidden());//true

	}



}
