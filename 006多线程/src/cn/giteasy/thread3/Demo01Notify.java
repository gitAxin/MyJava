package cn.giteasy.thread3;

/**
 *
 *
 * 两个线程间的通信
 * 1.什么时候需要通信
 *  多个线程并发执行时, 在默认情况下CPU是随机切换线程的
 *  如果我们希望他们有规律的执行, 就可以使用通信, 例如每个线程执行一次打印
 * 2.怎么通信
 *  如果希望线程等待, 就调用wait()
 *  如果希望唤醒等待的线程, 就调用notify();
 *  这两个方法必须在同步代码中执行, 并且使用同步锁对象来调用
 *
 * 需求
 * 实现打印一行英文，打印一行中文
 *
 * 唤醒机制
 */
public class Demo01Notify {


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
	}


	static class Printer {
		private int flag = 1;


		public void print1(){
			synchronized(this) {
				/**
				 * 当flag=1时,才执行，否则等待唤醒
				 */
				if(flag != 1){
					try {
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
				//随机唤醒单个等待的线程：“我执行完了，该你了”
				this.notify();
			}
		}

		public void print2() {
			synchronized(this) {
				/**
				 * 当flag=2时,才执行，否则等待唤醒
				 */
				if(flag != 2){
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
				flag = 1;
				this.notify();
			}
		}
	}



}
