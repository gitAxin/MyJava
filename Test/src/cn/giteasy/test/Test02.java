package cn.giteasy.test;

import java.io.File;
import java.util.Scanner;

/**
 * 删除该文件夹
 *
 * 需求:
 * 从键盘接收一个文件夹路径,删除该文件夹
 *
 *
 * 分析:
 * 1.获取该文件夹下的所有的文件和文件夹
 * 2.遍历数组
 * 3.判断是文件直接删除
 * 4.如果是文件夹,递归调用
 * 5.循环结束后,把空文件夹删掉
 */
public class Test02 {


	public static void main(String[] args) {
		/**
		 * 谨慎操作，不经过回收站
		 */
		File dir = getDir();					//获取文件夹路径
		deleteFile(dir);
	}

	/**
	 * 删除该文件夹
	 * 1.返回值类型 void
	 * 2.参数列表File dir
	 */
	public static void deleteFile(File dir) {	
		//1.获取该文件夹下的所有的文件和文件夹
		File[] subFiles = dir.listFiles();		
		//2.遍历数组
		for (File subFile : subFiles) {
			//3.判断是文件直接删除
			if(subFile.isFile()) {
				subFile.delete();
			//4.如果是文件夹,递归调用
			}else {
				deleteFile(subFile);			
			}
		}
		//5,循环结束后,把空文件夹删掉
		dir.delete();
	}
	/**
	 * 从键盘接收一个文件夹路径
	 * 1.返回值类型File
	 * 2.参数列表无
	 */
	public static File getDir() {
		//1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径:");
		//2.定义一个无限循环
		while(true) {
			//3.将键盘录入的结果存储并封装成File对象
			String line = sc.nextLine();
			File dir = new File(line);
			//4.对File对象判断
			if(!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在,请输入一个文件夹路径:");
			}else if(dir.isFile()) {
				System.out.println("您录入的是文件路径,请输入一个文件夹路径:");
			}else {
				//5.将文件夹路径对象返回
				return dir;
			}
		}

	}

}
