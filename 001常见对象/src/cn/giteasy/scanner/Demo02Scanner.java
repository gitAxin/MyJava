package cn.giteasy.scanner;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/28
 */
public class Demo02Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /*
        在输入数字的情况下，正常输出
         */
//        System.out.println("请输入第一个整数");
//        int i = scanner.nextInt();
//        System.out.println("请输入第二个整数");
//        int j = scanner.nextInt();
//        System.out.println("i = " + i  + ", j = " + j);


       //可正常输出
//        System.out.println("请输入字符串1");
//        String s1 = scanner.nextLine();
//        System.out.println("请输入字符串2");
//        String s2 = scanner.nextLine();
//        System.out.println("s1 = " + s1 + ", s2 = " + s2);

        /*
            当输入数字和输入字符串混用的时候，会出现问题


            nextInt()是键盘录入整数的方式，当我们录入数字后，比如数字8，其实是在键盘上录入的是8和\r\n，
            nextInt()方法只获取8就结束了，

            nextLine()是键盘录入字符串的方法，可以接收任意类型，每次可以接收一行字符串，使用\r\n判断这一行是否结束
            所以当录入数字8以后，后面的nextLint()方法再获取的是\r\n，它认为这一行结束了，所以获取到的是空字符串
         */

        System.out.println("请输入第一个整数");
        int k = scanner.nextInt();
        System.out.println("请输入字符串2");
        String ss = scanner.nextLine();
        System.out.println("k = " + k + ", ss = " + ss);

        /*
        在输出结果中，当输入数字后，还没有输入字符串就直接结束了，而且变量ss是空的
        请输入第一个整数
        1
        请输入字符串2
        k = 1, ss =
         */


        /*
            解决方案：
            方案一:创建两次对象，但是浪费空间
            方案二:我们只使用nextLine()方法，无论获取什么类型的数据，当获取到输入的字符时，
                使用相应的API将字符串转换为指定的类型，在转换之前判断是否可以转换类型，
                不可转换，拋出异常或者提示重新录入。
         */

        //方案一：
        int n = scanner.nextInt();
        Scanner sc2 = new Scanner(System.in);
        String s = sc2.nextLine();
        System.out.println("n = " + n + ", s = " + s);


    }
}
