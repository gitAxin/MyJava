package cn.giteasy.set;

import java.util.HashSet;

import cn.giteasy.common.Person;

public class Demo01HashSet {

	/**
	 * @param args
	 * Set集合,无索引,不可以重复,无序(存取不一致)
	 */
	public static void main(String[] args) {
		//demo1();
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("张三", 23));
		hs.add(new Person("张三", 23));
		hs.add(new Person("李四", 24));
		hs.add(new Person("李四", 24));
		hs.add(new Person("李四", 24));
		hs.add(new Person("李四", 24));
		
		System.out.println(hs.size());
		System.out.println(hs);
	}

	public static void demo1() {
		HashSet<String> hs = new HashSet<>();					//创建HashSet对象
		boolean b1 = hs.add("a");
		boolean b2 = hs.add("a");  //当向set集合中存储重复元素的时候返回为false
		System.out.println(b1);//true
		System.out.println(b2);//false
		hs.add("b");
		hs.add("c");
		hs.add("d");
		System.out.println(hs);			//[a, b, c, d]	//HashSet的继承体系中有重写toString方法

		
		for (String string : hs) {								//只要能用迭代器迭代的,就可以使用增强for循环遍历
			System.out.println(string);
		}
		/*
		* 输出结果:
		* 	a
		*	b
		*	c
		*	d
		*
		*/
	}

}
