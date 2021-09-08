package cn.giteasy.generic;

import java.util.ArrayList;
import java.util.List;

import cn.giteasy.common.Person;
import cn.giteasy.common.Student;


public class Demo07Generic {

	/**
	 * * A:泛型通配符<?>
			* 任意类型，如果没有明确，那么就是Object以及任意的Java类了
		* B:? extends E
			* 向下限定，E及其子类
		* C:? super E
			* 向上限定，E及其父类
	 */
	public static void main(String[] args) {
		//List<?> list = new ArrayList<Integer>();			//当右边的泛型是不确定时,左边可以指定为?
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("person1", 23));
		list1.add(new Person("person2", 24));

		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("student1", 26));

		//可以将子类对象的集合 添加到 父类对象的集合中
		list1.addAll(list2);
		//[Person [name=person1, age=23], Person [name=person2, age=24], Person [name=student1, age=26]]
		System.out.println(list1);

		
	}

}
