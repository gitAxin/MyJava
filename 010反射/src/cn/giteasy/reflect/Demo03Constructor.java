package cn.giteasy.reflect;

import cn.giteasy.common.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 通过反射获取带参构造方法并使用
 */
public class Demo03Constructor {

	/**
	 *
	 * 通过无参构造创建对象
	 */
	@Test
	public void demo1() throws Exception {
		Class clazz = Class.forName("cn.giteasy.common.Person");
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
	}


	/**
	 *
	 *
	 * Class类的newInstance()方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数,
	 * 就不能这样创建了,可以调用Class类的getConstructor
	 * (String.class,int.class)方法获取一个指定的构造函数然后再调用Constructor类的newInstance
	 * ("zhangsan",18)方法创建对象
	 */
	@Test
	public void demo2() throws Exception {
		Class clazz = Class.forName("cn.giteasy.common.Person");
		Constructor c = clazz.getConstructor(String.class,int.class);	//获取有参构造。反射阶段，传入的参数也是字节码文件对象
		Person p = (Person) c.newInstance("zhangsan",18);	//通过有参构造创建对象
		System.out.println(p);

		/**
		 * 获取所有构造方法
		 */
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}

		/**
		 * 输出
		 * public cn.giteasy.common.Person(java.lang.String,int)
		 * public cn.giteasy.common.Person(int)
		 * public cn.giteasy.common.Person(java.lang.String)
		 * public cn.giteasy.common.Person()
		 */

	}


}
