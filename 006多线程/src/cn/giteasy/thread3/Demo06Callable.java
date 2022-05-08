package cn.giteasy.thread3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程程序实现的方式3
 * 多线程程序实现的方式3的好处和弊端
 *
 * 好处：
 *   1.可以有返回值
 *   2.可以抛出异常
 *
 * 弊端：
 *   代码比较复杂，所以一般不用
 *
 *
 *
 */
public class Demo06Callable {


	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		//将线程放进池子里并执行
		Future<Integer> f1 = pool.submit(new MyCallable(100));
		Future<Integer> f2 = pool.submit(new MyCallable(50));
		
		System.out.println(f1.get());
		System.out.println(f2.get());

		//关闭线程池
		pool.shutdown();
	}

}

class MyCallable implements Callable<Integer> {
	private int num;
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}