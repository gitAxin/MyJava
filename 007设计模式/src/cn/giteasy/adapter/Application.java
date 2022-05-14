package cn.giteasy.adapter;

/**
 * 适配器设计模式
 *
 * 1.什么是适配器
 *    在使用监听器的时候, 需要定义一个类事件监听器接口.
 *    通常接口中有多个方法, 而程序中不一定所有的都用到, 但又必须重写, 这很繁琐.
 *    适配器简化了这些操作, 我们定义监听器时只要继承适配器, 然后重写需要的方法即可.
 * 2.适配器原理
 *    适配器就是一个类, 实现了监听器接口, 所有抽象方法都重写了, 但是方法全是空的.
 *    适配器类需要定义成抽象的,因为创建该类对象,调用空方法是没有意义的
 *    目的就是为了简化程序员的操作, 定义监听器时继承适配器, 只重写需要的方法就可以了.
 *
 * @author axin
 * @date 2022/5/14
 */
public class Application {

    private ProcessListener listener;

    public Application(ProcessListener listener) {
        this.listener = listener;
    }

    public static void main(String[] args) {

        /**
         * 使用接口创建匿名内部类时，需要重写所有的方法
         */
        new Application(new ProcessListener() {
            @Override
            public void beforeCreate() {

            }

            @Override
            public void afterCreate() {

            }

            @Override
            public void beforeSave() {

            }

            @Override
            public void afterSave() {

            }

            @Override
            public void beforeComplete() {

            }

            @Override
            public void afterComplete() {

            }
        });

        /**
         * 使用装饰类创建匿名内部类时，只需要重写要使用的方法
         */
        new Application(new ProcessAdapter() {
            @Override
            public void afterSave() {
                //TODO
            }
        });





    }


}
