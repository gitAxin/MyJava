package cn.giteasy.feature.jdk8;

import org.junit.Test;

/**
 * JDK8新特性
 *  接口中可以定义默认(default)方法
 *  在局部内部类和匿名内部类中，访问它所在方法的局部变量可以省略final修饰
 * @author axin
 * @date 2022/5/21
 */
public class Demo01JDK8 {

    /**
     * 演示：
     * 接口中可以定义默认(default)方法
     */
    @Test
    public void demo1(){
        TestClass test = new TestClass();
        test.print();
        TestInter.test();
    }


    /**
     * 关于在局部内部类和匿名内部类中，访问它所在方法的局部变量时的问题
     *
     * 局部内部类在访问他所在方法中的局部变量必须用final修饰,为什么?
     *      因为当调用这个方法时,局部变量如果没有用final修饰,他的生命周期和方法的生命周期是一样的,当方法弹栈,这个局部变量也会消失,
     *      那么如果局部内部类对象还没有马上消失想用这个局部变量,就没有了,
     *      如果用final修饰会在类加载的时候进入常量池,即使方法弹栈,常量池的常量还在,也可以继续使用
     *
     */
    @Test
    public void demo2(){
        /**
         * JDK1.8之前必需要加final
         * JDK1.8起可以省略final
         */
        //final int var = 1;
        int var = 1;

        class Inner{
            public void fun(){
                //虽然可以省略final，但是还是不能修改，可以认为它会默认加上final关键字
                //var = 2;
                System.out.println(var);
            }

        }
        Inner inner = new Inner();
        inner.fun();
    }





}


/**
 * 接口中可以定义默认(default)方法
 */
interface TestInter{
    /**
     * 接口中可以定义有方法体的方法,如果是非静态,必须用default修饰
     */
    public default void print(){
        System.out.println("hello world!");
    }


    /**
     * 如果是静态的就不需要default修饰了
     */
    public static void test(){
        System.out.println("interface TestInter: public static void test()");
    }

}

class TestClass implements TestInter {


}
