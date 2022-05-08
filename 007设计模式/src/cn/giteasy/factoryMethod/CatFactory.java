package cn.giteasy.factoryMethod;

/**
 * Demo class
 *
 * @author axin
 * @date 2022/5/8
 */
public class CatFactory  implements Factory{


    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
