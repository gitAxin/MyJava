package cn.giteasy.set;

import cn.giteasy.common.HashSetPerson;

import java.util.HashSet;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/9/17
 */
public class Demo02HashSet {

    public static void main(String[] args) {
        HashSet<HashSetPerson> hs = new HashSet<>();
        hs.add(new HashSetPerson("zhangsan", 23));
        hs.add(new HashSetPerson("zhangsan", 23));
        hs.add(new HashSetPerson("lisi", 24));
        hs.add(new HashSetPerson("lisi", 24));
        hs.add(new HashSetPerson("lisi", 24));
        hs.add(new HashSetPerson("lisi", 24));
        System.out.println(hs.size());//2
        System.out.println(hs);//[HashSetPerson [name=zhangsan, age=23], HashSetPerson [name=lisi, age=24]]
    }
}
