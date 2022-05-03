package cn.giteasy.test;

import java.io.File;
import java.util.Scanner;

/**
 * 把文件夹中的所有文件以及文件夹的名字按层级打印
 *
 * 需求:
 * 从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 *
 * 分析:
 * 1.获取所有文件和文件夹,返回的File数组
 * 2.遍历数组
 * 3.无论是文件还是文件夹,都需要直接打印
 * 4.如果是文件夹,递归调用
 * 	005IO流
 * 		other
 * 			access_file.txt
 * 			......
 * 		src
 * 			cn
 * 				giteasy
 * 						test
 * 							Test1.java
 * 							Test2.java
 * 							Test3.java
 * 							......
 * 		......
 * 		......
 *
 */
public class Test04 {


	public static void main(String[] args) {
		File dir = getDir();				//获取文件夹路径
		printLev(dir,0);
	}

	public static void printLev(File dir,int lev) {
		//1.把文件夹中的所有文件以及文件夹的名字按层级打印
		File[] subFiles = dir.listFiles();
		//2.遍历数组
		for (File subFile : subFiles) {
			for(int i = 0; i <= lev; i++) {
				System.out.print("\t");
			}
			//3.无论是文件还是文件夹,都需要直接打印
			//System.out.println(subFile);
			System.out.println(subFile.getName());
			//4.如果是文件夹,递归调用
			if(subFile.isDirectory()) {
				//printLev(subFile,lev + 1);
				printLev(subFile,++lev);
			}
		}
	}

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
