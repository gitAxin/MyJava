package cn.giteasy.string;

import java.util.Locale;

/**
 * 字符串转换案例
 * 把一个字符串的每个单词首字母转换成大写,其余为小写(只考虑英文字母)
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test04StringConvert {
    public static void main(String[] args) {
        String s = "hello world! there are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real";
        String result = "";
        //split:字符串分割
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            //链式编程:只要保证每次调用完,返回的是一个对象,就可以继续调用
            result += s1[i].substring(0,1).toUpperCase().concat(s1[i].substring(1).toLowerCase());
            if(i != s1.length - 1){
                result += " ";
            }

        }
        System.out.println(result);

    }
}
