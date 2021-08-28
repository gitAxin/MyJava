package cn.giteasy.scanner;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/28
 */
public class Demo01Scanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        如果输入非数字类型 ，会拋出InputMismatchException
         */
        int i = scanner.nextInt();
        System.out.println(i);

        /*
        判断下一个输入的是否是整数
         */
        boolean b = scanner.hasNextInt();
        if(b){
            i = scanner.nextInt();
            System.out.println(i);
        }else{
            System.out.println("输入类型错误");
        }
    }
}
