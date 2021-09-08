package cn.giteasy.generic;

import cn.giteasy.common.Person;

import java.util.ArrayList;
import java.util.Iterator;


public class Demo02Generic {

	/**
	 * 案例演示
	 * ArrayList存储字符串并遍历泛型版
	 */
	public static void main(String[] args) {
		//demo1();
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("david", 23));
		list.add(new Person("sally", 24));
		list.add(new Person("smith", 25));
		list.add(new Person("xm", 26));

		Iterator<Person> it = list.iterator();
		while(it.hasNext()) {
			Person p = it.next();							//将集合中的每一个元素用Person记录
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

	public static void demo1() {
		ArrayList<String> list = new ArrayList<>();			//创建集合对象
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		/*
		* 输出结果:
		* 	a
			b
			c
			d
		*
		* */

	}

}
