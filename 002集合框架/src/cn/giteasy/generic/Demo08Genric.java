package cn.giteasy.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

import cn.giteasy.common.Person;
import cn.giteasy.common.Student;
import org.junit.Test;

/**
 *
 *  ���͹̶��ϱ߽� ���������д�ֵ�򼯺��зŵ�ʱ��Ҫ��Ԫ����E��E������
 *  ? extends E
 *
 *  ���͹̶��±߽� ���Ӽ�����ȡ��ʱ��Ҫ��Ԫ�ر�����E��E������
 *  ? super E
 *
 */
public class Demo08Genric {


    /**
     * ���͹̶��ϱ߽�
     * ? extends E
     */
    @Test
    public void demo1() {
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("����", 23));
        list1.add(new Person("����", 24));


        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("����", 25));
        list2.add(new Student("����", 26));

        list1.addAll(list2);
    }


    @Test
	public void demo2(){

        TreeSet<Person> ts1 = new TreeSet<>(new CompareByAge());
        ts1.add(new Person("����", 33));
        ts1.add(new Person("����", 13));
        ts1.add(new Person("����", 23));
        ts1.add(new Person("����", 43));



        TreeSet<Student> ts2 = new TreeSet<>(new CompareByAge());
        ts2.add(new Student("����", 33));
        ts2.add(new Student("����", 13));
        ts2.add(new Student("����", 23));
        ts2.add(new Student("����", 43));

         System.out.println(ts2);
    }



}

class CompareByAge implements Comparator<Person> {

	@Override
	public int compare(Person s1, Person s2) {
		int num = s1.getAge() - s2.getAge();
		return num == 0 ? s1.getName().compareTo(s2.getName()) :  num;
	}

}


