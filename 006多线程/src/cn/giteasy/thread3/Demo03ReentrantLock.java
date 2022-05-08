package cn.giteasy.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK1.5的新特性互斥锁
 */
public class Demo03ReentrantLock {


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
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					p.print3();
				}
			}
		}.start();
	}


	static class Printer {

		private ReentrantLock r = new ReentrantLock();
		//创建3个监视器
		private Condition c1 = r.newCondition();
		private Condition c2 = r.newCondition();
		private Condition c3 = r.newCondition();
		private int flag = 1;
		public void print1(){
			r.lock();
			try {
				/**
				 * 当flag=1时,才执行，否则等待唤醒，
				 */
				if(flag != 1){
					try {
						/**
						 * 在哪里等待，下次就在哪里醒来
						 */
						c1.await();
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
				c2.signal();
			}finally {
				r.unlock();
			}
		}

		public void print2() {
			r.lock();
			try{
				/**
				 * 当flag=2时,才执行，否则等待唤醒
				 */
				if(flag != 2){
					try {
						c2.await();
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
				flag = 3;
				//this.notifyAll();
				c3.signal();
			}finally {
				r.unlock();
			}

		}


		public void print3() {
			r.lock();
			try{
				/**
				 * 当flag=3时,才执行，否则等待唤醒
				 */
				if(flag != 3){
					try {
						c3.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("=");
				System.out.print("\r\n");
				flag = 1;
				//this.notifyAll();
				c1.signal();
			}finally {
				r.unlock();
			}

		}
	}

}


