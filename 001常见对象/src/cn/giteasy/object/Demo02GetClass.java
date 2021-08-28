package cn.giteasy.object;

import cn.giteasy.common.Student;
/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/27
 */
public class Demo02GetClass {

    public static void main(String[] args) {
        Student student = new Student("axin",18);
        //获取student对象的字节码文件，后面反射中常用
        Class clazz = student.getClass();
        String name = clazz.getName();
        System.out.println(name);//cn.giteasy.common.Student

    }
}
