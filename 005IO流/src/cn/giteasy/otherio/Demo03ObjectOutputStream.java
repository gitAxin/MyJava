package cn.giteasy.otherio;

import cn.giteasy.common.Person;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Demo03ObjectOutputStream {


	/**
	 * 将对象写到文件中
	 * @throws IOException
	 */
	@Test
	public void demo1() throws IOException {
		Person p1 = new Person("张三", 23);
		Person p2 = new Person("李四", 24);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("other\\person1.txt"));
		oos.writeObject(p1);
		oos.writeObject(p2);

		oos.close();
	}


	/**
	 * 序列化:将对象集合写到文件中
	 * @throws IOException 
	 */
	@Test
	public void demo2() throws IOException {
		Person p1 = new Person("张三", 23);
		Person p2 = new Person("李四", 24);
		Person p3 = new Person("王五", 25);
		Person p4 = new Person("赵六", 26);
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("other\\person_list.txt"));
		oos.writeObject(list);								//把整个集合对象一次写出
		oos.close();
	}



}
