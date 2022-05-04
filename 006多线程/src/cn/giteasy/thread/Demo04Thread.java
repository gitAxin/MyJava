package cn.giteasy.thread;

import org.junit.Test;

/**
 * 匿名内部类实现线程的两种方式
 */
public class Demo04Thread {

	@Test
	public void demo1() {
		new Thread() {										//1.继承Thread类
			@Override
			public void run() {								//2.重写run方法
				for(int i = 0; i < 100; i++) {				//3.将要执行的代码写在run方法中
					System.out.println("new Thread() 内部类");
				}
			}
		}.start();											//4.开启线程



		new Thread(new Runnable() {							//1.将Runnable的子类对象传递给Thread的构造方法
			@Override
			public void run() {								//2.重写run方法
				for(int i = 0; i < 100; i++) {				//3.将要执行的代码写在run方法中
					System.out.println("new Runnable() 内部类");
				}
			}
		}).start();											//4.开启线程
	}




}
