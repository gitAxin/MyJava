package cn.giteasy.jdk5;

import java.util.Arrays;

import static java.util.Arrays.sort;			//静态导入
import static java.util.Arrays.toString;			//静态导入

public class Demo02StaticImport {

	/**
	 * 	* A:静态导入概述
	 * 		静态导入是导入类中静态方法
		* B:格式：
			* import static 包名….类名.方法名;
			* 可以直接导入到方法的级别
		* C:注意事项
			* 方法必须是静态的,如果有多个同名的静态方法，容易不知道使用谁?这个时候要使用，必须加前缀。由此可见，意义不大，所以一般不用，但是要能看懂。
	 	静态导入开发不用,但是需要能看懂
	 */
	public static void main(String[] args) {
		int[] arr = {55,22,33,44,11};

		//本类中也有一个sort方法,容易不知道使用的是上面静态导入的sort方法,还是本类中的sort方法
		sort(arr);							//排序

		/*
		* 下在这一行编译错误,因为当前类中也有一个toString方法,是从Object继续来的,
		* 这里编译器会调用是继承过来的toString方法,不能直接调用,因为静态方法中没有this,所以报错
		* 所以静态导入,意义不大，所以一般不用，但是要能看懂。
		*/
		//System.out.println(toString(arr));


	}

	public static void sort(int[] arr) {

	}
	

}
