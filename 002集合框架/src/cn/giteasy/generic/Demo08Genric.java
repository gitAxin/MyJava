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
 *  泛型固定上边界 ：往方法中传值或集合中放的时候要求元素是E或E的子类
 *  ? extends E
 *
 *  泛型固定下边界 ：从集合中取出时，要求元素必须是E或E的子类
 *  ? super E
 *
 */
public class Demo08Genric {


    /**
     * 泛型固定上边界
     * ? extends E
     */
    @Test
    public void demo1() {
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("张三", 23));
        list1.add(new Person("李四", 24));


        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("王五", 25));
        list2.add(new Student("赵六", 26));

        list1.addAll(list2);
    }


    @Test
	public void demo2(){

        TreeSet<Person> ts1 = new TreeSet<>(new CompareByAge());
        ts1.add(new Person("张三", 33));
        ts1.add(new Person("李四", 13));
        ts1.add(new Person("王五", 23));
        ts1.add(new Person("赵六", 43));



        TreeSet<Student> ts2 = new TreeSet<>(new CompareByAge());
        ts2.add(new Student("张三", 33));
        ts2.add(new Student("李四", 13));
        ts2.add(new Student("王五", 23));
        ts2.add(new Student("赵六", 43));

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


