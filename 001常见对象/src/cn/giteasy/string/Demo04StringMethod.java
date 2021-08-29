package cn.giteasy.string;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo04StringMethod {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();




    }

    /**
     * 判断字符串是否为空
     * ""和null的区别
     * ""是字符串常量,同时也是一个String类的对象,所以可以调用String类的方法
     * null是空常量,没有引用(指针),不能调用任何方法,否则空指针异常,null可以赋值给任何引用类型对象
     */
    private static void demo3() {
        String s1 = "hello world";
        String s2 = "";
        String s3 = null;

        System.out.println(s1.isEmpty());//false
        System.out.println(s2.isEmpty());//true
        //System.out.println(s3.isEmpty());//空指针异常 java.lang.NullPointerException
    }

    /**
     * 判断是否包含某个子串,或者是某个子串开始或结束
     */
    private static void demo2() {
        String s1 = "hello world";
        String s2 = "world";
        String s3 = "abc";
        String s4 = "hello";

        System.out.println(s1.contains(s2)); //true
        System.out.println(s1.contains(s3));//false

        System.out.println(s1.startsWith(s2));//false
        System.out.println(s1.startsWith(s4));//true

        System.out.println(s1.endsWith(s2));//true
        System.out.println(s1.endsWith(s4));//false
    }

    /**
     * 判断字符串是否相等
     */
    private static void demo1() {
        String s1 = "hello world";
        String s2 = "hello world";
        String s3 = "HELLO World";

        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//false

        System.out.println(s1.equalsIgnoreCase(s2));//true
        System.out.println(s1.equalsIgnoreCase(s3));//true
    }
}
