package cn.giteasy.common;

import java.util.Objects;

public class Person{
	private String name;
	private int age;
	public Person() {
		super();

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
	public void setAge(int age) throws Exception,RuntimeException{
		if(age < 0 || age >= 150){
			throw new Exception("年龄非法！");
		}
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



}