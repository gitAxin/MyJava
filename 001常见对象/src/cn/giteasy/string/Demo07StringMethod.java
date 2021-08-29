package cn.giteasy.string;

/**
 *
 *
 * @author axin
 * @date 2021/8/29
 */
public class Demo07StringMethod {
    public static void main(String[] args) {

        //demo1();
        //demo2();
        String s1 = "bcdef";
        String s2 = "a";
        /*
        s1 < s2 结果为小于0的数
        s1 = s2 返果为0
        s1 > s2 结果为大于0的数
         */
        int i = s1.compareTo(s2);//按照码表值比较 unicode码表值
        System.out.println(i);

        String s3 = "中";
        String s4 = "国";
        int i1 = s3.compareTo(s4);
        System.out.println('中' + 0);//20013
        System.out.println('国' + 0);//22269
        System.out.println(i1);//-2256

        String s5 = "ABC";
        String s6 = "abc";
        System.out.println(s5.compareTo(s6));//-32
        System.out.println(s5.compareToIgnoreCase(s6));//0


        /*
        compareToIgnoreCase()的源码:
         public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1); //防止一个大写 一个小写,统一转换成大写
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1); //统一转换成小写
                        c2 = Character.toLowerCase(c2);
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }
         */


    }

    /**
     * 去除字符串两端的空格
     */
    private static void demo2() {
        String s = "   hello    world  ";
        String trim = s.trim();
        System.out.println(s);//"   hello    world  "
        System.out.println(trim);//hello    world //只替换两端的空格
    }

    /**
     * String类的字符串替换
     */
    private static void demo1() {
        //演示String类的替换功能
        String s = "hello world";
        String s1 = s.replace("world","axin");
        System.out.println(s);//hello world
        System.out.println(s1);//hello axin

        String replace = s.replace("hhh", "www");
        System.out.println(replace); //hhh不存在的情况下,保持不变
    }
}
