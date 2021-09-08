package cn.giteasy.linkedlist;

import java.util.LinkedList;

public class Demo01LinkedList {

	/**
	 * 	 public void addFirst(E e)及addLast(E e)
		* public E getFirst()及getLast()
		* public E removeFirst()及public E removeLast()
		* public E get(int index);
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addLast("e");
		System.out.println(list);//[d, c, b, a, e]
		
		System.out.println(list.getFirst());//d
		System.out.println(list.getLast());//e

		System.out.println(list.removeFirst());//d
		System.out.println(list);//[c, b, a, e]

		System.out.println(list.removeLast());//e
		System.out.println(list);//[c, b, a]

		System.out.println(list.get(1));//b
		System.out.println(list);//[c, b, a]
	}
/*dcbae*/
}
