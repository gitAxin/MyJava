package cn.giteasy.factory;

/**
 *
 * 简单工厂模式概述和使用
 *
 * 简单工厂模式概述
 *   又叫静态工厂方法模式，它定义一个具体的工厂类负责创建一些类的实例
 * 优点
 *   客户端不需要在负责对象的创建，从而明确了各个类的职责
 * 缺点
 *    这个静态工厂类负责所有对象的创建，如果有新的对象增加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利于后期的维护
 *
 * @author axin
 * @date 2022/5/8
 */
public class Application {

    public static void main(String[] args) {
        //Dog dog = AnimalFactory.createDog();
        //Cat cat =  AnimalFactory.createCat();
        //dog.eat();
        //cat.eat();


        Animal dog = AnimalFactory.createAnimal("dog");
        dog.eat();//狗吃肉

        Cat cat = (Cat) AnimalFactory.createAnimal("cat");
        cat.eat();//猫吃鱼

    }
}
