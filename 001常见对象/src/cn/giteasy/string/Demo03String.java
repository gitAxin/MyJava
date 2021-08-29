package cn.giteasy.string;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo03String {
    public static void main(String[] args) {

        //demo1();
        //demo2();
        //demo3();
        //demo4();
        //demo5();


    }

    /**
     * 判断是否相等
     */
    private static void demo5() {
        String s1 = "ab";
        //存在常量池中
        String s2 = "abc";
        //当等号右边涉及到了变量,底层会使用StringBuild或StringBuffer的append拼接字符串,
        // 最后调用toString()转换成字符串,该字符串是一个对象,存在于堆中,返回该对象的地址给s3
        //存在堆中
        String s3 = s1 + "c";
        //false
        //例外情况:如果s1使用final进行了修饰,则结果会为true,因为在编译期,确定了s1是一个常量,会直接将s1 + "c" 编译成"abc"
        System.out.println(s3 == s2);
        //true
        System.out.println(s3.equals(s2));
    }

    /**
     * 判断是否相等
     */
    private static void demo4() {
        //在编辑时就变成了"abc",把abc赋值给了s1
        //因为常量池中没有"abc",所以在常量池中创建,将地址赋给s1

        String s1 = "a" + "b" + "c";
        //常量池中已经存在了abc,直接取出地址,赋值给S2
        String s2 = "abc";

        //true
        System.out.println(s1 == s2);
        //true
        System.out.println(s1.equals(s2));
    }

    private static void demo3() {
        //记录的是堆中的地址值
        String s1 = new String("abc");
        //记录的是常量池中的地址值
        String s2 = "abc";
        //false
        System.out.println(s1 == s2);
        //true
        System.out.println(s1.equals(s2));
    }

    /**
    判断会创建几个对象
     */
    private static void demo2() {
        //以下行为会创建2个对象，1个在常量池中，1个在堆内存中
        //首先会查看常量池中是否有常量“abc”,如果存在，则copy一个副本放到堆中，创建一个对象，将这个对象的地址
        //赋值给str1
        String str1 = new String("abc");
        System.out.println(str1);
    }

    /**
     * 判断s1与s2是否相等
     */
    private static void demo1() {
    /*
        abc在常量池中查看是否存在，不存在则在常量池中创建，如果有直接返回该对象的地址
     */
        String s1 = "abc";
        String s2 = "abc";
        //true
        System.out.println(s1 == s2);
        //true
        System.out.println(s1.equals(s2));
    }
}
