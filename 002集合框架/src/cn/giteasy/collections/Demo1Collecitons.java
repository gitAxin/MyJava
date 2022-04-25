package cn.giteasy.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 	Collecitons�еĳ�������
 * 	public static <T> void sort(List<T> list)
 * 	���ֲ���
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
		Collections.sort(list);						//����������
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
		System.out.println(Collections.binarySearch(list, "b")); //-2 δ�ҵ�,���ظ���
	}


	@Test
	public void demo3(){
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("g");
		list.add("f");
		//�ײ����ִ������,�ٸ�����������ȡ�����е����ֵ
		String max = Collections.max(list);
		System.out.println(max); 		//g
		//��ת����
		Collections.reverse(list);
		System.out.println(list);  //[f, g, d, c, a]

		//����û�,��������ϴ��
		Collections.shuffle(list);
		System.out.println(list);
	}





}
