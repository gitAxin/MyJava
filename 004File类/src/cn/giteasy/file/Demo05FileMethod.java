package cn.giteasy.file;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取功能
 *  public String getAbsolutePath()：获取绝对路径
 *  public String getPath():获取路径
 *  public String getName():获取名称
 *  public long length():获取长度。字节数
 *  public long lastModified():获取最后一次的修改时间，毫秒值
 *  public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 *  public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 */
public class Demo05FileMethod {



	@Test
	public void demo1() {
		File file1 = new File("b.txt");
		File file2 = new File("E:\\Workspace_IDEA\\MyJava\\004File类\\b.txt");
		////获取绝对路径
		System.out.println(file1.getAbsolutePath());	//E:\Workspace_IDEA\MyJava\004File类\b.txt
		System.out.println(file2.getAbsolutePath());	//E:\Workspace_IDEA\MyJava\004File类\b.txt

		//获取构造方法传入的路径
		System.out.println(file1.getPath());	//b.txt
		System.out.println(file2.getPath()); 	//E:\Workspace_IDEA\MyJava\004File类\b.txt

		//获取文件或目录的名字
		File file3 = new File("folder_b\\sub_b");
		System.out.println(file1.getName());//b.txt
		System.out.println(file2.getName());//b.txt
		System.out.println(file3.getName());///sub_b

		//获取文件长度（字节数）
		System.out.println(file1.length());

		//获取文件的最后修改时间
		long lastModified = file1.lastModified();
		System.out.println(lastModified);//1651376197127
		//格式化时间
		Date d = new Date(lastModified);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(d));//2022年05月01日 11:36:37
	}


	@Test
	public void demo2(){

		//获取当前文件夹下的所有文件的文件名
		File dir = new File(".\\");
		String[] arr = dir.list();						//仅为了获取文件名
		
		for (String string : arr) {
			System.out.println(string);
		}

		System.out.println("-------------------------------------------");
		//获聚餐当前文件夹下所有文件对象
		File[] subFiles = dir.listFiles();

		for (File file : subFiles) {					//获取文件对象
			if(file.isDirectory()){
				System.out.println("目录:" + file);
			}else{
				System.out.println("文件:" + file);
			}

		}
 	}


}
