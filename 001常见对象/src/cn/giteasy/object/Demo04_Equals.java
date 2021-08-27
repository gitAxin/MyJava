package cn.giteasy.object;

import cn.giteasy.common.Student;

public class Demo04_Equals {
    public static void main(String[] args) {
        Student s1 = new Student("lm",18);
        Student s2 = new Student("lm",18);
        /**
         * java/lang/Object.java
         *  public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         */
        System.out.println(s1.equals(s2));//false 默认比较的是地址值,无意义
        System.out.println(s1 == s2);//false ==比较的也是地址值

        //重写Equals方法后
        /**
         *     @Override
         *     public boolean equals(Object obj) {
         *         Student stu = (Student) obj;
         *         return this.name.equals(stu.getName()) && this.age == stu.getAge();
         *     }
         */
        System.out.println(s1.equals(s2));//true

    }
}
