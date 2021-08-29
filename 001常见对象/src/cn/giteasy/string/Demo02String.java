package cn.giteasy.string;



/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo02String {
    public static void main(String[] args) {
        //空构造
        String str1 = new String();
        System.out.println(str1);

        //使用平台默认码表 IDEA:File-Settings-Editor-File Encoding 中设置的
        //这一步也叫做解码，将二进制数据解码成我们看得懂的
        byte[] b1 = {97,98,99};
        String str2 = new String(b1);
        //输出abc
        System.out.println(str2);


        /*
        只解码部分字节
         */
        byte[] arr2 = {97,98,99,100,101,102};
        //从索引3开始，转换3个
        String str3 = new String(arr2, 3, 3);
        //输出def
        System.out.println(str3);

        /*
        将字符数组转换成字符串
         */
        char[] arr3 = {'a','b','c','d','e','f','g'};
        String s = new String(arr3);
        //转换成字符串输出 abcdefg
        System.out.println(s);

        //只转换部分字符串，
        String s1 = new String(arr3, 3, 3);
        //输出def
        System.out.println(s1);

        String axin = new String("axin");
        System.out.println(axin);



    }
}
