package cn.giteasy.object;

import cn.giteasy.common.Student;
/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/27
 */
public class Demo04Equals {
    public static void main(String[] args) {
        Student s1 = new Student("lm",18);
        Student s2 = new Student("lm",18);
        /*
         * java/lang/Object.java
         *  public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         */


        //false 默认比较的是地址值,无意义
        System.out.println(s1.equals(s2));

        //false ==比较的也是地址值
        System.out.println(s1 == s2);

        /*
         *     @Override
         *     public boolean equals(Object obj) {
         *         Student stu = (Student) obj;
         *         return this.name.equals(stu.getName()) && this.age == stu.getAge();
         *     }
         *
         */
        //重写Equals方法后 true
        System.out.println(s1.equals(s2));

    }
}
