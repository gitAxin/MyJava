package cn.giteasy.syn;

/**
 * 同步方法
 * @author Axin
 */
public class Demo02Synchronized {

	/**
	 * 同步方法演示
	 */
	public static void main(String[] args) {
		final Writer w = new Writer();
		
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
					w.print1();
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
					w.print2();
				}
			}
		}.start();


        /**
		 * 输出结果：
		 * hello, world!
		 * 你好, 世界！
		 * hello, world!
		 * 你好, 世界！
		 * hello, world!
		 * 你好, 世界！
		 * 你好, 世界！
		 * hello, world!
		 * 你好, 世界！
		 * hello, world!
		 * .......
		 * ......
		 */
	}

}

class Writer {
	/**
	 * 	非静态的同步方法的锁对象是什么?
	 * 		答:非静态的同步方法的锁对象是this
	 *
	 * 	静态的同步方法的锁对象是什么?
	 * 		答：是该类的字节码对象 （Writer.class）
	 */

	//使用synchronized关键字修饰方法
	public synchronized void print1() {
		System.out.print("你");
		System.out.print("好");
		System.out.print(", ");
		System.out.print("世");
		System.out.print("界");
		System.out.print("！");
		System.out.print("\r\n");
	}
	
	public synchronized void print2() {
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

