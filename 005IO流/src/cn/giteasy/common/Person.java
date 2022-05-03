package cn.giteasy.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Axin
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	//新增加属性
	private String gender;

	public Person() {
		super();
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}
}
