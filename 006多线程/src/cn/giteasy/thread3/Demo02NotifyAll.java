package cn.giteasy.thread3;

/**
 *三个或三个以上间的线程通信
 *
 * 多个线程通信的问题
 *	1.notify()方法是随机唤醒一个线程
 *	2.notifyAll()唤醒所有等待的线程。
 *	3.JDK5之前无法唤醒指定的一个线程
 *	4.如果多个线程之间通信, 需要使用notifyAll()通知所有线程, 用while来反复判断条件
 *
 *
 * 演示：
 * 已知有三个线程，分别处理打印中文，英文和分隔线。
 * 实现，打印一行中文、打印一行英文、打印一行分隔线。
 *
 */
public class Demo02NotifyAll {


	public static void main(String[] args) {
		final Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				while(true) {
					p.print1();
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					p.print2();
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					p.print3();
				}
			}
		}.start();
	}

	/**
	 * 1.在同步代码块中,用哪个对象锁,就用哪个对象调用wait方法
	 * 2.为什么wait方法和notify方法定义在Object这类中?
	 * 	因为锁对象可以是任意对象,Object是所有的类的基类,所以wait方法和notify方法需要定义在Object这个类中
	 * 3.sleep方法和wait方法的区别?
	 * 	a.sleep方法必须传入参数,参数就是时间,时间到了自动醒来
	 *   	wait方法可以传入参数也可以不传入参数,传入参数就是在参数的时间结束后等待,不传入参数就是直接等待
	 * 	b.sleep方法在同步函数或同步代码块中,不释放锁,睡着了也抱着锁睡
	 * 		wait方法在同步函数或者同步代码块中,释放锁
	 *
	 */

	static class Printer {
		private int flag = 1;


		public void print1(){
			synchronized(this) {
				/**
				 * 当flag=1时,才执行，否则等待唤醒，
				 */
				while(flag != 1){
					try {
						/**
						 * 1.在哪里等待，下次就在哪里醒来
						 * 2.在同步代码块中，用哪个对象锁，就用哪个对象调用wait方法，本例中使用this
						 */
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("你");
				System.out.print("好");
				System.out.print(", ");
				System.out.print("世");
				System.out.print("界");
				System.out.print("！");
				System.out.print("\r\n");
				flag = 2;
				//唤醒其他所有等待的线程（如果2个以上的线程唤醒要使用notifyAll,否则会出现所有线程都处于等待的情况。）
				this.notifyAll();
			}
		}

		public void print2() {
			synchronized(this) {
				/**
				 * 当flag=2时,才执行，否则等待唤醒
				 */
				while(flag != 2){
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
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
				flag = 3;
				this.notifyAll();
			}
		}


		public void print3() {
			synchronized(this) {
				/**
				 * 当flag=3时,才执行，否则等待唤醒
				 */
				while(flag != 3){
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("\r\n");
				flag = 1;
				//this.notify();
				this.notifyAll();
			}
		}
	}

}


