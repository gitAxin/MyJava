package cn.giteasy.random;

import java.util.Random;

public class Demo01Random {

	/**
	 * * A:Random类的概述
			* 此类用于产生随机数如果用相同的种子创建两个 Random 实例，
			* 则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
		* B:构造方法
			* public Random()
			* public Random(long seed)
		* C:成员方法
			* public int nextInt()
			* public int nextInt(int n)(重点掌握)
	 */
	public static void main(String[] args) {
		//Random r = new Random();
		///*int x = r.nextInt();
		//
		//System.out.println(x);*/
		//
		//for(int i = 0; i < 10; i++) {
		//	//System.out.println(r.nextInt());
		//	System.out.println(r.nextInt(100));			//要求掌握,生成在0到n范围内的随机数,包含0不包含n
		//}
		

		Random r2 = new Random(1001);
		
		int a = r2.nextInt();
		int b = r2.nextInt();
		int c = r2.nextInt();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		/*
			每次运行这个程序的输出结果都是以下三个数,这是给定的种子决定的
			-1245131070
			-2078988849
			-1097876307
		 */
	}

}
