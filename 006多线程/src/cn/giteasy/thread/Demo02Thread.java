package cn.giteasy.thread;

/**
 * 方式一：继承Thread
 *
 * 	1.定义类继承Thread
 * 	2.重写run方法
 * 	3.把新线程要做的事写在run方法中
 * 	4.创建线程对象
 * 	5.开启新线程, 内部会自动执行run方法
 */
public class Demo02Thread {

	public static void main(String[] args) {
		MyThread mt = new MyThread();		//4.创建Thread类的子类对象
		mt.start();							//5.开启线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("main 主线程");
		}
	}

	/**
	 * ......
	 * main 主线程
	 * main 主线程
	 * Thread-0 @ 5
	 * Thread-0 @ 6
	 * Thread-0 @ 7
	 * Thread-0 @ 8
	 * Thread-0 @ 9
	 * Thread-0 @ 10
	 * Thread-0 @ 11
	 * Thread-0 @ 12
	 * Thread-0 @ 13
	 * main 主线程
	 * main 主线程
	 * ......
	 */

}

class MyThread extends Thread {				//1.继承Thread

	@Override
	public void run() {						//2.重写run方法
		for(int i = 0; i < 100; i++) {		//3.将要执行的代码写在run方法中
			System.out.println(this.getName() + " @ "+ i);
		}
	}
}