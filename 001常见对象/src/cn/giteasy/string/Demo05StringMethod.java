package cn.giteasy.string;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo05StringMethod {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(arr.length);//数组中的length是属性

        //获取字符串长度
        String s1 = "hello world";
        System.out.println(s1.length());//11 String中的length是方法

        String s2 = "<<静夜思>> 窗前明月光";
        System.out.println(s2.length());//13


        //获取指定位置的字符,下标从0开始
        System.out.println(s2.charAt(5));// >
        //System.out.println(s2.charAt(55));//下标越界异常 java.lang.StringIndexOutOfBoundsException

        //获取指定子串在字符串中第一次出现的索引
        int index1 = s1.indexOf(101);//1: 子串e在s1中第一次出现的位置
        System.out.println(index1);
        int index2 = s1.indexOf('e');//1
        System.out.println(index2);
        int index3 = s1.indexOf("world");//6
        System.out.println(index3);

        int index4 = s1.indexOf('o');
        System.out.println(index4);//4
        int index5 = s1.indexOf('o', 5);
        System.out.println(index5);//7

        String s3 = "hello world,world hello";
        int index6 = s3.indexOf("world", 8);
        System.out.println(index6);//12

        String filename = "filename.txt.back";
        int i = filename.lastIndexOf('.');
        System.out.println(i);//12
        int i1 = filename.lastIndexOf(".");
        System.out.println(i1);//12
        //最后一次出现的位置
        int i2 = filename.lastIndexOf(".txt");
        System.out.println(i2);//8

        String sub1 = filename.substring(12);
        System.out.println(sub1);//.back
        String sub2 = filename.substring(8,12);//可以理解为下标8开始,查找4个(含头不含尾)(左边是闭区间,右边是开区间)
        System.out.println(sub2);//.txt

    }
}
