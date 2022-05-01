package cn.giteasy.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类成员方法：创建功能
 * 	public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 * 	public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
 * 	public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
 * 	注意事项：
 * 		如果创建文件或者文件夹时忘了写盘符路径，那么，默认在项目路径下。
 */
public class Demo02FileMethod {


	/**
	 * public boolean createNewFile()
	 * 创建文件，创建成功返回true,
	 * 如果存在，就不创建了, 返回false
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		File file = new File("new.txt");
		System.out.println(file.createNewFile());			//如果没有就创建,返回true,如果存在，则返回false
		
		File file2 = new File("new2");
		System.out.println(file2.createNewFile());
	}

	/**
	 * public boolean mkdir()
	 *
	 * 创建文件夹,创建成功，返回true
	 * 如果存在，就不创建了,返回false
	 * @throws IOException
	 */
	@Test
	public void demo2() throws IOException {

		File dir1 = new File("new_folder");
		System.out.println(dir1.mkdir());

		File dir2 = new File("suffix.txt");				//这样写是可以的,文件夹也是可以有后缀的
		System.out.println(dir2.mkdir());

	}


	/**
	 * public boolean mkdirs():
	 * 创建多层目录，如果父目录不存在，会自动创建
	 *
	 * 创建成功，返回true
	 * 如果存在，就不创建了,返回false
	 * @throws IOException
	 */
	@Test
	public void demo3() throws IOException {

		File dir3 = new File("new_folder2\\new_sub_folder");
		System.out.println(dir3.mkdirs()); 				//创建多级目录
	}

}
