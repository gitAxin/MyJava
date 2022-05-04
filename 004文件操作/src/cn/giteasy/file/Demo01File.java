package cn.giteasy.file;

import org.junit.Test;

import java.io.File;


/**
 * File(String pathname)：根据一个路径得到File对象
 * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */

public class Demo01File {


	/**
	 * File(String pathname)：根据一个路径得到File对象
	 */
	@Test
	public void demo1() {
		//
		File file = new File("folder_a\\a.txt");
		System.out.println(file.exists());//true

		File file2 = new File("b.txt");
		System.out.println(file2.exists());//true

		File file3 = new File("c.txt");
		System.out.println(file3.exists());//false
	}

	/**
	 *  File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
	 */
	@Test
	public void demo2() {
		String parent = "folder_b\\sub_b";
		String child = "file.txt";
		File file = new File(parent,child);
		System.out.println(file.exists());//true

	}

	/**
	 * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
	 */
	@Test
	public void demo3() {
		File parent = new File("folder_b\\sub_b");
		String child = "file.txt";
		File file = new File(parent, child);
		System.out.println(file.exists());//true
		System.out.println(parent.exists());//true
	}



}
