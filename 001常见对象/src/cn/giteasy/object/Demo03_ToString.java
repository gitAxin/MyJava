package cn.giteasy.object;

import cn.giteasy.common.Student;

public class Demo03_ToString {

    public static void main(String[] args) {
        Student student = new Student("axin", 18);
        //未重写toString方法时，调用父类的toString方法，默认父类为Object
        //输出cn.giteasy.common.Student@1b6d3586

        /**
         *  Object.java
         *    public String toString() {
         *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *     }
         *
         *     Integer.toHexString(hashCode():表示hashCode的十六进制形式
         */
        String s = student.toString();//cn.giteasy.common.Student@1b6d3586
        System.out.println(s);


        /**
         * 重写toString()方法
         * Student.java
         *     @Override
         *     public String toString() {
         *         return "Student{" +
         *                 "name='" + name + '\'' +
         *                 ", age=" + age +
         *                 '}';
         *     }
         */
        String s2 = student.toString();
        System.out.println(s2);//Student{name='axin', age=18}
        System.out.println(student);//Student{name='axin', age=18}

    }
}
