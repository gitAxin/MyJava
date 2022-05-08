package cn.giteasy.factory;

/**
 *
 * 开始，在测试类中每个具体的内容自己创建对象，
 * 但是，创建对象的工作如果比较麻烦，就需要有人专门做这个事情，
 * 所以就知道了一个专门的类来创建对象。
 *
 */
public class AnimalFactory {
	public static Dog createDog() {
		return new Dog();
	}

	public static Cat createCat() {
		return new Cat();
	}

	/**
	 * 发现方法会定义很多,复用性太差
	 * 改进
	 * @param name
	 * @return Animal
	 */

	public static Animal createAnimal(String name) {
		if("dog".equals(name)) {
			return new Dog();
		}else if("cat".equals(name)) {
			return new Cat();
		}else {
			return null;
		}
	}
}
