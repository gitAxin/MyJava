package cn.giteasy.thread.method;

/**
 * 加入线程
 * join(), 当前线程暂停, 等待指定的线程执行结束后, 当前线程再继续
 */
public class Demo06Join {

	public static void main(String[] args) {
		final Thread t1 = new Thread("======t1======") {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++) {
					System.out.println(getName());
				}
			}
		};
		
		Thread t2 = new Thread("t2") {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					if(i == 2) {
						try {
							System.out.println("线程"+t1.getName()+"插队执行");
							//t1.join();
							t1.join(1);					//插队指定的时间,过了指定时间后,两条线程交替执行
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					}
					System.out.println(getName());
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
