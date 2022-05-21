package cn.giteasy.reflect;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * 已知一个类，定义如下：
 * 		class Rabbit {
 *			public void run() {
 *				System.out.println("run......");
 *			}
 * 		}
 * 1. 写一个Properties格式的配置文件，配置类的完整名称。
 * 2. 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法。
 */
public class Test03 {


	@Test
	public void test1() throws Exception {
		//创建输入流关联test1.properties
		BufferedReader br = new BufferedReader(new FileReader("test1.properties"));
		//读取配置文件中类名,获取字节码对象
		Class clazz = Class.forName(br.readLine());
		//通过字节码对象创建对象
		Rabbit rabbit = (Rabbit) clazz.newInstance();

		//输出：Rabbit are run......
		rabbit.run();
	}



}


class Rabbit {
	public void run() {
		System.out.println("Rabbit are run......");
	}
}