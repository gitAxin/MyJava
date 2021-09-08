package cn.giteasy.linkedlist;

import java.util.LinkedList;

public class Demo02LinkedList {

	/**
	 * 用LinkedList模拟栈结构
	 */
	public static void main(String[] args) {
		//demo1();
		//使用自己封装的LinkedList模拟栈结构
		Stack s = new Stack();
		s.in("a");								//进栈
		s.in("b");
		s.in("c");
		s.in("d");
		
		while(!s.isEmpty()) {					//判断栈结构是否为空
			System.out.println(s.out());		//弹栈
		}
	}


	/**
	 * 使用LinkedList模拟栈结构
	 */
	public static void demo1() {
		LinkedList list = new LinkedList();					//创建集合对象
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		
		/*System.out.println(list.removeLast());
		System.out.println(list.removeLast());
		System.out.println(list.removeLast());
		System.out.println(list.removeLast());*/
		
		while(!list.isEmpty()) {
			System.out.println(list.removeLast());
		}
	}

}



class Stack {
	private LinkedList list = new LinkedList();

	/*
	 * 模拟进栈方法
	 */
	public void in(Object obj) {
		list.addLast(obj);
	}

	/*
	 * 模拟出栈
	 */
	public Object out() {
		//如果是模拟队列,可以使用list.removeFirst()
		return list.removeLast();
	}

	/*
	 * 模拟栈结构是否为空
	 */

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
