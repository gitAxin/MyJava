package cn.giteasy.string;

import java.util.Scanner;

/**
 * 字符串反转案例演示
 * 键盘输入字符串,如"abc"
 * 输出结果"cba"
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test06Reversal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >=0; i--) {
            result += chars[i];
        }
        System.out.println(result);

    }
}
