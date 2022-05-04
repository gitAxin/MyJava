package cn.giteasy.thread.method;

import java.util.Hashtable;
import java.util.Vector;

/**
 * 礼让线程
 * yield()让出cpu
 *
 */
public class Demo06Yield {


	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			System.out.println(getName() + " - before	yield - " + i);
			if(i % 10 == 0) {
				//让出CPU
				System.out.println(getName() + "			yield - " + i);
				Thread.yield();
			}
			System.out.println(getName() + " - after	yield - " + i);
		}
	}

}