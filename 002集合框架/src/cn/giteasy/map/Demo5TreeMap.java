package cn.giteasy.map;

import java.util.Comparator;
import java.util.TreeMap;

import cn.giteasy.common.Student;
import org.junit.Test;

/**
 * A:������ʾ
 * TreeMap���ϼ���Studentֵ��String�İ���
 */
public class Demo5TreeMap {

	@Test
	public void demo1() {
		TreeMap<Student, String> treeMap = new TreeMap<>();
		treeMap.put(new Student("����", 23), "����");
		treeMap.put(new Student("����", 13), "�Ϻ�");
		treeMap.put(new Student("����", 33), "����");
		treeMap.put(new Student("����", 43), "����");
		/**
		 * ���Studentδʵ��Comparable,�������´���:
		 *
		 * java.lang.ClassCastException: cn.giteasy.common.Student cannot be cast to java.lang.Comparable
		 * �쳣:TreeMap��KEY������Ҫʵ��java.lang.Comparable�ӿ�,�����ʵ��,��֪����αȽ�,��α���
		 *
		 * �˴�����Student�ĸ���Person��ʵ����Comparable�ӿ�,����������ӡ
		 *	��ӡ���:
		 * {Person [name=����, age=13]=�Ϻ�, Person [name=����, age=23]=����, Person [name=����, age=33]=����, Person [name=����, age=43]=����}
		 */

		System.out.println(treeMap);
	}

	/**
	 *����TreeMap��ʱ��,����һ���Ƚ���
	 */
	@Test
	public void demo2(){
		TreeMap<Student, String> treeMap = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {

				return s1.getAge() - s2.getAge();//��������Ƚ�
			}
		});
		treeMap.put(new Student("����", 23), "����");
		treeMap.put(new Student("����", 13), "�Ϻ�");
		treeMap.put(new Student("����", 43), "����");
		treeMap.put(new Student("����", 33), "����");

		System.out.println(treeMap);
		//{Person [name=����, age=13]=�Ϻ�, Person [name=����, age=23]=����, Person [name=����, age=33]=����, Person [name=����, age=43]=����}
	}



}
