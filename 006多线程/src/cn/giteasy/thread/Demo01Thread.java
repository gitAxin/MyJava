package cn.giteasy.thread;

/**
 *Java程序运行原理
 *	Java命令会启动java虚拟机，启动JVM，等于启动了一个应用程序，也就是启动了一个进程。该进程会自动启动一个 “主线程” ，然后主线程去调用某个类的 main 方法。
 *
 * JVM的启动是多线程的吗？
 *   JVM启动至少启动了垃圾回收线程和主线程，所以是多线程的。
 *
 *
 */
public class Demo01Thread {


	/**
	 * 证明jvm是多线程的
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 10000000; i++) {
			new Demo();
		}
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("我是主线程的执行代码");
		}
	}

	/**
	 * 输出结果
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我被清扫了
	 * 我被清扫了
	 * 我被清扫了
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我被清扫了
	 * 我被清扫了
	 * 我被清扫了
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 * 我是主线程的执行代码
	 */

}

class Demo {

	/**
	 *  Object finalize() 方法用于实例被垃圾回收器回收的时触发的操作。
	 * 当 GC (垃圾回收器) 确定不存在对该对象的有更多引用时，对象的垃圾回收器就会调用这个方法。
	 */
	@Override
	public void finalize() {
		System.out.println("我被清扫了");
	}
	
}