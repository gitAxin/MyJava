package cn.giteasy.reflect;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 分别获取狗、猫、猴子对象
 */
public class Demo02Reflect {

	@Test
	public void demo1(){
		Factory factory = new DogFactory();	//创建榨汁机
		Animal animal = factory.createAnimal();
		animal.eat();//狗吃肉

		factory = new CatFactory();//创建榨汁机
		animal = factory.createAnimal();
		animal.eat();//猫吃鱼
	}


	/**
	 * 通过Class.forName API 创建实例
	 */
	@Test
	public void demo2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("cn.giteasy.reflect.DogFactory");
		Factory factory = (Factory) clazz.newInstance();
		Animal animal = factory.createAnimal();
		animal.eat();

	}

	/**
	 *读取配置文件创建类的实例
	 */
	@Test
	public void demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		//需要修改要创建的类时，只需要修改配置文件即可
		BufferedReader br = new BufferedReader(new FileReader("config.properties"));
		Class clazz;
		Factory factory;
		List<String> list = br.lines().collect(Collectors.toList());
		for (String line : list) {
			clazz = Class.forName(line); //获取该类的字节码文件
			factory = (Factory) clazz.newInstance();//创建实例对象
			Animal animal = factory.createAnimal();
			animal.eat();
		}

		/**
		 * 输出结果：
		 *
		 * 猴子吃香蕉
		 * 猫吃鱼
		 * 狗吃肉
		 */
	}
}

//动物
interface Animal {
	public void eat();
}

class Cat implements Animal {

	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}

}

class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("狗吃肉");
	}

}

class Monkey implements Animal {

	@Override
	public void eat() {
		System.out.println("猴子吃香蕉");
	}

}

/**
 * 工厂接口
 */
interface Factory {
	public Animal createAnimal();
}

class CatFactory  implements Factory{


	@Override
	public Animal createAnimal() {
		return new Cat();
	}
}

class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}

class MonkeyFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Monkey();
	}

}



