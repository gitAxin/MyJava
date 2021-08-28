package cn.giteasy.string;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/8/28
 */
public class Demo01String {
    public static void main(String[] args) {
        //abc和def是两个对象
        String str = "abc";
        //String对象是不可改变的，即abc这个对象不可改变，
        //当再次赋值为def时，其实是又创建了一个对象def,将这个def的地址值赋值给了str，
        //之前的abc变为了垃圾
        str = "def";
        System.out.println(str);
    }
}
