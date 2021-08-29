package cn.giteasy.string;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 模拟用户登录
 * 需求:模拟登录,三次登录错误,锁定1小时,给予提示
 *      用户名:admin
 *      密码:admin
 *
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test01MockLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();

            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            //字符串调用方法,可以防止空指针异常
            if("admin".equals(username) && "admin".equals(password)){
                System.out.println("登录成功!");
                    break;
            }else{
                if(i == 2){
                    System.out.println("登录失败,账户锁定,请1小时后再重试.");
                }else{
                    System.out.println("登录失败,还有" + (2-i) + "次机会");
                }
            }

        }



    }
}
