package cn.giteasy.wrapclass;

public class Demo02Integer {

	/**
	 * * A:Integer类概述
			* 通过JDK提供的API，查看Integer类的说明
		
			* Integer 类在对象中包装了一个基本类型 int 的值,
			* 该类提供了多个方法，能在 int 类型和 String 类型之间互相转换，
			* 还提供了处理 int 类型时非常有用的其他一些常量和方法
		* B:构造方法
			* public Integer(int value)
			* public Integer(String s)
	 */
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);//2147483647
		System.out.println(Integer.MIN_VALUE);//-2147483648
		
		Integer i1 = new Integer(100);
		System.out.println(i1);//100

		/*
			java.lang.NumberFormatException数字格式异常
			因为abc不是数字字符串,所以转换会报错
		 */
		//Integer i2 = new Integer("abc");
		//System.out.println(i2);
		
		Integer i3 = new Integer("100");
		System.out.println(i3);//100
	}

}
