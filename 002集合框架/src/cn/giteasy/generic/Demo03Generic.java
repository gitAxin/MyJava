package cn.giteasy.generic;

import cn.giteasy.common.Student;
import cn.giteasy.common.Worker;

public class Demo03Generic {

	/**
	 * 泛型的由来
	 * 早期的Object类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。也就存在这隐患，所以Java提供了泛型来解决这个安全问题。
	 */
	public static void main(String[] args) {
		demo1();
	}

	public static void demo1() {
		Tool t = new Tool();					//创建工具类对象
		t.setObj(new Student("张三",23));
		
		Worker w = (Worker) t.getObj();			//向下转型,编译无错误,但运行时异常 java.lang.ClassCastException
		System.out.println(w);
	}

}


class Tool {
	private Object q;

	public Object getObj() {
		return q;
	}

	public void setObj(Object q) {
		this.q = q;
	}

}