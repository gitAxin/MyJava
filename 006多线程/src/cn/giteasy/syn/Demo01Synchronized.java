package cn.giteasy.syn;

/**
 * 同步代码块
 *
 *  1.什么情况下需要同步
 *   当多线程并发, 有多段代码同时执行时, 我们希望某一段代码执行的过程中CPU不要切换到其他线程工作. 这时就需要同步.
 *   如果两段代码是同步的, 那么同一时间只能执行一段, 在一段代码没执行结束之前, 不会执行另外一段代码.
 *  2.同步代码块
 *    使用synchronized关键字加上一个锁对象来定义一段代码, 这就叫同步代码块
 *    多个同步代码块如果使用相同的锁对象, 那么他们就是同步的
 *
 *
 */
public class Demo01Synchronized {

	/**
	 * 同步代码块演示
	 */
	public static void main(String[] args) {
		final Printer p = new Printer();
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						//为了看到效果，添加sleep
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					p.print1();
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					p.print2();
				}
			}
		}.start();


		/**
		 * 未加锁前：
		 * 你好, h世e界ll！o,
		 * world!
		 * 你好, 世界！
		 * hello, world!
		 * 你好hello, world!
		 * , 世界！
		 * 你好, 世界！
		 * hello, world!
		 * hello, world!
		 * 你好, 世界！
		 * he你好, 世界！
		 * ......
		 * ......
		 *
		 * 加锁后：
		 *	hello, world!
		 * 你好, 世界！
		 * 你好, 世界！
		 * hello, world!
		 * 你好, 世界！
		 * hello, world!
		 * 你好, 世界！
		 * hello, world!
		 * hello, world!
		 * 你好, 世界！
		 * 你好, 世界！
		 * hello, world!
		 * .......
		 * ......
		 */
	}

}

class Printer {
	Object lock = new Object();
	public void print1() {
		//synchronized(new Lock()) {  //锁对象不能用匿名对象,因为匿名对象不是同一个对象
		synchronized(lock) {  	//同步代码块,锁机制,锁对象可以是任意的
			System.out.print("你");
			System.out.print("好");
			System.out.print(", ");
			System.out.print("世");
			System.out.print("界");
			System.out.print("！");
			System.out.print("\r\n");
		}
	}
	
	public void print2() {
		//synchronized(new Lock()) {
		synchronized(lock) {
			System.out.print("h");
			System.out.print("e");
			System.out.print("l");
			System.out.print("l");
			System.out.print("o");
			System.out.print(", ");
			System.out.print("w");
			System.out.print("o");
			System.out.print("r");
			System.out.print("l");
			System.out.print("d");
			System.out.print("!");
			System.out.print("\r\n");
		}
	}
}

