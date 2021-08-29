package cn.giteasy.stringbuffer;

public class Demo07StringBuffer {

	/**
	 * * A:形式参数问题
			* String作为参数传递
			* StringBuffer作为参数传递 
		* B:案例演示
			* String和StringBuffer分别作为参数传递问题
			* 
	基本数据类型的值传递,不改变其值
	引用数据类型的值传递,改变其值
	
	String类虽然是引用数据类型,但是他当作参数传递时和基本数据类型是一样的
	 */
	public static void main(String[] args) {
		String s = "hello world!";
		System.out.println(s);//hello world!
		change(s);
		System.out.println(s);//hello world!
		
		
		System.out.println("---------------------");
		StringBuffer sb = new StringBuffer();
		sb.append("hello world!");
		System.out.println(sb);//hello world!
		change(sb);
		System.out.println(sb);//hello world!你好,世界!
	}

	public static void change(StringBuffer sb) {
		sb.append("你好,世界!");
	}

	public static void change(String s) {
		s += "你好,世界!";
	}

}
