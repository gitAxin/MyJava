package cn.giteasy.reflect;

import cn.giteasy.common.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


/**
 * 通过反射获取成员变量并使用
 *
 */
public class Demo04Field {


	/**
	 * Class.getField(String)方法可以获取类中的指定字段(可见的),
	 * 通过set(obj, "李四")方法可以设置指定对象上该字段的值,
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		Class clazz = Class.forName("cn.giteasy.common.Person");
		Person p = (Person) clazz.newInstance();						//通过有参构造创建对象
		/**
		 *获取姓名字段,
		 * 如果属性是私有的，报java.lang.NoSuchFieldException，可使用getDeclaedField()方法
		 */
		Field field = clazz.getField("name"); //ava.lang.NoSuchFieldException
		field.set(p, "李四");						//修改姓名的值
		System.out.println(p);
	}


	/**
	 * 如果是私有的可以用getDeclaedField("name")方法获取
	 * 如果是私有的需要先调用setAccessible(true)设置访问权限,
	 *
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		Class clazz = Class.forName("cn.giteasy.common.Person");
		Person p = (Person) clazz.newInstance();						//通过有参构造创建对象
		Field f = clazz.getDeclaredField("name");				//暴力反射获取字段
		f.setAccessible(true);											//去除私有权限
		f.set(p, "李四");

		/**
		 * 输出结果：
		 *
		 * Person [name=李四, age=0]
		 */
		System.out.println(p);

		//用获取的指定的字段调用get(obj)可以获取指定对象中该字段的值
		Object fieldValue = f.get(p);
		/**
		 * 李四
		 */
		System.out.println(fieldValue);
	}


}
