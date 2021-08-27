package cn.giteasy.object;

import cn.giteasy.common.Student;

public class Demo01_HashCode {
    public static void main(String[] args) {
        Object o = new Object();
        int hashCode = o.hashCode();

        //public native int hashCode();
        //native 借助本地系统资源 计算hashCode
        System.out.println(hashCode);//460141958

        Student sally = new Student("sally", 18);
        Student liming = new Student("liming", 22);
        System.out.println(sally.hashCode());//1163157884
        System.out.println(liming.hashCode());//1956725890

    }
}
