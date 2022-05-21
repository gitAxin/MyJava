package cn.giteasy.feature.jdk5;

import org.junit.Test;

/**
 * 代码实现枚举类
 *
 * 枚举概述
 *      是指将变量的值一一列出来,变量的值只限于列举出来的值的范围内。举例：一周只有7天，一年只有12个月等。
 * 单例设计模式：单例类是一个类只有一个实例
 *      那么多例类就是一个类有多个实例，但不是无限个数的实例，而是有限个数的实例，这才能是枚举类。
 *
 *
 * @author axin
 * @date 2022/5/21
 */
public class Demo01Enum {


    /**
     * 实现无参构造的枚举类测试
     */
    @Test
    public void demo1(){
        MonthEnum month_1 = MonthEnum.month_1;
        MonthEnum month_2 = MonthEnum.month_2;
        MonthEnum month_3 = MonthEnum.month_3;
    }


    /**
     * 实现有参构造的枚举类测试
     */
    @Test
    public void demo2(){
        MonthEnum2 month_1 = MonthEnum2.month_1;
        MonthEnum2 month_2 = MonthEnum2.month_2;
        MonthEnum2 month_3 = MonthEnum2.month_3;
        System.out.println(month_1);
        System.out.println(month_2);
        System.out.println(month_3);


    }


    /**
     * 使用抽象类
     */
    @Test
    public void demo3(){
        MonthEnum3 month_1 = MonthEnum3.month_1;
        MonthEnum3 month_2 = MonthEnum3.month_2;
        MonthEnum3 month_3 = MonthEnum3.month_3;

        month_1.show();
        month_2.show();
        month_3.show();
        System.out.println("=================");
        System.out.println(month_1);
        System.out.println(month_2);
        System.out.println(month_3);


    }


}


class MonthEnum{
    /**
     * 私有构造，不让外部创建实例
     */
    private MonthEnum(){

    }

    /**一月*/
    public static final MonthEnum month_1 = new MonthEnum();
    /**二月*/
    public static final MonthEnum month_2 = new MonthEnum();
    /**三月*/
    public static final MonthEnum month_3 = new MonthEnum();




}



class MonthEnum2{

    private String name;

    public MonthEnum2(String name){
        this.name = name;

    }

    public static final MonthEnum2 month_1 = new MonthEnum2("一月");
    public static final MonthEnum2 month_2 = new MonthEnum2("二月");
    public static final MonthEnum2 month_3 = new MonthEnum2("三月");



    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}


/**
 * 抽象类
 */
abstract class MonthEnum3{

    private String name;

    public MonthEnum3(String name){
        this.name = name;

    }


    /**
     * 添加抽象方法
     */
    public abstract void show();


    public static final MonthEnum3 month_1 = new MonthEnum3("一月"){
        @Override
        public void show() {
            System.out.println("show 一月");
        }
    };
    public static final MonthEnum3 month_2 = new MonthEnum3("二月"){
        @Override
        public void show() {
            System.out.println("show 二月");
        }
    };
    public static final MonthEnum3 month_3 = new MonthEnum3("三月"){
        @Override
        public void show() {
            System.out.println("show 三月");
        }
    };



    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name;
    }
}



