package cn.giteasy.exception;

import org.junit.Test;

public class Demo03Exception {

	/**
	 * A:案例演示
	 * 		try...catch的方式处理多个异常
	 * 		JDK7以后处理多个异常的方式及注意事项
	 * 
	 * 			安卓:客户端开发,如何处理异常?
     *
     * 		        try{
     *
     * 		        }catch(Exception e){
     *
     * 		        }
     *
	 * 			javaEE:服务端开发,一般都是底层开发,从底层向上抛
	 * 
	 *
	 */



	@Test
	public void demo1() {
		int a = 10;
		int b = 0;
		int[] arr = {11,22,33,44,55};


		//try后面如果跟多个catch,那么小的异常放前面,大的异常放后面,根据多态的原理,如果大的放前面,就会将所有的子类对象接收后面的catch就没有意义了

		try {
			System.out.println(a / b);
			System.out.println(arr[10]);
			arr = null;
			System.out.println(arr[0]);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为零");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("索引越界了");
		} catch (Exception e) {				//Exception e = new NullPointerException();
			System.out.println("出错了");
		}


		
		System.out.println("over");
	}


	/**
	 * JDK7特性：新的异常处理方式
	 *
	 *  	try{
	 *
	 *       }catch(异常名1 | 异常名2 | ....){
	 *
	 *       }
	 *
	 *       注意事项：
	 *         这个方法虽然简单，但不实用
	 */
	@Test
	public void demo2() {
		int a = 10;
		int b = 0;
		int[] arr = {11,22,33,44,55};


		try {
			System.out.println(a / b);
			System.out.println(arr[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("出错了");
		}
	}

}
