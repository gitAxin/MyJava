package cn.giteasy.generic;

import cn.giteasy.common.Student;
import cn.giteasy.common.Worker;

public class Demo05Generic {

	/**
	 * 泛型方法的使用
	 */
	public static void main(String[] args) {
		MethodTool<Student> tool = new MethodTool<>();
		tool.setObj(new Student("sally",18));
		Student obj = tool.getObj();
		System.out.println(obj);//Person [name=sally, age=18]

		//print()方法可以传入其他类型,因为在方法上单独定义了类型
		tool.print(new Worker("david",19));//Worker [name=david, age=19]


	}



}


class MethodTool<Q> {
	private Q q;

	public Q getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}

	/**
	 * 方法上定义了单独的泛型
	 * @param e
	 * @param <E>
	 */
	public<E> void print(E e){
		System.out.println(e);
	}

}
