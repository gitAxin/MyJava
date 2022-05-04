package cn.giteasy.thread.method;

public class Demo07Priority {


	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(getName() + "	-	Thread A" );
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(getName() + "	-	Thread B" );
				}
			}
		};

		t1.setPriority(Thread.MIN_PRIORITY);		//设置最小的线程优先级
		t2.setPriority(Thread.MAX_PRIORITY);		//设置最大的线程优先级

		//也可以设置自定义值，最不要超出范围 1 <= newPriority <= 10
		//t1.setPriority(10);
		//t2.setPriority(1);

		t1.start();
		t2.start();
	}

}
