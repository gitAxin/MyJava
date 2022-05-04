package cn.giteasy.thread.method;

import org.junit.Test;

/**
 * 守护线程
 * setDaemon(), 设置一个线程为守护线程, 该线程不会单独执行, 当其他非守护线程都执行结束后, 自动退出
 */
public class Demo04Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread("普通线程") {
			@Override
			public void run() {
				for(int i = 0; i < 2; i++) {
					System.out.println(getName() + i);
				}
			}
		};
		
		Thread t2 = new Thread("守护线程") {
			@Override
			public void run() {
				for(int i = 0; i < 50; i++) {
					System.out.println(getName() + i);
				}
			}
		};
		
		t2.setDaemon(true);							//设置为守护线程
		
		t1.start();
		t2.start();
	}

	/**
	 * 从打印结果，可以发现，守护线程并循环体并没有执行完，因为这时普通线程已经执行完成，所以守护线程随即退出
	 * 普通线程0
	 * 守护线程0
	 * 普通线程1
	 * 守护线程1
	 * 守护线程2
	 * 守护线程3
	 * 守护线程4
	 * 守护线程5
	 * 守护线程6
	 * 守护线程7
	 * 守护线程8
	 * 守护线程9
	 * 守护线程10
	 * 守护线程11
	 */

}
