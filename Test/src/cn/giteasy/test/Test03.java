package cn.giteasy.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * 把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
 *
 * 需求:
 * 从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
 *
 *
 * 分析:
 * 1.在目标文件夹中创建原文件夹
 * 2.获取原文件夹中所有的文件和文件夹,存储在File数组中
 * 3.遍历数组
 * 4.如果是文件就用io流读写
 * 5.如果是文件夹就递归调用
 */
public class Test03 {


	public static void main(String[] args) throws IOException {
		File src = getDir("请输入源文件夹路径:");
		File dest = getDir("请输入目标文件夹路径:");
		if(src.equals(dest)) {
			System.out.println("目标文件夹是源文件夹的子文件夹");
		}else {
			copy(src,dest);
		}
	}
	/**
	 * 把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
	 * 1.返回值类型void
	 * 2.参数列表File src,File dest
	 */
	public static void copy(File src, File dest) throws IOException {
		//1,在目标文件夹中创建原文件夹
		File newDir = new File(dest, src.getName());
		newDir.mkdir();
		//2,获取原文件夹中所有的文件和文件夹,存储在File数组中
		File[] subFiles = src.listFiles();
		//3,遍历数组
		for (File subFile : subFiles) {
			//4,如果是文件就用io流读写
			if(subFile.isFile()) {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
				BufferedOutputStream bos = 
						new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));
				
				int b;
				while((b = bis.read()) != -1) {
					bos.write(b);
				}
				
				bis.close();
				bos.close();
			//5,如果是文件夹就递归调用
			}else {
				copy(subFile,newDir);
			}
		}
	}

	/**
	 * 从键盘接收一个文件夹路径
	 * 1.返回值类型File
	 * 2.参数列表无
	 */
	public static File getDir(String comments) {
		//1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println(comments);
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
