package cn.giteasy.exception;

public class Demo08Exception {

	/**
	 * A:为什么需要自定义异常
	 * 		通过名字区分到底是什么异常,有针对的解决办法
	 *  B:自定义异常概述
	 * 		继承自Exception
	 * 		继承自RuntimeException
	 * C:案例演示
	 *  	自定义异常的基本使用
	 */
	public static void main(String[] args) {
		Student student = new Student();
		try {
			student.setAge(200);
		} catch (AgeException e) {
			e.printStackTrace();
			e.getMessage();
		}


	}

}

/**
 * 继承Exception 或 RuntimeException区别？
 * 	Exception:编译时异常，需要显示处理
 * 	RuntimeException，运行时异常，不需要显示处理
 */
class AgeException extends /*Exception*/ RuntimeException{


	public AgeException() {
		super();
		
	}

	public AgeException(String message) {
		super(message);
		
	}
	
}

class Student{

	private int age;

	public void setAge(int age) throws AgeException {
		if(age < 0 || age >= 150){
			throw new AgeException("年龄非法！");
		}
		this.age = age;
	}
}