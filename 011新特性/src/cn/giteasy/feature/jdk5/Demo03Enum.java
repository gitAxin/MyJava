package cn.giteasy.feature.jdk5;

import org.junit.Test;

/**
 * 枚举类的常见方法
 *      int ordinal()
 *      int compareTo(E o)
 *      String name()
 *      String toString()
 *      <T> T valueOf(Class<T> type,String name)
 *      values()
 *      此方法虽然在JDK文档中查找不到，但每个枚举类都具有该方法，它遍历枚举类的所有枚举值非常方便
 *
 * @author axin
 * @date 2022/5/21
 */
public class Demo03Enum {


    /**
     * 枚举类的常见方法
     *  int ordinal()
     */
    @Test
    public void demo1(){
        MyEnum value1 = MyEnum.Value1;
        MyEnum value2 = MyEnum.Value2;
        MyEnum value3 = MyEnum.Value3;

        /**
         *  获取实例名称
         */
        System.out.println("获取实例名称:");
        System.out.println(value1.getName());
        //调用重写之后的toString
        System.out.println(value1.toString());


        /**
         * 枚举项都是有编号的
         */
        System.out.println("枚举项都是有编号的:");
        System.out.println(value1.ordinal());//0
        System.out.println(value2.ordinal());//1
        System.out.println(value3.ordinal());//2



        /**
         * 枚举项比较的都是编号
         */
        System.out.println("枚举项比较的都是编号:");
        int i1 = value1.compareTo(value2);
        System.out.println(i1);
        int i2 = value1.compareTo(value3);
        System.out.println(i2);


    }


    /**
     * 通过字节码文件获取枚举项对象
     *  <T> T valueOf(Class<T> type,String name)
     */
    @Test
    public void demo2(){
        MyEnum value = MyEnum.valueOf(MyEnum.class, "Value2");

        System.out.println(value.toString());

        /**
         * 输出结果：
         *
         * MyEnum{name='Value2'}
         */
    }


    /**
     * 遍历枚举类所有枚举项
     * values()
     *  此方法虽然在JDK文档中查找不到，但每个枚举类都具有该方法。
     */
    @Test
    public void demo3(){
        MyEnum[] values = MyEnum.values();
        for (MyEnum value : values) {
            System.out.println(value);
        }

        /**
         * 输出结果：
         *
         * MyEnum{name='Value1'}
         * MyEnum{name='Value2'}
         * MyEnum{name='Value3'}
         */
    }


}



enum MyEnum{
    Value1("Value1"),
    Value2("Value2"),
    Value3("Value3");

    private String name;
    private MyEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}