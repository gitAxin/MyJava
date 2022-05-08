package cn.giteasy.factoryMethod;

/**
 * 狗工厂
 *
 * 开始，在测试类中每个具体的内容自己创建对象，
 * 但是，创建对象的工作如果比较麻烦，就需要有人专门做这个事情，
 * 所以就知道了一个专门的类来创建对象。
 *
 * 发现每次修改代码太麻烦，用工厂方法改进，针对每一个具体的实现提供一个具体工厂。
 */
public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
