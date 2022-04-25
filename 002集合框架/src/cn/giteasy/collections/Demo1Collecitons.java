package cn.giteasy.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 	Collecitons中的常见方法
 * 	public static <T> void sort(List<T> list)
 * 	二分查找
 *	public static <T> int binarySearch(List<?> list,T key)
 *	public static <T> T max(Collection<?> coll)
 *	public static void reverse(List<?> list)
 *	public static void shuffle(List<?> list)
 */
public class Demo1Collecitons {


	@Test
	public void demo1() {
		ArrayList<String> list = new ArrayList<>();
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("d");

		System.out.println(list);
		Collections.sort(list);						//将集合排序
		System.out.println(list);
		/**
		 * [c, a, a, b, d]
		 * [a, a, b, c, d]
		 */
	}


	@Test
	public void demo2() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("f");
		list.add("g");

		System.out.println(Collections.binarySearch(list, "c"));//1
		System.out.println(Collections.binarySearch(list, "b")); //-2 未找到,返回负数
	}


	@Test
	public void demo3(){
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("g");
		list.add("f");
		//底层会先执行排序,再根据排序结果获取集合中的最大值
		String max = Collections.max(list);
		System.out.println(max); 		//g
		//反转集合
		Collections.reverse(list);
		System.out.println(list);  //[f, g, d, c, a]

		//随机置换,可以用来洗牌
		Collections.shuffle(list);
		System.out.println(list);
	}





}
