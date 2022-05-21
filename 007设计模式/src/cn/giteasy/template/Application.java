package cn.giteasy.template;

import org.junit.Test;

/**
 * 模版设计模式概述
 *    模版方法模式就是定义一个算法的骨架，而将具体的算法延迟到子类中来实现
 * 优点
 *    使用模版方法模式，在定义算法骨架的同时，可以很灵活的实现具体的算法，满足用户灵活多变的需求
 * 缺点
 *    如果算法骨架有修改的话，则需要修改抽象类
 *
 * @author axin
 * @date 2022/5/21
 */
public class Application {


    /**
     * 例：统计一段代码的运行时间
     */
    @Test
    public void demo1(){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++) {
            System.out.print("");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    /**
     * 引入模板设计模式
     */
    @Test
    public void demo2(){
        MyClass d = new MyClass();
        System.out.println(d.getTime());
    }



}


abstract class MyTimeable {
    public final long getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();
}

class MyClass extends MyTimeable {

    @Override
    public void code() {
        for(int i = 0; i < 10000000; i++) {
            System.out.print("");
        }
    }
}
