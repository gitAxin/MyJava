package cn.giteasy.exception;

public class Test01 {


	/**
	 * A:面试题1
	 * 		 final,finally和finalize的区别
	 * 		 final可以修饰类,不能被继承
	 * 		 修饰方法,不能被重写
	 * 		 修饰变量,只能赋值一次
	 *
	 * 		 finally是try语句中的一个语句体,不能单独使用,用来释放资源
	 *
	 * 		 finalize是一个方法,当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
	 *
	 * 	B:面试题2
	 *     如果catch里面有return语句，请问finally的代码还会执行吗?如果会，请问是在return前还是return后。答，会，在return后。
	 */
	public static void main(String[] args) {
		int res = method();
		System.out.println(res);
	}


	public static int method() {
		int x = 10;
		try {
			x = 20;
			System.out.println(1/0);
			return x;
		} catch (Exception e) {
			x = 30;
			return x; //虽然在此处，会执行finally，但是此时，return x; 会先执行，并保存一个返回路径，x=30 已经确定了并保存起来了，即使finally执行x=40,也并不会再改变保存起来的x=30
		} finally {
			x = 40;
			//return x;					千万不要在finally里面写返回语句,因为finally的作用是为了释放资源,是肯定会执行的
			//如果在这里面写返回语句,那么try和catch的结果都会被改变,所以这么写就是错误
		}
	}

}

