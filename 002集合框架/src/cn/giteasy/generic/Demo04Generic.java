package cn.giteasy.generic;

import cn.giteasy.common.Student;
import cn.giteasy.common.Worker;

public class Demo04Generic {

	/**
	 * 泛型的由来
	 * 泛型类的使用
	 */
	public static void main(String[] args) {
		GenericTool<String> tool = new GenericTool<>();
		//tool.setObj(1);//编译错误
		tool.setObj("a");
		String obj = tool.getObj();
		System.out.println(obj);//a

		GenericTool<Student> tool2 = new GenericTool<>();
		tool2.setObj(new Student("axin",20));
		Student obj1 = tool2.getObj();
		System.out.println(obj1);//Person [name=axin, age=20]

	}



}


class GenericTool<Q> {
	private Q q;

	public Q getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}

}
