package cn.giteasy.test;

import org.junit.Test;

import java.math.BigInteger;

/**
 *  需求:
 *  求1000的阶乘所有零和尾部零的个数
 */

public class Test06 {


	/**
	 * 求1000的阶乘所有零和尾部零的个数
	 */
	@Test
	@Deprecated
	public void test1(){
		int result = 1;
		for(int i = 1; i <= 1000; i++) {
			result = result * i;
		}
		//因为1000的阶乘远远超出了int的取值范围
		System.out.println(result);//0

	}

	/**
	 * 使用BigInteger
	 * 求1000的阶乘结果中所有零的个数
	 */
	@Test
	public void test2() {

		BigInteger bi1 = new BigInteger("1");
		for(int i = 1; i <= 1000; i++) {
			BigInteger bi2 = new BigInteger(i+"");
			//将bi1与bi2相乘的结果赋值给bi1
			bi1 = bi1.multiply(bi2);
		}
		//获取字符串表现形式
		String str = bi1.toString();
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if('0' == str.charAt(i)) {	//如果字符串中出现了0字符
				count++;				//计数器加1
			}
		}
		System.out.println("共有 "+ count + "  个零");//472
	}

	/**
	 * 求1000的阶乘结果中尾部零的个数
	 */
	@Test
	public void test3() {
		BigInteger bi1 = new BigInteger("1");
		for(int i = 1; i <= 1000; i++) {
			BigInteger bi2 = new BigInteger(i+"");
			bi1 = bi1.multiply(bi2);	//将bi1与bi2相乘的结果赋值给bi1
		}
		//获取字符串表现形式
		String str = bi1.toString();
		StringBuilder sb = new StringBuilder(str);
		//反转字符串
		str = sb.reverse().toString();	  //链式编程

		//定义计数器
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if('0' != str.charAt(i)) {
				break;
			}else {
				count++;
			}
		}

		System.out.println("尾部共有 "+ count + "  个零");//249
	}



	/**
	 * 递归求1000的阶乘结果中尾部零的个数
	 * 5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100...1000  	1000 / 5 = 200
	 * 5*5	5*5*2 	5*5*3	5*5*4	5*5*5	5*5*6							200 / 5 = 40
	 * 5*5*5*1 5*5*5*2	5*5*5*3	5*5*5*4	5*5*5*5	5*5*5*6	5*5*5*7	5*5*5*8		40 / 5 = 8
	 * 5*5*5*5																8 / 5 = 1
	 */
	@Test
	public void test4() {
		int count = fun(1000);
		System.out.println("尾部共有 "+ count + "  个零");//249
	}

	public int fun(int num) {
		if(num > 0 && num < 5) {
			return 0;
		}else {
			return num / 5 + fun(num / 5);
		}
	}


}
