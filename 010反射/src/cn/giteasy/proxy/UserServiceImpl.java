package cn.giteasy.proxy;

import cn.giteasy.common.User;

/**
 * Demo class
 *
 * @author axin
 * @date 2022/5/21
 */
public class UserServiceImpl implements  UserService{



    @Override
    public void login(User user) {
        //System.out.println("权限校验...");
        System.out.println(user.getUsername() + "进行登录！");
        //System.out.println("记录登录日志...");

    }

    @Override
    public void logout() {
        System.out.println("退出！");
        //System.out.println("记录退出日志...");
    }
}
