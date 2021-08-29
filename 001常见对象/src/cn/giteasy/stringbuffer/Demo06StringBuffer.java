package cn.giteasy.stringbuffer;

public class Demo06StringBuffer {

	/**
	 * * A:String -- StringBuffer
		* a:通过构造方法
		* b:通过append()方法
	* B:StringBuffer -- String
		* a:通过构造方法
		* b:通过toString()方法
		* c:通过subString(0,length);

	 */
	public static void main(String[] args) {
		//demo1();
		StringBuffer sb = new StringBuffer("hello world");

		//通过构造将StringBuffer转换为String
		String s1 = new String(sb);
		System.out.println(s1);

		//通过toString方法将StringBuffer转换为String
		String s2 = sb.toString();
		System.out.println(s2);

		//通过截取子字符串将StringBuffer转换为String
		String s3 = sb.substring(0, sb.length());
		System.out.println(s3);
	}

	private static void demo1() {
		//通过构造方法将字符串转换为StringBuffer对象
		StringBuffer sb1 = new StringBuffer("hello world");
		System.out.println(sb1);

		//通过append方法将字符串转换为StringBuffer对象
		StringBuffer sb2 = new StringBuffer();
		sb2.append("hello world");
		System.out.println(sb2);
	}

}
