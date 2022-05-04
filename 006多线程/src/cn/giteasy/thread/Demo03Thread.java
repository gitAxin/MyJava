package cn.giteasy.thread;

/**
 * 方式二：实现Runnable
 *
 * 1.定义类实现Runnable接口
 * 2.实现run方法
 * 3.把新线程要做的事写在run方法中
 * 4.创建自定义的Runnable的子类对象
 * 5.创建Thread对象, 传入Runnable
 * 6.调用start()开启新线程, 内部会自动调用Runnable的run()方法
 */
public class Demo03Thread {


	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();	//4.创建Runnable的子类对象
		Thread t = new Thread(mr);			//5.将其当作参数传递给Thread的构造函数
		t.start();							//6.开启线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("main 主线程");
		}
	}

}

class MyRunnable implements Runnable {		//1.定义一个类实现Runnable

	@Override
	public void run() {						//2.重写run方法
		for(int i = 0; i < 1000; i++) {		//3.将要执行的代码写在run方法中
			System.out.println("MyRunnable......");
		}
	}
	
}