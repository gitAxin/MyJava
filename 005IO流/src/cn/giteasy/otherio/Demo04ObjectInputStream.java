package cn.giteasy.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import cn.giteasy.common.Person;
import org.junit.Test;

public class Demo04ObjectInputStream {


	/**
	 * ObjectInputStream
	 * 反序列化：对象输入流
	 *
	 * EOF: end off file
	 */
	@Test
	public void demo1() throws IOException,ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("other\\person1.txt"));

		Person p1 = (Person) ois.readObject();
		Person p2 = (Person) ois.readObject();
		//Person p3 = (Person) ois.readObject();			//当文件读取到了末尾时出现EOFException    EOF: end off file

		System.out.println(p1);
		System.out.println(p2);

		ois.close();
	}



	/**
	 *
	 * ObjectInputStream
	 * 反序列化：对象输入流
	 *
	 * 将对象集合反序列化
	 *
	 */
	@Test
	public void demo2() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("other\\person_list.txt"));
		ArrayList<Person> list = (ArrayList<Person>) ois.readObject();		//将集合对象一次读取
		
		for (Person person : list) {
			System.out.println(person);
		}
		
		ois.close();
	}



}
