package cn.giteasy.thread.method;

import org.junit.Test;

public class Demo01ThreadName {


	/**
	 * 通过构造方法设置线程名称
	 */
	@Test
	public void demo1() {
		new Thread("线程1") {	//通过构造方法设置线程名称
			@Override
			public void run() {
				System.out.println(this.getName());
			}
		}.start();

		new Thread("线程2") {
			@Override
			public void run() {
				System.out.println(this.getName());
			}
		}.start();
	}


	/**
	 * 通过setName方法设置线程名称
	 */
	@Test
	public void demo2() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				//this.setName("setName(): " + "张三");
				System.out.println(this.getName());
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				//this.setName("setName(): " + "李四");
				System.out.println(this.getName());
			}
		};
		
		t1.setName("setName(): " + "zhangsan");
		t2.setName("setName(): " + "lisi");
		t1.start();
		t2.start();
	}


	@Test
	public void demo3() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我的名称叫:" + Thread.currentThread().getName());
			}
		},"zhangsan");

		t1.start();
	}


	@Test
	public void demo4() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//设置名称
				Thread.currentThread().setName("lisi");
				System.out.println("我的名称叫:" + Thread.currentThread().getName());
			}
		});

		t1.start();
	}


}
