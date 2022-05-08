package cn.giteasy.thread2;

import org.junit.Test;

/**
 * 设计模式之单例模式
 * 	保证类在内存中只有一个对象。
 *
 * 	如何保证类在内存中只有一个对象呢？
 * 		(1)控制类的创建，不让其他类来创建本类的对象。private
 * 		(2)在本类中定义一个本类的对象。Singleton instance;
 * 		(3)提供公共的访问方式。  public static Singleton getInstance(){return s}
 *
 *
 * 	饿汉式和懒汉式的区别
 * 		1.饿汉式是空间换时间,懒汉式是时间换空间
 * 		2.在多线程访问时,饿汉式不会创建多个对象,而懒汉式有可能会创建多个对象
 */

public class Demo01Singleton {


	/**
	 * 单例模式-饿汉式
	 */
	@Test
	public void demo1(){
		SingletonHungry instance1 = SingletonHungry.getInstance();
		SingletonHungry instance2 = SingletonHungry.getInstance();
		System.out.println(instance1 == instance2);//true

		SingletonHungry2 i1 = SingletonHungry2.instance;
		SingletonHungry2 i2 = SingletonHungry2.instance;
		System.out.println(i1 == i2);//true

	}


	/**
	 * 单例模式-懒汉式
	 */
	@Test
	public void demo2(){
		SingletonLazy instance1 = SingletonLazy.getInstance();
		SingletonLazy instance2 = SingletonLazy.getInstance();
		System.out.println(instance1 == instance2);

	}


}

/**
 * 单例模式-饿汉式
 */
class SingletonHungry {
	/**
	 * 1.私有构造方法,其他类不能访问该构造方法了
	 */
	private SingletonHungry(){}

	/**
	 * 2.创建本类对象
	 * 私有的，以防外部赋为null:SingletonHungry.instance = null;
	 */
	private static SingletonHungry instance = new SingletonHungry();

	/**
	 * 对外提供公共的访问方法
	 * @return
	 */
	public static SingletonHungry getInstance() {				//获取实例
		return instance;
	}
}

/**
 * 单例模式-饿汉式 第2种写法
 */
class SingletonHungry2 {
	/**
	 * 1.私有构造方法,其他类不能访问该构造方法了
	 */
	private SingletonHungry2(){}

	/**
	 * 2.声明一个引用
	 * 声明为final，也可以防止外部赋值为null：SingletonHungry2.instance = null;
	 */
	public static final SingletonHungry2 instance = new SingletonHungry2();

}




/**
 * 单例模式-懒汉式:单例的延迟加载模式
 */
class SingletonLazy {
	/**
	 * 1,私有构造方法,其他类不能访问该构造方法了
	 */
	private SingletonLazy(){}
	/**
	 * 2.声明一个引用
	 */
	private static SingletonLazy instance;
	/**
	 * 3.对外提供公共的访问方法
	 */
	public static SingletonLazy getInstance() {				//获取实例
		if(instance == null) {
			//线程1等待,线程2等待
			instance = new SingletonLazy();
		}
		
		return instance;
	}
}


