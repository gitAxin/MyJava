package cn.giteasy.proxy;

import cn.giteasy.common.User;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理概述
 *
 *  代理
 *      本来应该自己做的事情，请了别人来做，被请的人就是代理对象。
 *  动态代理
 *      在程序运行过程中产生的这个对象,而程序运行过程中产生对象其实就是反射的知识，所以，动态代理其实就是通过反射来生成一个代理
 *
 * 在Java中java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，通过使用这个类和接口就可以生成动态代理对象。
 *
 * >>>JDK提供的代理只能针对接口做代理，我们有更强大的代理cglib(此处只演示了JDK代理)<<<
 *
 * Proxy类中的方法创建动态代理类对象
 *      public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *      最终会调用InvocationHandler的方法
 *      InvocationHandler Object invoke(Object proxy,Method method,Object[] args)
 *
 * @author axin
 * @date 2022/5/21
 */
public class Main {


    /**
     * 未使用代理时，需要人实现类方法内部硬编码记录日志
     */
    @Test
    public void demo1(){
        UserService userService = new UserServiceImpl();

        User user = new User("zhangsan","123456");
        userService.login(user);
        userService.logout();


    }

    /**
     * 使用代理对象，记录日志
     */
    @Test
    public void demo2() {

        //创建代理对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        MyProxyHandler proxyHandler = new MyProxyHandler(userServiceImpl);

        UserService userService = (UserService)Proxy.newProxyInstance(userServiceImpl.getClass().getClassLoader(),
                                userServiceImpl.getClass().getInterfaces(),
                                proxyHandler);

        boolean isProxyClass = Proxy.isProxyClass(userService.getClass());
        System.out.println("isProxyClass:" + isProxyClass);

        //使用代理对象
        User user = new User("lisi","654321");
        userService.login(user);

        userService.logout();




    }




    /**
     * 使用匿名内部类
     */
    @Test
    public void demo3() {

        //创建代理对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserService userService = (UserService)Proxy.newProxyInstance(userServiceImpl.getClass().getClassLoader(),
                userServiceImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("被代理类：" + userServiceImpl.getClass().getName());
                        System.out.println("被代理方法：" + method.getName());

                        System.out.println("权限校验...");
                        Object result = method.invoke(userServiceImpl, args);
                        System.out.println("记录日志...");
                        return result;
                    }
                });

        boolean isProxyClass = Proxy.isProxyClass(userService.getClass());
        System.out.println("isProxyClass:" + isProxyClass);

        //使用代理对象
        User user = new User("lisi","654321");
        userService.login(user);

        userService.logout();




    }
}





class MyProxyHandler implements InvocationHandler{

    private Object target;

    public MyProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理类：" + target.getClass().getName());
        System.out.println("被代理方法：" + method.getName());

        System.out.println("权限校验...");
        Object result = method.invoke(target, args);
        System.out.println("记录日志...");
        return result;
    }
}
