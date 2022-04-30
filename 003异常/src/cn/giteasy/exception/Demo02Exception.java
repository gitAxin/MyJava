package cn.giteasy.exception;

import org.junit.Test;

public class Demo02Exception {

	/**
	 *  A:异常处理的两种方式
 	 * 		a:try…catch…finally
	 * 			try catch
	 * 			try catch finally
	 * 			try finally
	 * 		b:throws
	 * 	B:try...catch处理异常的基本格式
	 * 		try…catch…finally
	 * 	C:案例演示
	 * 		try...catch的方式处理1个异常
	 *
	 *	try:用来检测异常的
	 *	catch:用来捕获异常的
	 *	finally:释放资源
	 */
	@Test
	public void demo1(){
		TestUtil util = new TestUtil();
		try{
			int x = util.div(10, 0);
			System.out.println(x);
		}catch(ArithmeticException a) {		//ArithmeticException a = new ArithmeticException();
			System.out.println("出错了,除数为零了");
		}

		//当通过trycatch将问题处理了,程序会继续执行
		System.out.println("2022-04-30.........");
	}

}

class TestUtil {
	/**
	 * 除法运算
	 */
	public int div(int a,int b) {		//a = 10,b = 0
		return a / b;					// 10 / 0  被除数是10,除数是0当除数是0的时候违背了算数运算法则,抛出异常
										//new ArithmeticException("/ by zero");
	}
} 
