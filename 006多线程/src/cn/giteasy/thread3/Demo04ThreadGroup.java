package cn.giteasy.thread3;

import org.junit.Test;

/**
 *
 * 线程组的概述和使用
 *
 *
 * 线程组概述
 *  Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，Java允许程序直接对线程组进行控制。
 *
 *  默认情况下，所有的线程都属于主线程组。
 *   public final ThreadGroup getThreadGroup()//通过线程对象获取他所属于的组
 *   public final String getName()//通过线程组对象获取他组的名字
 *
 *  我们也可以给线程设置分组
 *  	1.ThreadGroup(String name) 创建线程组对象并给其赋值名字
 *  	2.创建线程对象
 *  	3.Thread(ThreadGroup?group, Runnable?target, String?name)
 *  	4.设置整组的优先级或者守护线程
 */
public class Demo04ThreadGroup {


	/**
	 * 默认是主线程组
	 */
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "张三");
		Thread t2 = new Thread(mr, "李四");
		//t1.start();
		//t2.start();
		ThreadGroup group1 = t1.getThreadGroup();
		ThreadGroup group2 = t2.getThreadGroup();

		//默认的是主线程
		System.out.println(group1.getName());//main
		System.out.println(group2.getName());//main
	}

	/**
	 * 自己设定线程组
	 */
	@Test
	public void demo2() {
		//创建新的线程组
		ThreadGroup tg = new ThreadGroup("我是一个新的线程组");
		MyRunnable mr = new MyRunnable();

		//将线程t1放在组中
		Thread t1 = new Thread(tg, mr, "张三");
		//将线程t2放在组中
		Thread t2 = new Thread(tg, mr, "李四");

		//获取组名
		System.out.println(t1.getThreadGroup().getName());	//我是一个新的线程组
		System.out.println(t2.getThreadGroup().getName());  //我是一个新的线程组

		//整组设置为守护线程
		tg.setDaemon(true);
	}



}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " => " + i);
		}
	}
	
}
