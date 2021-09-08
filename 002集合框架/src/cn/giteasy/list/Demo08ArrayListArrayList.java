package cn.giteasy.list;

import cn.giteasy.common.Person;

import java.util.ArrayList;


public class Demo08ArrayListArrayList {

	/**
	 * * A:案例演示
	 * 集合嵌套之ArrayList嵌套ArrayList
	 * 案例:
	 * 我们学科,学科又分为若个班级
	 * 整个学科一个大集合
	 * 若干个班级分为每一个小集合
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		
		ArrayList<Person> first = new ArrayList<>();				//创建第一个班级
		first.add(new Person("一班学生1", 30));
		first.add(new Person("一班学生2", 33));
		first.add(new Person("一班学生3", 20));
		
		ArrayList<Person> second = new ArrayList<>();
		second.add(new Person("二班学生A", 31));
		second.add(new Person("二班学生B", 33));
		second.add(new Person("二班学生C", 32));
		
		//将班级添加到学科集合中
		list.add(first);
		list.add(second);
		
		//嵌套循环 遍历学科集合
		for(ArrayList<Person> a : list) {
			for(Person p : a) {
				System.out.println(p);
			}
		}
	}

}
