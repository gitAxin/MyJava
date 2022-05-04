package cn.giteasy.thread.method;

/**
 * 获取当前线程对象
 */
public class Demo02CurrentThread {


	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				System.out.println(getName() + "子线程：new Thread()");
			}
		}.start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				//Thread.currentThread()获取当前正在执行的线程
				System.out.println(Thread.currentThread().getName() + "子线程：new Runnable()");
			}
		}).start();
		
		Thread.currentThread().setName("我是主线程");
		System.out.println(Thread.currentThread().getName());
	}

}
