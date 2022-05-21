package cn.giteasy.feature.jdk5;

import org.junit.Test;

/**
 *
 * 通过enum实现枚举类
 *  使用JDK5新增的enum关键字声明枚举类
 *
 * 注意事项
 *  定义枚举类要用关键字enum
 *  所有枚举类都是Enum的子类
 *  枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
 *  枚举类可以有构造器，但必须是private的，它默认的也是private的。
 *  枚举类也可以有抽象方法，但是枚举项必须重写该方法
 *
 *
 *
 * @author axin
 * @date 2022/5/21
 */
public class Demo02Enum {


    /**
     * 测试无参构造的枚举类
     */
    @Test
    public void demo1(){
        Week mon = Week.MON;
        Week tue = Week.TUE;
        Week wed = Week.WED;
        System.out.println(mon);
        System.out.println(tue);
        System.out.println(wed);
    }


    /**
     * 测试带参构造的枚举类
     */
    @Test
    public void demo2(){
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;
        System.out.println(mon.getName());
        System.out.println(tue.getName());
        System.out.println(wed.getName());
    }


    /**
     *带抽象方法的枚举类
     */
    @Test
    public void demo3(){
        Week3 mon = Week3.MON;
        Week3 tue = Week3.TUE;
        Week3 wed = Week3.WED;

        mon.show();
        tue.show();
        wed.show();
        System.out.println("===================");
        System.out.println(mon.getName());
        System.out.println(tue.getName());
        System.out.println(wed.getName());
    }

    /**
     * 枚举在switch语句中的使用
     *
     * switch可接收哪些类型？
     *  基本类型：byte short int char
     *  1.5版本起可以接收enum
     *  1.7版本起可以接收string
     *
     */
    @Test
    public void demo4(){
        Week mon = Week.TUE;
        switch (mon){
            case MON:
                System.out.println("星期一");
            break;
            case TUE:
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
            default:
                System.out.println("其他");
                break;
        }



    }


}


/**
 * 定义枚举类要用关键字enum
 */
enum Week{
    /**
     * 枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
     */
    MON,TUE,WED;
}


/**
 * 枚举类可以有构造器，但必须是private的，它默认的也是private的。
 */
enum Week2{
    MON("星期一"),TUE("星期二"),WED("星期三");

    private String name;
    private Week2(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 枚举类也可以有抽象方法，但是枚举项必须重写该方法
 */
enum Week3{
    MON("星期一"){
        @Override
        public void show() {
            System.out.println("show 星期一");
        }
    },TUE("星期二"){
        @Override
        public void show() {
            System.out.println("show 星期二");
        }
    },WED("星期三"){
        @Override
        public void show() {
            System.out.println("show 星期三");
        }
    };

    public abstract void show();
    private String name;
    private Week3(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}