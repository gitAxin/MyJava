package cn.giteasy.file;

import org.junit.Test;

import java.io.File;

/**
 *	A:重命名和删除功能
 * 	 	public boolean renameTo(File dest):把文件重命名为指定的文件路径
 * 	 	public boolean delete():删除文件或者文件夹
 *	B:重命名注意事项
 * 	 	如果路径名相同，就是改名。
 * 	 	如果路径名不同，就是改名并移动。
 *	C:删除注意事项：
 * 		Java中的删除不走回收站。
 * 		要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 */
public class Demo03FileMethod {


	/**
	 * public boolean renameTo(File dest)
	 *
	 * 把文件重命名为指定的文件路径
	 */
	@Test
	public void demo1() {
		File file1 = new File("bbb2.txt");
		//File file2 = new File("bbb2.txt");
		File file2 = new File("temp\\bbb.txt");
		//如果路径相同，则重命名。如果路径不同则移动文件并重命名。
		System.out.println(file1.renameTo(file2));
	}

	@Test
	public void demo2() {

		//删除文件
		File file1 = new File("new.txt");
		System.out.println(file1.delete());
		//删除文件夹
		File file2 = new File("new_folder");
		System.out.println(file2.delete());

		File file3 = new File("new_folder2");	//如果删除一个文件夹,那么文件夹必须是空的
		System.out.println(file3.delete());
	}



}
