package cn.giteasy.feature.jdk7;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDK7新特性
 *  1. 支持二进制字面量
 *  2. 数字字面量可以出现下划线
 *  3. switch 语句支持符串
 *  4. 泛型简化,菱形泛型
 *  5. 异常的多个catch合并,每个异常之间使用或 “|”
 *  6. try-with-resources 语句
 *
 * @author axin
 * @date 2022/5/21
 */
public class Demo01JDK7 {

    /**
     * 二进制字面量
     */
    @Test
    public void demo1(){
        System.out.println(0b110);//6
    }

    /**
     * 数字字面量可以出现下划线
     */
    @Test
    public void demo2(){
        System.out.println(0b100_100);//36
        System.out.println(100_100);//100100
    }


    /**
     * switch 语句支持符串
     */
    @Test
    public void demo3(){
        String str = "2";
        switch (str){
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("3");
                break;
            default:
                System.out.println("其他");
                break;
        }

    }


    /**
     * 泛型简化
     */
    @Test
    public void demo4(){
        //JDK1.7之前
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();

        //JDK1.7起
        Map<String, Object> map2 = new HashMap<>();
        List<Object> list2 = new ArrayList<>();

    }

    /**
     * 异常的多个catch合并,每个异常之间使用或 “|”
     */
    @Test
    public void demo5(){

        try {
            FileInputStream fis = new FileInputStream("");
            Thread.sleep(1000);
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }


    }



    /**
     * try-with-resources 语句：自动关闭流
     *      try(...){}
     * 开发中一般不用
     * @throws IOException
     */
    @Test
    public void demo6() throws IOException {

        //在try()中书写的对象，都需要实现AutoCloseable接口
        try(
                FileInputStream fis = new FileInputStream("input.txt");
                FileOutputStream fos = new FileOutputStream("output.txt");
                MyClose mc = new MyClose();
        ){
            int b;
            while((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }




}


class MyClose implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("我关了");
    }
}
