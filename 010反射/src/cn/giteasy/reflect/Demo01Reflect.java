package cn.giteasy.reflect;


import cn.giteasy.common.Person;

/**
 * 获取class字节码文件对象的三种方式
 */
public class Demo01Reflect {


	public static void main(String[] args) throws ClassNotFoundException {
		//方式一
		Class clazz1 = Class.forName("cn.giteasy.common.Person");

		//方式二
		Class clazz2 = Person.class;

		//方式三
		Person p = new Person();
		Class clazz3 = p.getClass();
		
		System.out.println(clazz1 == clazz2);//true
		System.out.println(clazz2 == clazz3);//true
	}

}
