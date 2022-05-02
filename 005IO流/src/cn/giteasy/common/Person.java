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
	private String a;
	public Person() {
		super();
		
	}

	public Person(String name) {
		super();
		this.name = name;

	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age == p.age;
	}


}
