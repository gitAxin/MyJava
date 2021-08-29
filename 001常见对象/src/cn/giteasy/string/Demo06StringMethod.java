package cn.giteasy.string;

import cn.giteasy.common.Student;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo06StringMethod {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //demo1();
        //demo2();
        //demo3();
        //字符串大小写转换
        String s = "hello WORLD";
        String s1 = s.toLowerCase();
        String s2 = s.toUpperCase();
        System.out.println(s);//hello WORLD
        System.out.println(s1);//hello world
        System.out.println(s2);//HELLO WORLD


        //字符串拼接
        String s3 = "hello";
        String s4 = "world";
        System.out.println(s3 + s4);//helloworld
        System.out.println(s3.concat(s4));//helloworld

        /*
        用+号拼接更强大,可以用字符串与任意类型拼接
        concat方法只能字符串类型的对象才能调用
         */

    }

    private static void demo3() {
        String s = String.valueOf(97);
        System.out.println(s);
        String s1 = String.valueOf(3.1415926);
        System.out.println(s1);
        String s2 = String.valueOf('a');
        System.out.println(s2);

        char[] arr = {'a','b','c'};
        String s3 = String.valueOf(arr);
        System.out.println(s3);

        Student student = new Student("ali", 18);
        String s4 = String.valueOf(student);
        System.out.println(s4);
        System.out.println(student.toString());
    }

    private static void demo2() {
        //把字符串转换为字符数组
        String s = new String("hello world");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    private static void demo1() throws UnsupportedEncodingException {
        String s1 = "abc";
        byte[] bytes = s1.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        /*
            97
            98
            99
         */

        String s2 = "中华人民共和国";
        //编码:把我们认识的字符串,转换为计算机可以识别的字节
        byte[] bytes1 = s2.getBytes("gbk");
        /*
        GBK码表的特点:
        一个中文代表两个字节
        中文的第一个字节是负数
         */
        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }
    }
}
