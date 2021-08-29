package cn.giteasy.string;

/**
 * 字符串遍历
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test02StringEach {

    public static void main(String[] args) {
        String s1 = "hello world";
        for (int i = 0; i < s1.length(); i++) {
            //通过索引获取字符
            char c = s1.charAt(i);
            System.out.println(c);
        }

        /*
            结果打印:
            h
            e
            l
            l
            o

            w
            o
            r
            l
            d
         */
    }
}
