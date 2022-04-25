package cn.giteasy.map;

import java.util.Comparator;
import java.util.TreeMap;

import cn.giteasy.common.Student;
import org.junit.Test;

/**
 * A:案例演示
 * TreeMap集合键是Student值是String的案例
 */
public class Demo5TreeMap {

	@Test
	public void demo1() {
		TreeMap<Student, String> tm = new TreeMap<>();
		tm.put(new Student("张三", 23), "北京");
		tm.put(new Student("李四", 13), "上海");
		tm.put(new Student("王五", 33), "广州");
		tm.put(new Student("赵六", 43), "深圳");
		/**
		 * 如果Student未实现Comparable,将报如下错误:
		 *
		 * java.lang.ClassCastException: cn.giteasy.common.Student cannot be cast to java.lang.Comparable
		 * 异常:TreeMap的KEY对象需要实象java.lang.Comparable接口,如果不实现,不知道如何比较,如何报错
		 *
		 * 此处我们Student的父类Person类实现了Comparable接口,可以正常打印
		 *	打印结果:
		 * {Person [name=李四, age=13]=上海, Person [name=张三, age=23]=北京, Person [name=王五, age=33]=广州, Person [name=赵六, age=43]=深圳}
		 */

		System.out.println(tm);
	}

	/**
	 *创建TreeMap的时候,传入一个比较器
	 */
	@Test
	public void demo2(){
		TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int num = s1.getName().compareTo(s2.getName());		//按照姓名比较
				return num == 0 ? s1.getAge() - s2.getAge() : num;
			}
		});
		tm.put(new Student("张三", 23), "北京");
		tm.put(new Student("李四", 13), "上海");
		tm.put(new Student("赵六", 43), "深圳");
		tm.put(new Student("王五", 33), "广州");

		System.out.println(tm);
	}



}
