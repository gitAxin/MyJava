package cn.giteasy.biginteger;

import java.math.BigInteger;
import java.util.Arrays;

public class Demo01BigInteger {

	/**
	 ** A:BigInteger的概述
			* 可以让超过Integer范围内的数据进行运算
		* B:构造方法
			* public BigInteger(String val)
		* C:成员方法
			* public BigInteger add(BigInteger val)
			* public BigInteger subtract(BigInteger val)
			* public BigInteger multiply(BigInteger val)
			* public BigInteger divide(BigInteger val)
			* public BigInteger[] divideAndRemainder(BigInteger val)
	 */
	public static void main(String[] args) {
		//long num = 123456789098765432123L; //超出范围,编译异常
		//String s = "123456789098765432123"; //可以使用字符串表示
		
		BigInteger bi1 = new BigInteger("100");
		BigInteger bi2 = new BigInteger("2");
		
		System.out.println(bi1.add(bi2)); 				//+
		System.out.println(bi1.subtract(bi2));			//-
		System.out.println(bi1.multiply(bi2)); 			//*
		System.out.println(bi1.divide(bi2));    		///(除)


		BigInteger bi3 = new BigInteger("100");
		BigInteger bi4 = new BigInteger("3");
		BigInteger[] arr = bi3.divideAndRemainder(bi4);	//取除数和余数
		System.out.println(Arrays.toString(arr));//[33, 1] //33是商 1是余额
	}

}
