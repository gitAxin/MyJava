package cn.giteasy.map;

import cn.giteasy.common.Student;

import java.util.HashMap;


/**
 *  A:案例演示
 * HashMap集合键是Student值是String的案例
 * 键是学生对象,代表每一个学生
 * 值是字符串对象,代表学生归属地
 */
public class Demo3HashMap {

    public static void main(String[] args) {
        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(new Student("张三", 23), "北京");
        hashMap.put(new Student("张三", 23), "上海");
        hashMap.put(new Student("李四", 24), "广州");
        hashMap.put(new Student("王五", 25), "深圳");

        System.out.println(hashMap);
    }
}
