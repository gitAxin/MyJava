package cn.giteasy.file;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 *需求：
 * 判断指定目录下是否有后缀名为.zip的文件，如果有，就输出该文件名称
 */
public class Test01 {


		/**
		 * 方式一：
		 * list()方法
		 */

		@Test
		public void test1() {
			/**
			 * .\\ 表示当前目录
			 */
			File dir = new File(".\\");

			String[] arr = dir.list();					//获取e盘下所有的文件或文件夹
			for (String string : arr) {
				if(string.endsWith(".zip")) {
					System.out.println(string);
				}
		}

		/**
		 * 输出结果：
		 * c.zip
		 * new_folder2.zip
		 */

	}

	/**
	 * 方式二：
	 * listFiles()方法
	 */
	@Test
	public void test2() {
		File dir = new File(".\\");

		File[] subFiles = dir.listFiles();

		for (File subFile : subFiles) {
			if(subFile.isFile() && subFile.getName().endsWith(".zip")) {
				System.out.println(subFile.getName());
			}
		}

		/**
		 * 输出结果：
		 * c.zip
		 * new_folder2.zip
		 */

	}

	/**
	 * 方式三：
	 * 使用文件名过滤器FilenameFilter
	 */
	@Test
	public void test3() {
		File dir = new File(".\\");


		String[] arr = dir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir, name);
				return file.isFile() && file.getName().endsWith(".zip");
			}
		});

		for (String string : arr) {
			System.out.println(string);
		}

		/**
		 * 输出结果：
		 * c.zip
		 * new_folder2.zip
		 */
	}


}
