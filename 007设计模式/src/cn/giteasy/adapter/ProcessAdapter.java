package cn.giteasy.adapter;

/**
 *  ProcessListener类的装饰类，
 *
 *  声明为抽象：
 *  声明为抽象类的原因是创建本类对象也没有意义，方法都是空方法
 *
 * @author axin
 * @date 2022/5/14
 */
public abstract class ProcessAdapter implements ProcessListener{

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
}
