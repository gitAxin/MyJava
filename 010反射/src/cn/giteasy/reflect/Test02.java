package cn.giteasy.reflect;

import java.lang.reflect.Field;

/**
 * 练习：
 * 通过反射写一个通用的设置，可设置某个对象的某个属性为指定的值
 * 	public void setProperty(Object obj, String propertyName, Object value){}，
 * 此方法可将obj对象中名为propertyName的属性的值设置为value。
 */
public class Test02 {


	public static void main(String[] args) throws Exception {
		Student s = new Student("zhangsan", 18);

		//Student [name=zhangsan, age=18]
		System.out.println(s);
		
		ReflectTool.setProperty(s, "name", "lisi");
		ReflectTool.setProperty(s, "age", 108);

		//Student [name=lisi, age=108]
		System.out.println(s);
	}

}



class ReflectTool {
	/**
	 * 此方法可将obj对象中名为propertyName的属性的值设置为value。
	 */
	public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
		//获取字节码对象
		Class clazz = obj.getClass();
		//获取字段，忽略修饰符权限
		Field field = clazz.getDeclaredField(propertyName);
		//设置权限为可访问的
		field.setAccessible(true);
		field.set(obj, value);
	}
}

class Student {
	private String name;
	private int age;
	public Student() {
		super();
		
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}