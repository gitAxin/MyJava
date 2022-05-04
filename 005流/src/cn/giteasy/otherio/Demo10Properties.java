package cn.giteasy.otherio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties的特殊功能
 * 	public Object setProperty(String key,String value)
 * 	public String getProperty(String key)
 *  public Enumeration<String> stringPropertyNames()
 */
public class Demo10Properties {


	@Test
	public void demo1() {
		Properties prop = new Properties();
		prop.put("password", 123456);
		System.out.println(prop);
		/**
		 * 输出结果
		 * {password=123456}
		 */
	}

	@Test
	public void demo2() {
		Properties prop = new Properties();
		prop.setProperty("username", "zhangsan");
		prop.setProperty("password", "123456");
		//System.out.println(prop);
		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();				//获取Properties中的每一个键
			String value = prop.getProperty(key);		//根据键获取值
			System.out.println(key + " = " + value);
		}

		/**
		 * 输出结果
		 * password = 123456
		 * username = zhangsan
		 */
	}

	/**
	 * Properties是Hashtable的子类
	 *
	 * Properties的load()和store()功能
	 */
	@Test
	public void demo3() throws  IOException {
		String path = "other\\application.properties";
		Properties prop = new Properties();
		prop.load(new FileInputStream(path));		//将文件上的键值对读取到集合中
		System.out.println(prop);

		prop.setProperty("phone", "18888888888");

		//第二个参数是对列表参数的描述,可以给值,也可以给null,它以注释的形式显示在properties文件的第一行。
		prop.store(new FileOutputStream(path), "application.properties");
		System.out.println(prop);
	}

}
